/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Arena.Celda;
import Arena.Mapa;
import Arena.TipoCelda;
import static Arena.TipoCelda.CUARTEL;
import Cliente.Cliente;
import Estructuras.Cuartel;
import Estructuras.DepositoDeArmas;
import Estructuras.Estructuras;
import Estructuras.Radar;
import Estructuras.TorreDeComunicacion;
import Mensajes.Mensaje;
import Mensajes.TipoMensaje;
import Player.Player;
import Usuario.PantallaUsuario;
import java.awt.Point;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gambo
 */
public class PlaceCommand extends BaseCommand{
    public static final String COMMAND_NAME = "PLACE";
    private Cliente cliente;
    private PantallaUsuario vista;

    public PlaceCommand(Cliente cliente, PantallaUsuario vista) {
        this.cliente = cliente;
        this.vista = vista;
    }

    
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        Player player = cliente.getPlayer();
        // Verificar que hay suficientes argumentos
        if (args.length < 4) {
            System.out.println("Error: Faltan argumentos. Uso: place <estructura> <x> <y>");
            return;
        }
        
        if (player.tieneCuatroEstructuras()) {
            vista.mostrarRespuestaComando("Ya colocaste todas las estructuras.");
            return;
        }
        
        //no se si validar que ya emepzo el juego, porque en teoria con las 4 estructuras basta
        
        try {
            // Extraer y parsear los argumentos
            String tipoEstructura = args[1];  
            int x = Integer.parseInt(args[2]); 
            int y = Integer.parseInt(args[3]); 

            // Verificar si las coordenadas están dentro del mapa
            if (!cliente.getPlayer().getMapa().estaDentro(x, y)) {
                System.out.println("Coordenadas fuera del mapa.");
                return;
            }

            Celda celda = cliente.getPlayer().getMapa().getCelda(x, y);
            if (!celda.estaVacia()) {
                System.out.println("Ya hay algo en esa celda.");
                return;
            }

            // Aquí necesitarías convertir el String a tu tipo Estructura
            // Esto depende de cómo definas tus estructuras
            TipoCelda estructura = crearEstructuraDesdeString(tipoEstructura);
            if (estructura == null) {
                System.out.println("Tipo de estructura no válido: " + tipoEstructura);
                return;
            }
            
            // ❌ Estructura repetida
            if (player.tieneEstructuraDeTipo(estructura)) {
                vista.mostrarRespuestaComando("Ya colocaste una estructura de tipo " + tipoEstructura);
                return;
            }

            
            //Aca añadimos la estructura
            cliente.getPlayer().getMapa().getCelda(x, y).setTipo(estructura);
            Estructuras struct = crearEstructura(estructura, new Point(x, y));
            cliente.getPlayer().getEstructuras().add(struct);
            

            vista.mostrarRespuestaComando("Estructura " + tipoEstructura + " colocada en (" + x + ", " + y + ")");
            vista.actualizarMapaPropio(cliente.getPlayer().getMapa());
            
            
            // ✅ Si es la cuarta estructura: enviar mapa al servidor
            if (player.tieneCuatroEstructuras()) {
                Mensaje mensaje = new Mensaje(player.getNombre(), TipoMensaje.MAPA_COMPLETO, player.getMapa());
                cliente.getThreadCliente().getManejadorEnvio().enviarMensaje(mensaje);
                vista.mostrarRespuestaComando("Mapa completo enviado al servidor. Esperando al otro jugador...");
            }
        } catch (NumberFormatException e) {
            vista.mostrarRespuestaComando("Comando no funciono");
            System.out.println("Error: Las coordenadas deben ser números enteros");
        } catch (IOException ex) {
            System.out.println("Algo falló desde el comando place");
            ex.printStackTrace();
        }
    }
    
    private TipoCelda crearEstructuraDesdeString(String tipo) {
        // Implementación dependiente de tu sistema
        // Ejemplo básico:
        switch(tipo.toLowerCase()) {
            case "radar":
                return TipoCelda.RADAR;
            case "cuartel":
                return TipoCelda.CUARTEL;
            case "torre":
                return TipoCelda.TORRE;
            case "deposito":
                return TipoCelda.DEPOSITO;
            default:
                return null;
        }
    }
    
    private Estructuras crearEstructura (TipoCelda tipo, Point punto){
        Estructuras struct = null;
        
        switch (tipo) {
            case CUARTEL:
                struct = new Cuartel(TipoCelda.CUARTEL,punto);
                break;
                
             case RADAR:
                struct = new Radar(TipoCelda.RADAR,punto);
                break;
                
            case DEPOSITO:
                struct = new DepositoDeArmas(TipoCelda.DEPOSITO,punto);
                break;
                
            case TORRE:
                struct = new TorreDeComunicacion(TipoCelda.TORRE,punto);
                break;       
        }
        
        return struct;
    }
}
