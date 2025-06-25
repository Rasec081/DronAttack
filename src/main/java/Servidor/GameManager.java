/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Arena.Mapa;
import Mensajes.Mensaje;
import Mensajes.TipoMensaje;
import java.io.IOException;
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
        int numero = mapas.size(); // 1 o 2
        String nombreLogico = "Jugador " + numero;
        

        System.out.println("[SERVIDOR] " + nombre + " asignado como " + nombreLogico);

        // ✅ Pedirle al servidor que le envíe el rol
        Mensaje mRol = new Mensaje("Server", TipoMensaje.ASIGNACION_NOMBRE, nombreLogico);
        servidor.enviarA(numero - 1, mRol); // índice 0 o 1
        
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
    }
}
}