/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Mensajes.Mensaje;
import java.io.IOException;
import java.net.ServerSocket;
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
}
