/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arena;

import Estructuras.TipoEstructura;

/**
 *
 * @author gambo
 */

public class Celda {
    private TipoCelda tipo;
    private TipoEstructura estructura;

    public Celda() {
        this.tipo = TipoCelda.VACIA; // por defecto
    }

    public TipoCelda getTipo() {
        return tipo;
    }

    public void setTipo(TipoCelda tipo) {
        this.tipo = tipo;
    }
    
    public TipoEstructura getEstructura() {
        return estructura;
    }
    
    public boolean tieneEstructura() {
        return estructura != null;
    }

    public void colocarEstructura(TipoEstructura tipo) {
        this.estructura = tipo;
        this.tipo = TipoCelda.ESTRUCTURA;
    }

    public boolean estaVacia() {
        return tipo == TipoCelda.VACIA;
    }

    public boolean esEstructura() {
        return tipo == TipoCelda.ESTRUCTURA;
    }

    public boolean estaDestruida() {
        return tipo == TipoCelda.DESTRUIDA;
    }
}
