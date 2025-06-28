/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Cliente.Cliente;
import Mensajes.Mensaje;
import Mensajes.TipoMensaje;
import Player.Player;
import Usuario.PantallaUsuario;
import java.awt.Point;

/**
 *
 * @author Daniel
 */
public class SendCommand implements ICommand {
    private static final String COMMAND_NAME = "Send"; 
    private Cliente cliente;
    private PantallaUsuario vista;
    
    public SendCommand(Cliente cliente, PantallaUsuario vista) {
        this.cliente = cliente;
        this.vista = vista;
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
//        if(!cliente.getPlayer().isTurno()){
//            vista.mostrarNotificacion("No se encuentra en su turno");
//        }
//        
//         Player player = cliente.getPlayer();
//
//        if (args.length < 4) {
//            vista.mostrarRespuestaComando("Uso: send <tipo> <x> <y>");
//            return;
//        }
//
//        // ✅ Validar que el cuartel esté activo
//        if (!player.estructuraActiva(Arena.TipoCelda.CUARTEL)) {
//            vista.mostrarRespuestaComando("No se pueden enviar drones. El cuartel ha sido destruido.");
//            return;
//        }
//
//        String tipo = args[1];
//        int x, y;
//        try {
//            x = Integer.parseInt(args[2]);
//            y = Integer.parseInt(args[3]);
//        } catch (NumberFormatException e) {
//            vista.mostrarRespuestaComando("Coordenadas inválidas.");
//            return;
//        }
//
//        // ✅ Crear el dron usando el Factory Method
//        //Dron dron = DronFactory.crearDron(tipo, new Point(x, y));
//        if (dron == null) {
//            vista.mostrarRespuestaComando("Tipo de dron inválido: " + tipo);
//            return;
//        }
//
//        // ✅ Validar energía
//        if (player.getEnergia() < dron.getCostoEnergia()) {
//            vista.mostrarRespuestaComando("No tienes suficiente energía para enviar este dron.");
//            return;
//        }
//
//        // ✅ Descontar energía
//        player.restarEnergia(dron.getCostoEnergia());
//
//        // ✅ Enviar al servidor un mensaje con el tipo de dron y la posición
//        Mensaje ataque = new Mensaje(
//                player.getNombre(),
//                TipoMensaje.ATAQUE,
//                dron
//        );
//
//        try {
//            cliente.getThreadCliente().getManejadorEnvio().enviarMensaje(ataque);
//            vista.mostrarRespuestaComando("Dron " + tipo + " enviado a (" + x + ", " + y + ").");
//        } catch (Exception e) {
//            vista.mostrarRespuestaComando("Error al enviar dron al servidor.");
//        }

        // ✅ (Opcional) Notificar observers si tenés lógica local
    
     }
}
