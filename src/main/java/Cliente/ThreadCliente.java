package Cliente;

import Arena.Mapa;
import Mensajes.Mensaje;
import Mensajes.TipoMensaje;
import static Mensajes.TipoMensaje.MAPA_COMPLETO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadCliente extends Thread {
    private volatile boolean isRunning = true; // Cambiado a volatile para mejor manejo de hilos
    private final Socket socket;
    private final Cliente cliente;
    private  ManejoEnvioMensajes manejadorEnvio;
    private ObjectInputStream entradaDatos;
    private ObjectOutputStream salidaDatos;
    private ClienteManager manager;
    Mensaje mensaje;

    public ThreadCliente(Socket socket, Cliente cliente) {
        this.socket = socket;
        this.cliente = cliente;
        this.manager = new ClienteManager(cliente);
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

    public ManejoEnvioMensajes getManejadorEnvio() {
        return manejadorEnvio;
    }

    public void setManejadorEnvio(ManejoEnvioMensajes manejadorEnvio) {
        this.manejadorEnvio = manejadorEnvio;
    }

    public ClienteManager getManager() {
        return manager;
    }

    public void setManager(ClienteManager manager) {
        this.manager = manager;
    }
    
    
    
      @Override
    public void run() {
        while(this.isRunning) {
            try {
                
                Object objetoRecibido = this.entradaDatos.readObject();
                
                if (objetoRecibido instanceof Mensaje mensaje1) {
                    mensaje = mensaje1;
                } else if (objetoRecibido instanceof String) {
                    String texto = (String) objetoRecibido;
                    System.out.println("⚠ Se recibió un String: " + texto);
                }else if (objetoRecibido instanceof TipoMensaje) {
                    TipoMensaje tipo = (TipoMensaje) objetoRecibido;
                    System.out.println("⚠ Se recibió un TipoMensaje: " + tipo.name());
                }else {
                    System.out.println("el objeto que se recibio no funka");
                    continue;
                }
                
                if (mensaje.getTipo() == null) {
                    System.out.println("Mensaje recibido con tipo null");
                    continue;
                }
                
                switch (mensaje.getTipo()) {
                    case ASIGNACION_NOMBRE:
                        manager.asignarNombre(mensaje);
                        
                        break;
                    case INICIO_PARTIDA:
                        System.out.println("Soy el jugador =" +cliente.getNombre()+" y estoy listo para la partida" );
                        break;
                        
                    case TURNO:
                        manager.asignarTurno(mensaje);
                        break;
                    
                    case CHAT_SERVER:
                        manager.sendMsj(mensaje);
                        break;
                    case ACTUALIZAR_MAPA_ENEMIGO:
                        manager.actualizarMapaEnemigo(mensaje);
                        break;
                    case ACTUALIZAR_MAPA_PROPIO:
                        manager.actualizarMapaPropio(mensaje);
                        break;
                    case ENERGIA_EXTRA:
                        manager.actualizarEnergia();
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