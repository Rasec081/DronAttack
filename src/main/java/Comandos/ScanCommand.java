/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Player.Player;
import Usuario.PantallaUsuario;

/**
 *
 * @author Daniel
 */
public class ScanCommand implements ICommand {
    private static final String COMMAND_NAME = "Scan"; 
    private Player jugador;
    private PantallaUsuario vista;
    
    public ScanCommand(Player jugador, PantallaUsuario vista) {
        this.jugador = jugador;
        this.vista = vista;
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Soy "+COMMAND_NAME+" y digamos que estoy haciendo algo");
    }
}
