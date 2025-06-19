/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Player;

import Arena.Mapa;
import Arena.TipoCelda;
import Estructuras.Estructuras;
import java.awt.Point;
import java.util.ArrayList;
import Configuracion.ConfiguracionJuego;

/**
 *
 * @author Daniel
 */
public class Player {
    private String nombre; //el que se conecte de primero va a ser Player 1 
    private int energia;
    private boolean turno;
    private Mapa mapa;
    private Mapa mapaEnemigo;
    private ArrayList<Estructuras> estructuras;

    public Player(String nombre) {
        ConfiguracionJuego config = ConfiguracionJuego.getInstancia();
        this.nombre = nombre;
        this.energia = config.getEnergiaInicial();
        this.mapa = new Mapa(config.getMapaAncho(), config.getMapaAlto());
        this.mapaEnemigo = new Mapa(config.getMapaAncho(), config.getMapaAlto());
        this.turno = false;
        this.estructuras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public ArrayList<Estructuras> getEstructuras() {
        return estructuras;
    }

    public void setEstructuras(ArrayList<Estructuras> estructuras) {
        this.estructuras = estructuras;
    }
    
    //se podria hacer con un simple modificar energia y que se le pase como + o -, per meh
    public void restarEnergia(int cant){
        energia -= cant;
        if (energia <= 0){
            energia = 0;
        }
    }
    
    public void sumarEnergia(int cant){
        energia += cant;
        if (energia <= 100){
            energia = 100;
        }
    }
    
//    public boolean colocarEstructura(Estructuras estructura, Point pos) {
//        //recibe la estructura ya creada y la posicion de esa estructura
//        if (mapa.getCelda(pos.x, pos.y).estaVacia()) {
//            mapa.setCelda(pos.x, pos.y, TipoCelda.ESTRUCTURA);
//            //sugerencia de chat: estructura.setPosicion(pos); segun yo no porque ya la trae
//            estructuras.add(estructura);
//            return true;
//        }
//        return false; 
//    }
    
    public void recibirAtaque (Point pos, int danio){
        if(mapa.getCelda(pos.x, pos.y).esEstructura()){
            for (Estructuras estructura : estructuras) {
                if(estructura.getPosicion().equals(pos)){
                    estructura.recibirDanio(danio);
                    if(!estructura.isIsActive()){
                        mapa.setCelda(estructura.getPosicion().x, estructura.getPosicion().x, TipoCelda.DESTRUIDA);
                    }
                    //TODO: si muere que se ponga como muerta, si queda viva que lo marque pero que aun no muere
                    
                    //aca asumo que se llama a otra funcion
                    //para trabajar con el patrocn observer
                }
            }
        }    
    }
    
    public boolean leQuedanEstructuras(){
        for (Estructuras estructura : estructuras) {
            if (estructura.isIsActive())
                return true;
            
        }
        return false;
    }
    
    public int cantEstructurasVivas(){
        int cant = 0;
         for (Estructuras estructura : estructuras) {
            if (estructura.isIsActive())
                cant++;
            
        }
        return cant;
    }
    
    public boolean estructuraActiva(TipoCelda buscada){
        for (Estructuras estructura : estructuras) {
            if(estructura.getTipo() == buscada){
                return estructura.isIsActive();
            }
        }
        return false;
    }
}
