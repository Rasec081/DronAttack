/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gambo
 */
public class CommandManager {
    //singleton    
    private static CommandManager commandManager;  

    //HashMap vacio por el momento
    private final Map<String, ICommand> comandos = new HashMap<>();
    
    //Crea un command manager con el hashMap vacio
    private CommandManager() { 
        
    }       
    
    //Metodo para settearle todos lo comando necesario
    public void registrar(String nombre, ICommand comando) {
        comandos.put(nombre.toLowerCase(), comando);
    }

    //Metodo para desde el ClienteController poder ejecutar el comando requerido por el usuario
    public ICommand getCommand(String nombre) {
        return comandos.get(nombre.toLowerCase());
    }
    
    //implementacion del singleton
    public static synchronized CommandManager getInstance() {           
        if (commandManager == null) {               
            commandManager = new CommandManager();   
        }
        return commandManager;   
    }       
    
}
