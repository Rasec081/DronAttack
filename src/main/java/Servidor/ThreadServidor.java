/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Arena.Mapa;
import Mensajes.Mensaje;
import Mensajes.TipoMensaje;
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
    

    public ThreadServidor(Socket socket, Servidor server, String nombre) {
        this.socket = socket;
        this.server = server;
        this.nombre = nombre;
        try {
            salidaDatos = new ObjectOutputStream(socket.getOutputStream());
            salidaDatos.flush();
            entradaDatos = new ObjectInputStream(socket.getInputStream());
            
             // ✅ Enviar inmediatamente el nombre lógico al cliente
            Mensaje m = new Mensaje("Servidor", TipoMensaje.ASIGNACION_NOMBRE, nombre);
            enviarMensaje(m);
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
    
    public void enviarMensaje(Mensaje mensaje) {
        try {
            salidaDatos.writeObject(mensaje);
            salidaDatos.flush();
        } catch (IOException e) {
            System.err.println("Error al enviar mensaje a " + nombre);
        }
    }
    
    @Override
    public void run() {
        
        while (isRunning) {
            try {
                //Object recibido = (Mensaje)entradaDatos.readObject();
                Mensaje msj = (Mensaje)entradaDatos.readObject(); 
                
                switch (msj.getTipo()) {
                    case MAPA_COMPLETO:
                        server.getGameManager().procesarMapa(msj.getEnviador(),(Mapa)msj.getContenido());
                        break;
                        
                    case CHAT_USER:
                        server.getGameManager().enviarMensajeChat(msj);
                        break;
                        
                    case ATAQUE:
                        server.getGameManager().manejarAtaque(msj);
                        break;
                        
                    default:
                        throw new AssertionError();
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("[SERVIDOR] Error: " + e.getMessage());
                cerrarConexion();
                isRunning = false;
            }
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
