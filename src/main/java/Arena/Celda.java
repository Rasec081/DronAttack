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

public class Celda implements Serializable {
    private TipoCelda tipo;
    private boolean descubierta = false;

    public Celda() {
        this.tipo = TipoCelda.VACIA; // por defecto
    }

    public TipoCelda getTipo() {
        return tipo;
    }

    public void setTipo(TipoCelda tipo) {
        this.tipo = tipo;
    }

    public boolean estaVacia() {
        return tipo == TipoCelda.VACIA;
    }

    public boolean esEstructura() {
        return tipo != TipoCelda.VACIA && tipo != TipoCelda.DESTRUIDA;
    }

    public boolean estaDestruida() {
        return tipo == TipoCelda.DESTRUIDA;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }
    
    
}
