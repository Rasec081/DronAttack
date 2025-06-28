/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Drones;

import java.awt.Point;

/**
 *
 * @author Daniel
 */
public abstract class Drones implements IDron {
    private Point objetivo;
    

    public Drones(Point objetivo) {
        this.objetivo = objetivo;
        
    }

    @Override
    public Point getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Point objetivo) {
        this.objetivo = objetivo;
    }

    
    
    
    
    
}
