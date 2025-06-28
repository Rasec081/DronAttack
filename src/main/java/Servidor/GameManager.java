/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Arena.Mapa;
import Arena.TipoCelda;
import Mensajes.Mensaje;
import Mensajes.TipoMensaje;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */

public class GameManager {
    private final Servidor servidor;

    // Jugadores registrados
    private final Map<String, Mapa> mapas = new LinkedHashMap<>();
    
    

    public GameManager(Servidor servidor) {
        this.servidor = servidor;
    }

    public void procesarMapa(String nombre, Mapa mapa) throws IOException {
        //if (mapas.containsKey(nombre)) return;
        
        //aca revisamos cuanto hay en el hashmap, si es el primero 
        //lo guardamos como jugador 1, sino como jugador 2
        
        //una vez que lo guardemos le enviamos un mensaje a este para
        //setearle el nuevo nombre
        mapas.put(nombre, mapa);
        System.out.println("el clinete"+ nombre+" envio el mapa");
        System.out.println("el size de mapas es de: "+ mapas.size());
        if (mapas.size() == 2) {
            iniciarPartida();
            System.out.println("ya estan los 2 jugadres listos");
        }
    }

  private void iniciarPartida() {
    System.out.println("[SERVIDOR] Ambos jugadores listos. Iniciando partida...");

    for (int i = 0; i < 2; i++) {
        String nombre = (String) mapas.keySet().toArray()[i];
        Mensaje m = new Mensaje(nombre, TipoMensaje.INICIO_PARTIDA, "¡Comienza la partida!");
        try {
            servidor.enviarA(i, m);
        } catch (IOException ex) {
            Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i == 0){
            //aca enviamos el mensaje de que usted empieza 
            //turno en true
            Mensaje turno = new Mensaje("server", TipoMensaje.TURNO, true);
            try {
                servidor.enviarA(i, turno);
            } catch (IOException ex) {
                System.out.println(ex + "fallo al enviar el mensaje de turno");
            }
        }else{
            //aca le enviamos el mensaje de que turno va a estar en false
            Mensaje turno = new Mensaje("server", TipoMensaje.TURNO, false);
            try {
                servidor.enviarA(i, turno);
            } catch (IOException ex) {
                System.out.println(ex + "fallo al enviar el mensaje de turno");
                }
            }
        
        }
    }
  
    public void enviarMensajeChat(Mensaje mensaje) {
        String contenido = (String) mensaje.getContenido();
        Mensaje msj = new Mensaje("Server", TipoMensaje.CHAT_SERVER, contenido);
        servidor.transmision(msj);
  }
    
    public void manejarAtaque(Mensaje mensaje){
        String atacante = mensaje.getEnviador();
        ArrayList<Point> puntos = (ArrayList<Point>) mensaje.getContenido();

        String defensor = null;
        for (String nombre : mapas.keySet()) {
            if (!nombre.equals(atacante)) {
                defensor = nombre;
                break;
            }
        }

        if (defensor == null) return;
        Mapa mapaEnemigo = mapas.get(defensor);
        boolean huboImpacto = false;

        for (Point punto : puntos) {
            if (!mapaEnemigo.estaDentro(punto.x, punto.y)) continue;

            TipoCelda tipo = mapaEnemigo.getCelda(punto.x, punto.y).getTipo();
            boolean esEstructura = tipo == TipoCelda.CUARTEL || tipo == TipoCelda.RADAR ||
                                   tipo == TipoCelda.TORRE || tipo == TipoCelda.DEPOSITO;
            
            TipoCelda enviar = TipoCelda.NIEBLA;
            if (esEstructura) {
                mapaEnemigo.setCelda(punto.x, punto.y, TipoCelda.DESTRUIDA);
                enviar = TipoCelda.DESTRUIDA;
                huboImpacto = true;
            } else {
                mapaEnemigo.setCelda(punto.x, punto.y, TipoCelda.ATACADO);
                enviar=TipoCelda.ATACADO;
            }
            
            PaqueteMapas paquete = new PaqueteMapas(punto, enviar);
            // Actualización de mapas (se envía a ambos jugadores)
            Mensaje updateAtacante = new Mensaje("Servidor", TipoMensaje.ACTUALIZAR_MAPA_ENEMIGO, paquete);
            Mensaje updateDefensor = new Mensaje("Servidor", TipoMensaje.ACTUALIZAR_MAPA_PROPIO, paquete);

            try {
                servidor.enviarA(nombreAIndice(atacante), updateAtacante);
                
                servidor.enviarA(nombreAIndice(defensor), updateDefensor);
                
            } catch (IOException ex) {
                System.out.println("Fallo al enviar actualizaciones de mapa: " + ex.getMessage());
            }
        }

        // ✅ Bonificación y mensajes si hubo impacto
        if (huboImpacto) {
            try {
                Mensaje bonus = new Mensaje("Servidor", TipoMensaje.ENERGIA_EXTRA, 30);
                servidor.enviarA(nombreAIndice(atacante), bonus);
            } catch (IOException ex) {
                System.out.println("Fallo al enviar energía o notificaciones: " + ex.getMessage());
            }
        } 
        
        try {
            servidor.enviarA(nombreAIndice(defensor),
                    new Mensaje("Servidor", TipoMensaje.TURNO, true));
            servidor.enviarA(nombreAIndice(atacante), 
                        new Mensaje("Servidor", TipoMensaje.TURNO, false));
        } catch (IOException ex) {
            System.out.println("fallo extrepitosamente al cambia de turno");
        }
    }
    
    private int nombreAIndice(String nombre) {
        int i = 0;
        for (String n : mapas.keySet()) {
            if (n.equals(nombre)) return i;
            i++;
        }
        return -1;
    }
    
    
}