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
public class Radar extends Estructuras{

    public Radar(TipoCelda tipo, Point posicion) {
        super(tipo, posicion);
    }

    @Override
    public void structAction() {
        System.out.println("este me lo imagino que le hace una peticion al socket para que le mande el mapa, y este solo muestra las casillas permitidas del mapa enemigo");
      }

}
