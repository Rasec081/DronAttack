/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Usuario.PantallaUsuario;

/**
 *
 * @author Daniel
 */
public class HelpCommand implements ICommand {
    private static final String COMMAND_NAME = "Help"; 
    private PantallaUsuario vista;
    
    public HelpCommand(PantallaUsuario vista) {
        this.vista = vista;
    }

    @Override
    public String getCommandName() {
       return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        String help = ("""
            Comandos disponibles:
            help                         → muestra esta ayuda
            status                       → muestra estado de la base
            place <tipo> x y            → coloca estructura
            send <tipoDron> x y         → envía un dron
            move <idDron> x y           → mueve un dron
            scan x y                    → escanea una zona
            chat <mensaje>              → envía un mensaje al chat""");
        
        vista.mostrarRespuestaComando(COMMAND_NAME, help);
        }
    
}
