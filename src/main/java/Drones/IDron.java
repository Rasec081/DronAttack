/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Drones;

import Arena.Mapa;
import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public interface IDron {
    ArrayList <Point> atacar( Mapa mapaEnemigo); // define cómo ataca el dron
    int getEnergia();          // consumo energético
    Point getObjetivo();            // celda objetivo
    String getNombre();
}
