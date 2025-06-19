/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Usuario.PantallaUsuario;

public class NotFoundCommand extends BaseCommand {       
    private static final String COMMAND_NAME = "NOT FOUND";       
    private PantallaUsuario vista;

    public NotFoundCommand(PantallaUsuario vista) {
        this.vista = vista;
    }
        
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }       
    
    @Override       
    public void execute(String[] args) {           
        vista.mostrarRespuestaComando("Comando no encontrado \nEscribe 'help' para ver los disponibles.");
    }   
}