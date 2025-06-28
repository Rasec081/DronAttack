/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Cliente.Cliente;
import Player.Player;

/**
 *
 * @author Daniel
 */
public class ChatCommand extends BaseCommand {
    private static final String COMMAND_NAME = "Help";
    private Cliente cliente;

    public ChatCommand(Cliente cliente) {
        this.cliente = cliente; 
    }
    
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
