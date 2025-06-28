/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Arena.TipoCelda;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Daniel
 */
public class PaqueteMapas implements Serializable{
    Point punto;
    TipoCelda tipo;

    public PaqueteMapas(Point punto, TipoCelda tipo) {
        this.punto = punto;
        this.tipo = tipo;
    }

    
    public Point getPunto() {
        return punto;
    }

    public void setPunto(Point punto) {
        this.punto = punto;
    }

    public TipoCelda getTipo() {
        return tipo;
    }

    public void setTipo(TipoCelda tipo) {
        this.tipo = tipo;
    }
    
    
}
