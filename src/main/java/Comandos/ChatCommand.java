/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Cliente.Cliente;
import Mensajes.Mensaje;
import Mensajes.TipoMensaje;
import Player.Player;
import java.io.IOException;

/**
 *
 * @author Daniel
 */
public class ChatCommand extends BaseCommand {
    private static final String COMMAND_NAME = "Help";
    private Cliente cliente;

    public ChatCommand(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 1) { //si viene vacio
            return;
        }
        // Unir el resto del mensaje (todo después de args[0] que es "chat")
        StringBuilder mensaje = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            mensaje.append(args[i]);
            if (i < args.length - 1) mensaje.append(" ");
        }
        
        String mensajeFinal = "["+cliente.getPlayer().getNombre()+"]: " + mensaje.toString();

        // Enviar el mensaje
        Mensaje msj = new Mensaje(cliente.getNombre(), TipoMensaje.CHAT_USER, mensajeFinal);
        try {
            cliente.getThreadCliente().getManejadorEnvio().enviarMensaje(msj);
        } catch (IOException e) {
            System.out.println("Error al enviar mensaje de chat: " + e.getMessage());
        }
    }
    
}
