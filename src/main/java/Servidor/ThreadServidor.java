/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Mensajes.Mensaje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author gambo
 */
public class ThreadServidor extends Thread{
    public Socket socket;
    private Servidor server;
    private ObjectInputStream entradaDatos;
    private ObjectOutputStream salidaDatos;
    private String nombre;
    
    private boolean isRunning = true;
    

    public ThreadServidor(Socket socket, Servidor server) {
        this.socket = socket;
        this.server = server;
        try {
            salidaDatos = new ObjectOutputStream(socket.getOutputStream());
            salidaDatos.flush();
            entradaDatos = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            isRunning=false;
            cerrarConexion();
        }
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public ObjectInputStream getEntradaDatos() {
        return entradaDatos;
    }

    public void setEntradaDatos(ObjectInputStream entradaDatos) {
        this.entradaDatos = entradaDatos;
    }

    public ObjectOutputStream getSalidaDatos() {
        return salidaDatos;
    }

    public void setSalidaDatos(ObjectOutputStream salidaDatos) {
        this.salidaDatos = salidaDatos;
    }
    
    
    @Override
    public void run() {
        Mensaje mensaje;
        System.out.println("HOla");
        
        while (isRunning) {
        }
    }
    
    private void cerrarConexion() {
    try {
        if (salidaDatos != null) salidaDatos.close();
        if (entradaDatos != null) entradaDatos.close();
        if (socket != null) socket.close();
    } catch (IOException e) {
        System.err.println("Error al cerrar recursos: " + e.getMessage());
    }
}
}
