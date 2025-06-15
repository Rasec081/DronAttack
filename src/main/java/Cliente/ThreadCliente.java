package Cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadCliente extends Thread {
    private volatile boolean isRunning = true; // Cambiado a volatile para mejor manejo de hilos
    private final Socket socket;
    private final Cliente cliente;
    private ObjectInputStream entradaDatos;
    private ObjectOutputStream salidaDatos;

    public ThreadCliente(Socket socket, Cliente cliente) {
        this.socket = socket;
        this.cliente = cliente;
        try {
            salidaDatos = new ObjectOutputStream(socket.getOutputStream());
            salidaDatos.flush();
            entradaDatos = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            this.isRunning = false;
            cerrarConexion();
        }
    }
    
    @Override
    public void run() {
        while(this.isRunning) {
        }
    }
    
    public void detener() {
        this.isRunning = false;
        this.interrupt();
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