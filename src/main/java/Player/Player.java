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
import Usuario.GameListener;
import java.awt.List;

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
    private final ArrayList<GameListener> listeners = new ArrayList<>();
    
    
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
        notificarTurno();
    }

    public ArrayList<Estructuras> getEstructuras() {
        return estructuras;
    }

    public void setEstructuras(ArrayList<Estructuras> estructuras) {
        this.estructuras = estructuras;
    }

    public Mapa getMapaEnemigo() {
        return mapaEnemigo;
    }

    public void setMapaEnemigo(Mapa mapaEnemigo) {
        this.mapaEnemigo = mapaEnemigo;
    }
    
    //se podria hacer con un simple modificar energia y que se le pase como + o -, per meh
    public void restarEnergia(int cant){
        energia -= cant;
        if (energia <= 0){
            energia = 0;
        }
        
        notificarEnergia();
    }
    
    public void sumarEnergia(int cant){
        energia += cant;
        if (energia <= 100){
            energia = 100;
        }
    }
    
    
    public void recibirAtaque (Point pos, int danio){
        if(mapa.getCelda(pos.x, pos.y).esEstructura()){
            for (Estructuras estructura : estructuras) {
                if(estructura.getPosicion().equals(pos)){
                    estructura.recibirDanio(danio);
                    if(!estructura.isIsActive()){
                        mapa.setCelda(estructura.getPosicion().x, estructura.getPosicion().x, TipoCelda.DESTRUIDA);
                    }
                    //TODO: si muere que se ponga como muerta, si queda viva que lo marque pero que aun no muere
                    
                    notificar("Tu base fue atacada");
                    notificarMapa();
                    notificarEstructuras();
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
    
    public boolean tieneEstructuraDeTipo(TipoCelda tipo) {
        for (Estructuras e : estructuras) {
            if (e.getTipo() == tipo && e.isIsActive()) {
                return true;
            }
        }
        return false;
        }

    public boolean tieneCuatroEstructuras() {
        return estructuras.size() == 4;
        }
    
    public void addGameListener(GameListener listener) {
        listeners.add(listener);
    }

    public void removeGameListener(GameListener listener) {
        listeners.remove(listener);
    }

    private void notificarEnergia() {
        for (GameListener l : listeners) {
            l.energiaActualizada(this.energia);
        }
    }

    private void notificarEstructuras() {
        for (GameListener l : listeners) {
            l.estructurasActualizadas(this.cantEstructurasVivas());
        }
    }

    private void notificarMapa() {
        for (GameListener l : listeners) {
            l.mapaActualizado();
        }
    }

    private void notificar(String mensaje) {
        for (GameListener l : listeners) {
            l.notificacion(mensaje);
        }
    }

    private void notificarTurno() {
        for (GameListener l : listeners) {
            l.turnoActualizado(this.turno);
        }
    }

    private void notificarImpactos(int cant) {
        for (GameListener l : listeners) {
            l.impactosActualizados(cant);
        }
    }

    private void notificarZonas(int cant) {
        for (GameListener l : listeners) {
            l.zonasReveladasActualizadas(cant);
        }
    }
}
