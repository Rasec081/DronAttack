/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Mensajes.Mensaje;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author gambo
 */
public class ManejoEnvioMensajes {
    private final ObjectOutputStream salidaDatos;

    public ManejoEnvioMensajes(ObjectOutputStream salidaDatos) {
        this.salidaDatos = salidaDatos;
    }

    public void enviarMensaje(Mensaje mensaje) throws IOException {
        synchronized(salidaDatos) { // Para thread safety
            salidaDatos.writeObject(mensaje);
            salidaDatos.flush();
        }
    }
}
