/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Comandos.CommandManager;
import Player.Player;
import Usuario.PantallaUsuario;

/**
 *
 * @author Daniel
 */
public class CommandFactory {
    private final Player jugador;
    private final PantallaUsuario vista;
    //segun yo, no ocupamos otro command manager porque es singleton
    private final CommandManager commandManager;

    public CommandFactory(Player jugador, PantallaUsuario vista) {
        this.jugador = jugador;
        this.vista = vista;
        commandManager = CommandManager.getInstance();
        factory();
    }
    
    private void factory(){
        
        //Comando para mostrar el estado de las bases del usuario
        commandManager.registrar("status", new StatusCommand(jugador, vista));
        
        //comando que muestra todos los comandos
        commandManager.registrar("Help", new HelpCommand(vista));
        
        //Este aun no se que hace
        commandManager.registrar("Send", new SendCommand(jugador, vista));
        
        //Comando que escanea el mapa enemigo con base a un punto (necesita sockets)
        commandManager.registrar("Scan", new ScanCommand(jugador, vista));
        
        //aun no entiendo que hace
        commandManager.registrar("Move", new MoveCommand(jugador, vista));
        
        //Comando que posiciona una estructura en el mapa del usuario (para el inicio de la partida)
        commandManager.registrar("Place", new PlaceCommand(jugador, vista));
        
        //Este ocupa sockets entonces aun no
        commandManager.registrar("Chat", new ChatCommand(jugador));
        
        //comando de error con un comando
        commandManager.registrar("Error", new ErrorCommand(vista));
        
        //Comando para cuando no se encuentra un comando
        commandManager.registrar("NotFound", new NotFoundCommand(vista));
    }
    
}
