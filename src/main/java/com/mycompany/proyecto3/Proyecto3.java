/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto3;

import Arena.Mapa;
import Comandos.ICommand;
import Ejecutables.ClienteEjecutable;
import Ejecutables.ServidorEjecutable;
import Estructuras.*;
import Player.Player;
import java.awt.Point;
import java.util.Scanner;
/**
 *
 * @author gambo
 */
public class Proyecto3 {
    public static Estructuras crear(TipoEstructura tipo, Point pos) {
        return switch (tipo) {
        case RADAR -> new Radar(TipoEstructura.RADAR, pos);
        case CUARTEL -> new Cuartel(TipoEstructura.CUARTEL, pos);
        case TORRE -> new TorreDeComunicacion(TipoEstructura.TORRE, pos);
        case DEPOSITO -> new DepositoDeArmas(TipoEstructura.DEPOSITO, pos);
        };
    }
    
    public static void main(String[] args) {
        Player jugador = new Player("Jugador1");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Colocacion de estructuras (place <tipo> <fila> <columna>)");
        System.out.println("Ver mapa: ver / Salir: exit\n");

        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("exit")) {
                break;
            } else if (entrada.equalsIgnoreCase("ver")) {
                jugador.getMapa().imprimirMapa(); // método que ya deberías tener
            } else if (entrada.toLowerCase().startsWith("place ")) {
                String[] partes = entrada.split(" ");
                if (partes.length != 4) {
                    System.out.println("Formato inválido. Ej: place radar 3 4");
                    continue;
                }

                try {
                    TipoEstructura tipo = TipoEstructura.valueOf(partes[1].toUpperCase());
                    int fila = Integer.parseInt(partes[2]);
                    int col = Integer.parseInt(partes[3]);
                    Point posicion = new Point(fila, col);

                    Estructuras nueva = crear(tipo, posicion);
                    boolean colocado = jugador.colocarEstructura(nueva, posicion);

                    if (colocado) {
                        System.out.println("Estructura colocada.");
                    } else {
                        System.out.println("No se pudo colocar. Celda ocupada.");
                    }

                } catch (Exception e) {
                    System.out.println("Error: tipo inválido o coordenadas incorrectas.");
                }
            }
        }

        System.out.println("\nEstructuras vivas: " + jugador.cantEstructurasVivas());
        System.out.println("¿Tiene radar activo? " + jugador.estructuraActiva(TipoEstructura.RADAR));
    }    
}
