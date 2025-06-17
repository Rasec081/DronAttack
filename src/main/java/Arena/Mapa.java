/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;

/**
 *
 * @author gambo
 */
public class Mapa {
    private final int FILAS;
    private final int COLUMNAS;
    private final Celda[][] celdas;

    public Mapa(int filas, int columnas) {
        this.FILAS = filas;
        this.COLUMNAS = columnas;
        this.celdas = new Celda[filas][columnas];
        inicializarMapa();
    }

    private void inicializarMapa() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                celdas[i][j] = new Celda(); // por defecto VACIA
            }
        }
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
}
