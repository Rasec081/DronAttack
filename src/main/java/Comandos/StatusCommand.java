/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Cliente.Cliente;
import Estructuras.Estructuras;
import Player.Player;
import Usuario.PantallaUsuario;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class StatusCommand implements ICommand {
    private static final String COMMAND_NAME = "Status"; 
    private Cliente cliente;
    private PantallaUsuario vista;
    
    public StatusCommand(Cliente cliente, PantallaUsuario vista) {
        this.cliente = cliente;
        this.vista = vista;
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        //aca debe de mostrar o retornar el estado de todas las estructuras que tiene el player
        String status= "";
        ArrayList<Estructuras> estructuras = cliente.getPlayer().getEstructuras();
        for (Estructuras estructura : estructuras) {
            String txt = "Tipo " + estructura.getTipo() + "     Vida" + estructura.getVida() + "    Posicion" + estructura.getPosicion() + "\n";
            status += txt;
        }
        vista.mostrarRespuestaComando(status);
       }
    
}
