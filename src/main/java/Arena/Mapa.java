/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;

import java.io.Serializable;

/**
 *
 * @author gambo
 */
public class Mapa implements Serializable {
    private final int FILAS;
    private final int COLUMNAS;
    private final Celda[][] celdas;

    public Mapa(int filas, int columnas) {
        this.FILAS = filas;
        this.COLUMNAS = columnas;
        this.celdas = new Celda[FILAS][COLUMNAS];
        inicializarMapa();
    }

    
    
    public Celda getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }

    public void setCelda(int fila, int columna, TipoCelda tipo) {
        celdas[fila][columna].setTipo(tipo);
    }

    public int getFILAS() {
        return FILAS;
    }

    public int getCOLUMNAS() {
        return COLUMNAS;
    }
    
    private void inicializarMapa() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                celdas[i][j] = new Celda(); // por defecto VACIA
            }
        }
    }
    
    public boolean estaDentro(int x, int y) {
        return x >= 0 && x < COLUMNAS && y >= 0 && y < FILAS;
    }
    
    public void imprimirMapa() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                switch (celdas[i][j].getTipo()) {
                    case VACIA -> System.out.print(" . ");
                    case CUARTEL, DEPOSITO, RADAR, TORRE  -> System.out.print(" E ");
                    case DESTRUIDA -> System.out.print(" X ");
                }
            }
            System.out.println();
        }
    }
}
