/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Arena.TipoCelda;
import Mensajes.Mensaje;
import static Mensajes.TipoMensaje.ACTUALIZAR_MAPA_PROPIO;
import static Mensajes.TipoMensaje.ENERGIA_EXTRA;
import Servidor.PaqueteMapas;
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
    
    
    public void actualizarMapaEnemigo(Mensaje mensaje){
        PaqueteMapas p = (PaqueteMapas) mensaje.getContenido();
         cliente.getPlayer().getMapaEnemigo().setCelda(p.getPunto().x, p.getPunto().y, p.getTipo());
    }
     public void actualizarMapaPropio(Mensaje mensaje){
         PaqueteMapas p = (PaqueteMapas) mensaje.getContenido();
         cliente.getPlayer().getMapa().setCelda(p.getPunto().x, p.getPunto().y, p.getTipo());
    }
    public void actualizarEnergia(){
        cliente.getPlayer().sumarEnergia(30);
    }
    
}
