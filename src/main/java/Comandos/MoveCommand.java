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
        //segun yo, este comando lo que va a hacer es trasladar una structura a
        //otra casilla
        
        /*
        para esto debe de recibir estructura,posicion
        y modificar la matriz (verificando si el espacion aun no le cae bombas)
        una vez que la tiene modificada se la vuelve a 
        enviar al server para que este la actualice
        */
        System.out.println("Soy "+COMMAND_NAME+" y digamos que estoy haciendo algo");
    }
}
