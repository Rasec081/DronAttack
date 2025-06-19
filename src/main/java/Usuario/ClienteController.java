/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Comandos.CommandFactory;
import Comandos.CommandManager;
import Comandos.ICommand;
import Player.Player;

/**
 *
 * @author Daniel
 */
public class ClienteController {
    private final Player jugador;
    private final PantallaUsuario vista;
    private final CommandManager commandManager;

    public ClienteController(PantallaUsuario vista, String nombreJugador) {
        this.vista = vista;
        this.jugador = new Player(nombreJugador); // el modelo
        this.commandManager = CommandManager.getInstance(); // el controlador de comandos
        
        //aca llamamos/creamos a factory (se implemento así para implmenetar el commandFactory y que quede más ordenado)
        new CommandFactory(jugador, vista);
    }
    
    private void configurarObservers() {
//        jugador.addObserver((o, arg) -> {
//            // Actualizar UI cuando cambia el modelo
//            vista.actualizarMapaPropio(jugador.getMapa().toArray());
//            vista.actualizarEstadisticas(
//                jugador.getEnergia(),
//                turnoActual,
//                jugador.cantEstructurasVivas()
//            );
//        });
    }

    public String procesarComando(String texto) {
        // Eliminar espacios extras y dividir el texto en partes
        String[] partes = texto.trim().split("\\s+"); // \\s+ divide por cualquier espacio en blanco

        // Verificar si hay al menos un comando
        if (partes.length == 0) {
            return "Error: No se ingresó ningún comando.";
        }

        String nombreComando = partes[0].toLowerCase();
        ICommand comando = commandManager.getCommand(nombreComando);

        if (comando != null) {
            // Crear un nuevo array sin el nombre del comando para los argumentos
            String[] args = new String[partes.length - 1];
            System.arraycopy(partes, 1, args, 0, partes.length - 1);

            // Ejecutar el comando con los argumentos
            comando.execute(args);
            return "holaa no se que poner";
        } else {
            return "Comando desconocido: " + nombreComando + ". Escribe 'help' para ver los disponibles.";
        }
    }

    public Player getJugador() {
        return jugador;
    }
}
