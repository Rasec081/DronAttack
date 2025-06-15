/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author gambo
 */
public class ConfiguracionJuego {
    private static final String RUTA_ARCHIVO_CONFIG = "src\\main\\java\\Configuracion\\Config.properties";
    private static ConfiguracionJuego instancia;

    private int mapaAncho;
    private int mapaAlto;
    private int energiaInicial;
    private int maxDronesPorJugador;
    private int tiempoPorTurno;

    private ConfiguracionJuego() {
        cargarConfiguracion();
    }

    public static ConfiguracionJuego getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionJuego();
        }
        return instancia;
    }

    private void cargarConfiguracion() {
        Properties props = new Properties();
        try {
            props.load(new FileReader(RUTA_ARCHIVO_CONFIG));

            mapaAncho = Integer.parseInt(props.getProperty("mapa.ancho", "10"));
            mapaAlto = Integer.parseInt(props.getProperty("mapa.alto", "10"));
            energiaInicial = Integer.parseInt(props.getProperty("energia.inicial", "100"));
            maxDronesPorJugador = Integer.parseInt(props.getProperty("drones.max", "5"));
            tiempoPorTurno = Integer.parseInt(props.getProperty("turno.tiempo", "30"));

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de configuracion, usando valores por defecto.");
            mapaAncho = 10;
            mapaAlto = 10;
            energiaInicial = 100;
            maxDronesPorJugador = 5;
            tiempoPorTurno = 30;
        }
    }

    // Getters
    public int getMapaAncho() {
        return mapaAncho;
    }

    public int getMapaAlto() {
        return mapaAlto;
    }

    public int getEnergiaInicial() {
        return energiaInicial;
    }

    public int getMaxDronesPorJugador() {
        return maxDronesPorJugador;
    }

    public int getTiempoPorTurno() {
        return tiempoPorTurno;
    }
}
