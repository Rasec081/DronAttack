/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Player.Player;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author gambo
 */
public class Cliente {
    final String IP = "localhost";//25.4.109.245
    final int PUERTO = 8084;
    private String nombre;
    private Socket socket;
    private ThreadCliente threadCliente;
    private Player player; 


    public Cliente() {
        this.player = new Player("Player 1");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ThreadCliente getThreadCliente() {
        return threadCliente;
    }

    public void setThreadCliente(ThreadCliente threadCliente) {
        this.threadCliente = threadCliente;
    }
        
    // -----------CONEXION CON EL SERVIDOR-----------
    
    public boolean probarConexion() {
        try {
            this.socket = new Socket(this.IP, this.PUERTO);
            
            // Esta entrada se usa para ver si se puede conectar al servidor
            DataInputStream entradaTemporal = new DataInputStream(this.socket.getInputStream());
            String respuesta = entradaTemporal.readUTF();
            
            if ("RECHAZADO".equals(respuesta)) {
                this.socket.close();
                return false;
            }
            
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public void iniciarCliente() {
        this.threadCliente = new ThreadCliente(this.socket, this);
        this.threadCliente.start();
    }
}
