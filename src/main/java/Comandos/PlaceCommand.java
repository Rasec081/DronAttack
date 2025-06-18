/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comandos;

import Arena.Celda;
import Arena.Mapa;
import Estructuras.*;
import java.io.OutputStream;

/**
 *
 * @author gambo
 */
public class PlaceCommand extends BaseCommand{
    public static final String COMMAND_NAME = "PLACE";
    private Mapa mapaJugador;

    // Método setter para inyectar el mapa
    public void setMapa(Mapa mapa) {
        this.mapaJugador = mapa;
    }
    
    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args, OutputStream out) {
        // Verificar que hay suficientes argumentos
        if (args.length < 4) {
            System.out.println("Error: Faltan argumentos. Uso: place <estructura> <x> <y>");
            return;
        }

        try {
            // Extraer y parsear los argumentos
            String tipoEstructura = args[1];  
            int x = Integer.parseInt(args[2]); 
            int y = Integer.parseInt(args[3]); 

            // Verificar si las coordenadas están dentro del mapa
            if (!mapaJugador.estaDentro(x, y)) {
                System.out.println("Coordenadas fuera del mapa.");
                return;
            }

            Celda celda = mapaJugador.getCelda(x, y);
            if (!celda.estaVacia()) {
                System.out.println("Ya hay algo en esa celda.");
                return;
            }

            // Aquí necesitarías convertir el String a tu tipo Estructura
            // Esto depende de cómo definas tus estructuras
            TipoEstructura estructura = crearEstructuraDesdeString(tipoEstructura);
            if (estructura == null) {
                System.out.println("Tipo de estructura no válido: " + tipoEstructura);
                return;
            }

            celda.colocarEstructura(estructura);
            System.out.println("Estructura " + tipoEstructura + " colocada en (" + x + ", " + y + ")");

        } catch (NumberFormatException e) {
            System.out.println("Error: Las coordenadas deben ser números enteros");
        }
    }
    
        private TipoEstructura crearEstructuraDesdeString(String tipo) {
        // Implementación dependiente de tu sistema
        // Ejemplo básico:
        switch(tipo.toLowerCase()) {
            case "radar":
                return TipoEstructura.RADAR;
            case "cuartel":
                return TipoEstructura.CUARTEL;
            case "torre":
                return TipoEstructura.TORRE;
            case "deposito":
                return TipoEstructura.DEPOSITO;
            default:
                return null;
        }
    }
}
