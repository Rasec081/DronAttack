/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto3;

import Cliente.Cliente;

/**
 *
 * @author gambo
 */
public class Proyecto3 {    
    public static void main(String[] args) {
        //cliente (clinete tendra un player)
        Cliente c1 = new Cliente();
        
        Usuario.PantallaUsuario p = new Usuario.PantallaUsuario(c1); //le pasamos cliente por referencia
        p.setVisible(true);
    }
        
}
