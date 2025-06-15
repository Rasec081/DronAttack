/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mensajes;

import java.io.Serializable;


/**
 *
 * @author gambo
 */
public class Mensaje implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String enviador;
    private TipoMensaje tipo;
    private Object contenido;
      
    public Mensaje(String enviador, TipoMensaje tipo, Object contenido) {
        this.enviador = enviador;
        this.tipo = tipo;
        this.contenido = contenido;
    }
    
    public Mensaje(String enviador, TipoMensaje tipo) {
        this.enviador = enviador;
        this.tipo = tipo;
    }
    
    public String getEnviador() {
        return enviador;
    }

    public void setEnviador(String enviador) {
        this.enviador = enviador;
    }

    public TipoMensaje getTipo() {
        return tipo;
    }

    public void setTipo(TipoMensaje tipo) {
        this.tipo = tipo;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }
}
