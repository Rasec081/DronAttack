/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Cliente.Cliente;
import Comandos.CommandFactory;
import Comandos.CommandManager;
import Comandos.ICommand;
import Player.Player;

/**
 *
 * @author Daniel
 */
public class ClienteController {
    private final Cliente cliente;//en vez de jugador, sea cliente y que para todo lo de player se haga con un cliente.getPlayer
    private final PantallaUsuario vista;
    private final CommandManager commandManager;

    public ClienteController(PantallaUsuario vista, Cliente cliente) {
        this.vista = vista;
        this.cliente = cliente;
        this.commandManager = CommandManager.getInstance(); // el controlador de comandos
        
        //aca llamamos/creamos a factory (se implemento así para implmenetar el commandFactory y que quede más ordenado)
        new CommandFactory(cliente, vista);
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

    public void procesarComando(String texto) {
        // Eliminar espacios extras y dividir el texto en partes
        String[] partes = texto.trim().split("\\s+"); // \\s+ divide por cualquier espacio en blanco

        // Verificar si hay al menos un comando
        if (partes.length == 0) {
            error(partes);
            return;
        }

        String nombreComando = partes[0].toLowerCase();
        ICommand comando = commandManager.getCommand(nombreComando);

        if (comando != null) {
            
            // Crear un nuevo array sin el nombre del comando para los argumentos
            String[] args = new String[partes.length];
            System.arraycopy(partes, 0, args, 0, partes.length );

            // Ejecutar el comando con los argumentos
            comando.execute(args);
        } else {
            noEncontrado(partes);
        }
    }

    public Player getJugador() {
        return cliente.getPlayer();
    }
    
    private void error(String[] partes){
        String nombreComando = "Error";
        String[] args = new String[partes.length];
        ICommand comando = commandManager.getCommand(nombreComando);
        comando.execute(args);
    }
    
    private void noEncontrado(String[] partes){
        String nombreComando = "NotFound";
        String[] args = new String[partes.length];
        ICommand comando = commandManager.getCommand(nombreComando);
        comando.execute(args);
    }
}
