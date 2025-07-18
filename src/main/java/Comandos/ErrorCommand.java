/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Usuario.PantallaUsuario;

public class ErrorCommand extends BaseCommand {       
    private static final String COMMAND_NAME = "ERROR";  
    private PantallaUsuario vista;

    public ErrorCommand(PantallaUsuario vista) {
        this.vista = vista;
    }
        
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }       
    
    @Override       
    public void execute(String[] args) {           
        vista.mostrarRespuestaComando(COMMAND_NAME + args[0] + "No válido");
    }   
}

