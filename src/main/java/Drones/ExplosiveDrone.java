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
public class ExplosiveDrone implements IDron {
    private final Point punto;
    private final String nombre = "explosive";

    public ExplosiveDrone(Point punto) {
        this.punto = punto;
    }

    @Override
    public ArrayList<Point> atacar(Mapa mapaEnemigo) {
        ArrayList<Point> afectados = new ArrayList<>();

        // Si ya fue atacado, no hacer nada
        if (mapaEnemigo.getCelda(punto.x, punto.y).getTipo() == TipoCelda.ATACADO) {
            return afectados; // vacío
        }

        // Agrega los puntos en área 3x3
        addPuntos(afectados, mapaEnemigo);
        return afectados;
    }

    @Override
    public int getEnergia() {
        return 20;
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
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = punto.x + dx;
                int ny = punto.y + dy;

                if (mapa.estaDentro(nx, ny)) {
                    afectados.add(new Point(nx, ny));
                }
            }
        }
    }
}