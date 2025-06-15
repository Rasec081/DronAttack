/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejecutables;

import Pantallas.PantallaServidor;
import Servidor.ConexionServidorThread;
import Servidor.Servidor;

/**
 *
 * @author gambo
 */
public class ServidorEjecutable {
    private PantallaServidor pantalla;
    private Servidor server;
    private ConexionServidorThread conexion;
    
    public ServidorEjecutable() {
        // Iniciar la pantalla
        this.pantalla = new PantallaServidor();
        pantalla.setVisible(true); 

        // Iniciar el servidor
        this.server = new Servidor();
        
        // Se crea el thread para el servidor y se inicia
        this.conexion = new ConexionServidorThread(server);
        conexion.start();
    }
    
    public static void main(String[] args) {
        new ServidorEjecutable();
    }
}
