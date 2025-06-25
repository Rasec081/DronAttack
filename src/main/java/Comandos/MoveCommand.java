/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Cliente.Cliente;
import Player.Player;
import Usuario.PantallaUsuario;

/**
 *
 * @author Daniel
 */
public class MoveCommand implements ICommand {
    private static final String COMMAND_NAME = "Move"; 
    private Cliente cliente;
    private PantallaUsuario vista;
    
    public MoveCommand(Cliente cliente, PantallaUsuario vista) {
        this.cliente = cliente;
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
