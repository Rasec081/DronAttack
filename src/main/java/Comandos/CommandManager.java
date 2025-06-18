/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import java.util.HashMap;

/**
 *
 * @author gambo
 */
public class CommandManager {
    //singleton    
    private static CommandManager commandManager;  
    //hash de ICommands: nombre, class que extiende ICommand
    
    //HashMap<String, Class<? extends ICommand>> 
    private static final HashMap<String, Class<? extends ICommand>> COMMANDS = new HashMap<>();      
    
    private CommandManager() {           
        //registCommand(EchoCommand.COMMAN_NAME, EchoCommand.class);          para que quede como ejemplo  
        registCommand(PlaceCommand.COMMAND_NAME, PlaceCommand.class);
    }       
    
    public static synchronized CommandManager getIntance() {           
        if (commandManager == null) {               
            commandManager = new CommandManager();   
        }
        return commandManager;   
    }       
    
    // obtiene un ICommand por nombre
    // obtiene una instancia con el nombre de la clase
    public ICommand getCommand(String commandName) {           
        if (COMMANDS.containsKey(commandName.toUpperCase())) {               
            try {   
                   //retorna nueva instancia de comando solicitado
                return COMMANDS.get(commandName.toUpperCase()).newInstance();
            } catch (Exception e) {   
                e.printStackTrace();  
                //retorna comando de error en la exception
                return new ErrorCommand();   
            }           
        } 
        else {
            // retorno de error comando no encontrado
            return new NotFoundCommand();   
        }   
    }
    
    // para registrar un comando, nombre y clase de tipo ICommand
    public void registCommand(String commandName, Class<? extends ICommand> command) {   
        COMMANDS.put(commandName.toUpperCase(), command);   
    }
}
