/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Arena.TipoCelda;
import Cliente.Cliente;
import Player.Player;
import Usuario.PantallaUsuario;

/**
 *
 * @author Daniel
 */
public class ScanCommand implements ICommand {
    private static final String COMMAND_NAME = "Scan"; 
    private Cliente cliente;
    private PantallaUsuario vista;
    
    public ScanCommand(Cliente cliente, PantallaUsuario vista) {
        this.cliente = cliente;
        this.vista = vista;
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        if(cliente.getPlayer().tieneEstructuraDeTipo(TipoCelda.RADAR)){
            
        }
        System.out.println("Soy "+COMMAND_NAME+" y digamos que estoy haciendo algo");
    }
}
