/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author gambo
 */
public class ConexionServidorThread extends Thread {
    final int MAX_CLIENTES = 2;
    private boolean isRunning = true;
    private final Servidor servidor;

    public ConexionServidorThread(Servidor server) {
        this.servidor = server;
    }

    @Override
    public void run() {
        System.out.println("Servidor esperando clientes...");

        while (isRunning) {
            try {
                Socket socket = servidor.getServidor().accept(); // Esperar una nueva conexión
                DataOutputStream salidaTemporal = new DataOutputStream(socket.getOutputStream());

                synchronized (servidor.getClientesAceptados()) {
                    if (servidor.getClientesAceptados().size() >= MAX_CLIENTES) {
                        salidaTemporal.writeUTF("RECHAZADO");
                        socket.close();
                        continue;
                    }

                    salidaTemporal.writeUTF("ACEPTADO");

                    // Crear nuevo hilo para lo que envie el cliente
                    int num = servidor.getClientesAceptados().size()+1;
                    String nombre = "Jugador "+ num;
                    
                    ThreadServidor ts = new ThreadServidor(socket, servidor,nombre);
                    
                    servidor.getClientesAceptados().add(ts);
                    
                    ts.start();
                    
                    System.out.println("Cliente Aceptado");
                }

            } catch (IOException ex) {

            }
        }
    }
}

