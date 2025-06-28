/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Drones;

import Arena.Mapa;
import Arena.TipoCelda;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Daniel
 */
public class MultishotDrone implements IDron {
    private final Point punto;
    private final String nombre = "MultishotDrone";

    public MultishotDrone(Point punto) {
        this.punto = punto;
    }

    @Override
    public ArrayList<Point> atacar(Mapa mapaEnemigo) {
        ArrayList<Point> afectados = new ArrayList<>();

        // Evita atacar si ya se atacó esta celda principal
        if (mapaEnemigo.getCelda(punto.x, punto.y).getTipo() == TipoCelda.ATACADO) {
            return afectados;
        }

        // Generar 3 posiciones aleatorias únicas dentro del mapa
        addPuntos(afectados, mapaEnemigo);
        return afectados;
    }

    @Override
    public int getEnergia() {
        return 25;
    }

    @Override
    public Point getObjetivo() {
        return punto;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    private void addPuntos(ArrayList<Point> afectados, Mapa mapa) {
        int ancho = mapa.getCOLUMNAS();
        int alto = mapa.getFILAS();
        Random rand = new Random();
        Set<Point> seleccionados = new HashSet<>();

        while (seleccionados.size() < 3) {
            int x = rand.nextInt(ancho);
            int y = rand.nextInt(alto);
            Point nuevo = new Point(x, y);
            seleccionados.add(nuevo); // evita duplicados
        }

        afectados.addAll(seleccionados);
    }
}

    
    
    

