/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejecutables;

import Cliente.Cliente;
import Pantallas.PantallaCliente;

/**
 *
 * @author gambo
 */
public class ClienteEjecutable {
    private PantallaCliente pantalla;
    private Cliente cliente;
    
    public ClienteEjecutable(){ // Esto lo pensé así para poder llamarlo desde el main tambien , entonces el del servidor va igual
        cliente = new Cliente();
        if(cliente.probarConexion()) {
            cliente.iniciarCliente();
        } else return; // Aqui lo que puede ir es como una mini pantallita de servidor lleno
            
        
        pantalla = new PantallaCliente();
        pantalla.setVisible(true); 
    }
    
    public static void main(String[] args) {
        new ClienteEjecutable();
    }
}
