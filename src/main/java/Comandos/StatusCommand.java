/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Estructuras.Estructuras;
import Player.Player;
import Usuario.PantallaUsuario;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class StatusCommand implements ICommand {
    private static final String COMMAND_NAME = "Status"; 
    private Player jugador;
    private PantallaUsuario vista;
    
    public StatusCommand(Player jugador, PantallaUsuario vista) {
        this.jugador = jugador;
        this.vista = vista;
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        //aca debe de mostrar o retornar el estado de todas las estructuras que tiene el player
        String status= "";
        ArrayList<Estructuras> estructuras = jugador.getEstructuras();
        for (Estructuras estructura : estructuras) {
            String txt = "Tipo " + estructura.getTipo() + "     Vida" + estructura.getVida() + "    Posicion" + estructura.getPosicion() + "\n";
            status += txt;
        }
        vista.mostrarRespuestaComando(COMMAND_NAME, status);
       }
    
}
