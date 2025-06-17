/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Arena.Celda;
import Arena.Mapa;
import Estructuras.TipoEstructura;
import java.awt.Point;

/**
 *
 * @author gambo
 */
public class PlaceCommand implements ICommand{
    private Mapa mapaJugador;
    private TipoEstructura estructura;
    private Point punto;

    public PlaceCommand(Mapa mapaJugador, TipoEstructura estructura, Point punto) {
        this.mapaJugador = mapaJugador;
        this.estructura = estructura;
        this.punto = punto;
    }
    @Override
    public String ejecutar() {
        if (!mapaJugador.estaDentro(punto.x, punto.y)) {
            return "Coordenadas fuera del mapa.";
        }

        Celda celda = mapaJugador.getCelda(punto.x, punto.y);
        if (!celda.estaVacia()) {
            return "Ya hay algo en esa celda.";
        }

        celda.colocarEstructura(estructura);
        return "Estructura " + estructura + " colocada en (" + punto.x + ", " + punto.y + ")";
    }
    
}
