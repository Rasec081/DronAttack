/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Drones;

import Arena.Mapa;
import Arena.TipoCelda;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class BombDrone implements IDron{
    private Point punto;
    private final String nombre = "BombDrone";
    
    public BombDrone(Point punto) {
        this.punto = punto;
    }

    @Override
    public ArrayList <Point> atacar(Mapa mapaEnemigo){
        if(mapaEnemigo.getCelda(punto.x, punto.y).getTipo() == TipoCelda.ATACADO){
            return null;
        }
        
        ArrayList<Point> afectados = new ArrayList<>();
        afectados.add(punto);
        return afectados;
    }

    @Override
    public int getEnergia() {
        return 10;
    }

    @Override
    public Point getObjetivo() {
        return punto;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    
    
    
}
