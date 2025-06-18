/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Arena.TipoCelda;
import java.awt.Point;

/**
 *
 * @author Daniel
 */
public class DepositoDeArmas extends Estructuras{

    public DepositoDeArmas(TipoCelda tipo, Point posicion) {
        super(tipo, posicion);
    }

    @Override
    public void structAction() {
        System.out.println("Mi idea es que pregunten si este mae esta vivo, y si lo está que haga 100 de daño, sino 50");
        }
    
    
}
