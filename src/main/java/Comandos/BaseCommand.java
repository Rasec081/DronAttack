/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import java.io.OutputStream;

public abstract class BaseCommand implements ICommand {       
    
    @Override       
    public abstract String getCommandName();       
    
    @Override       
    public abstract void execute(String[] args);       
    
    // Este creo que no lo necesitamos, o hay que cambiarlo para el MVC
    public void write(OutputStream out, String message) {           
        try {   out.write(message.getBytes());   
                out.flush();           
        } 
        catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
}

