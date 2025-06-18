/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;


/**
 *
 * @author gambo
 */

public class Celda {
    private TipoCelda tipo;

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
}
