/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Mensajes.Mensaje;
import Usuario.ClienteController;
import Usuario.PantallaUsuario;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class ClienteManager {
    Cliente cliente;
    ClienteController controler;
    PantallaUsuario pantallaUsuario;

    public ClienteManager(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteController getControler() {
        return controler;
    }

    public void setControler(ClienteController controler) {
        this.controler = controler;
    }

    public JFrame getPantallaUsuario() {
        return pantallaUsuario;
    }

    public void setPantallaUsuario(PantallaUsuario pantallaUsuario) {
        this.pantallaUsuario = pantallaUsuario;
    }
    
    
    public void asignarNombre(Mensaje mensaje){
        //Todo: pasar esto a una clase que lo pueda manejar bien guapo
        cliente.setNombre((String)mensaje.getContenido());
        cliente.getPlayer().setNombre((String)mensaje.getContenido());
        System.out.println("Soy" + cliente.getNombre());
    }
    
    public void asignarTurno(Mensaje mensaje){
        boolean turno = (boolean) mensaje.getContenido();
        cliente.getPlayer().setTurno(turno);
        System.out.println("SOY EL CLIENTE"+ cliente.getNombre()+"y mi turno es"+cliente.getPlayer().isTurno());
    }
    
    public void sendMsj(Mensaje mensaje){
        String msj = (String) mensaje.getContenido();
        pantallaUsuario.mostrarMensajeChat(msj);
    }
    
}
