/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Player.Player;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gambo
 */
public class CommandManager {

    private final Map<String, ICommand> comandos = new HashMap<>();

    public CommandManager(Player jugador) {
        comandos.put("help", new HelpCommand());
        comandos.put("status", new StatusCommand(jugador));
        // Agregás más comandos como place, scan, etc.
    }

    public String ejecutarComando(String input) {
        String[] partes = input.trim().split(" ");
        String nombre = partes[0].toLowerCase();
        ICommand comando = comandos.get(nombre);

        if (comando != null) {
            return comando.ejecutar();//aca tenemos que ver si recibe parametros
        } else {
            return "Comando desconocido. Escribe 'help' para ver los disponibles.";
        }
    }
    
}
