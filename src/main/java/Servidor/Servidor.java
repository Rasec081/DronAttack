/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Mensajes.Mensaje;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 *
 * @author gambo
 */

public class Servidor {
    final int PORT = 8084;
    private ServerSocket servidor;
    private ArrayList<ThreadServidor> clientesAceptados;
    private ConexionServidorThread conexionsThread;

    public Servidor(){
        this.clientesAceptados = new ArrayList<>();
        conectar();
        this.conexionsThread = new ConexionServidorThread(this);
        this.conexionsThread.start();
    }

    public ServerSocket getServidor() {
        return servidor;
    }

    public void setServidor(ServerSocket servidor) {
        this.servidor = servidor;
    }

    public ArrayList<ThreadServidor> getClientesAceptados() {
        return clientesAceptados;
    }

    public void setClientesAceptados(ArrayList<ThreadServidor> clientesAceptados) {
        this.clientesAceptados = clientesAceptados;
    }
    
    public void conectar(){
        try {
            servidor = new ServerSocket(PORT);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void transmision(Mensaje mensaje){
        synchronized (clientesAceptados) {
            for (ThreadServidor clienteTr : clientesAceptados) {
                try {
                    clienteTr.getSalidaDatos().writeObject(mensaje);
                    clienteTr.getSalidaDatos().flush();
                } catch (IOException ex) {
                    System.out.println("ERROR AL ENVIAR EL MENSAJE DESDE EL SERVER" + mensaje.getContenido());
                }
            }
        }
    }
    
//    public void aceptarClientes() {
//        new Thread(() -> {
//            try {
//                while (clientesAceptados.size() < 2) {
//                    Socket socketCliente = servidor.accept();
//                    System.out.println("[SERVIDOR] Cliente conectado desde " + socketCliente.getInetAddress());
//
//                    ThreadServidor nuevoCliente = new ThreadServidor(socketCliente, this);
//                    clientesAceptados.add(nuevoCliente);
//                    nuevoCliente.start();
//                }
//                System.out.println("[SERVIDOR] Se conectaron los 2 jugadores. Inicia la partida.");
//            } catch (IOException e) {
//                System.out.println("[ERROR] Error al aceptar clientes: " + e.getMessage());
//            }
//        }).start();
//    }
}
