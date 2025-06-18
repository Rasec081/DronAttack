/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Comandos.CommandManager;
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
        this.commandManager = new CommandManager(jugador); // el controlador de comandos
    }

    public void procesarComando(String texto) {
        String respuesta = commandManager.ejecutarComando(texto);
        vista.mostrarRespuestaComando(texto, respuesta);
    }

    public Player getJugador() {
        return jugador;
    }
}
