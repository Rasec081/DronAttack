/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Drones;

import Arena.Mapa;
import Arena.TipoCelda;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Daniel
 */

public class SniperDrone implements IDron {
    private Point punto; // Punto de disparo
    private final String nombre = "SniperDrone";
    private final int ALCANCE = 6;

    public SniperDrone(Point punto) {
        this.punto = punto;
    }

    @Override
    public ArrayList<Point> atacar(Mapa mapaEnemigo) {
        ArrayList<Point> afectados = new ArrayList<>();
        Random random = new Random();

        // Selección aleatoria de dirección (0=arriba, 1=abajo, 2=izquierda, 3=derecha)
        int direccion = random.nextInt(4);
        Point objetivo = calcularObjetivo(direccion, mapaEnemigo);

        if (objetivo == null) return afectados; // fuera de rango

        // Determinar si el disparo falla (20% de probabilidad)
        boolean falla = random.nextInt(100) < 20;

        if (falla) {
            // Desviarse a una celda adyacente aleatoria del objetivo
            objetivo = desviarDisparo(objetivo, mapaEnemigo);
        }

        afectados.add(objetivo);
        return afectados;
    }

    private Point calcularObjetivo(int direccion, Mapa mapa) {
        int x = punto.x;
        int y = punto.y;

        switch (direccion) {
            case 0: y -= ALCANCE; break; // arriba
            case 1: y += ALCANCE; break; // abajo
            case 2: x -= ALCANCE; break; // izquierda
            case 3: x += ALCANCE; break; // derecha
        }

        Point objetivo = new Point(x, y);
        if (mapa.estaDentro(objetivo.x, objetivo.y)) {
            return objetivo;
        }
        return null;
    }

    private Point desviarDisparo(Point objetivo, Mapa mapa) {
        ArrayList<Point> vecinos = new ArrayList<>();

        int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] delta : deltas) {
            int nx = objetivo.x + delta[0];
            int ny = objetivo.y + delta[1];
            if (mapa.estaDentro(nx, ny)) {
                vecinos.add(new Point(nx, ny));
            }
        }

        if (vecinos.isEmpty()) return objetivo;

        Random rand = new Random();
        return vecinos.get(rand.nextInt(vecinos.size()));
    }

    @Override
    public int getEnergia() {
        return 15;
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