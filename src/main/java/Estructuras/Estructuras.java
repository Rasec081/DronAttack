/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import java.awt.Point;

/**
 *
 * @author Daniel
 */


/*en mi logica cada usuario va a tener un arraylist de estructuras y va a trabajar con base
a las mecanicas de estas, para ver si los drones de largo alcance puesden atacar
por ejemplo, busca en el arraylist a la torreDeCOmandos y su esta viva hacen la accion
pero si no no hacen nada y así, pero no se muy bien aun*/
public abstract class Estructuras {
    private TipoEstructura tipo;
    private int vida; //no recuerdo si habian unos drones que hacemis más daño que otros
    private boolean isActive;
    private Point posicion;

    public Estructuras(TipoEstructura tipo, Point posicion) {
        this.tipo = tipo;
        this.posicion = posicion;
        this.vida = 100;
        this.isActive = true;
    }

    public TipoEstructura getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstructura tipo) {
        this.tipo = tipo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Point getPosicion() {
        return posicion;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }
    
    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida <= 0) {
            vida = 0;
            isActive = false;
        }
    }
    
    
    public abstract void structAction();
    
}
