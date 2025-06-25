package Cliente;

import Mensajes.Mensaje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadCliente extends Thread {
    private volatile boolean isRunning = true; // Cambiado a volatile para mejor manejo de hilos
    private final Socket socket;
    private final Cliente cliente;
    private final ManejoEnvioMensajes manejadorEnvio;
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
        this.manejadorEnvio = new ManejoEnvioMensajes(salidaDatos);
    }
    
    @Override
    public void run() {
        while (isRunning) {
            try {
                Object recibido = entradaDatos.readObject();

                if (recibido instanceof Mensaje mensaje) {
                    System.out.println("[CLIENTE] Mensaje recibido: " + mensaje.getContenido());
                    procesarMensaje(mensaje);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("[CLIENTE] Error en la comunicación: " + e.getMessage());
                cerrarConexion();
                isRunning = false;
            }
        }
    }
    
    
    private void procesarMensaje(Mensaje mensaje) {
        // Aquí iría la lógica para manejar diferentes tipos de mensajes
        // Podrías incluso crear una clase MessageHandler separada
//        cliente.getPlayer().actualizarEstado(mensaje); // Ejemplo hipotético
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