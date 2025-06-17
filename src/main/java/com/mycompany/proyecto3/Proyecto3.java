/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto3;

import Arena.Mapa;
import Comandos.ICommand;
import Ejecutables.ClienteEjecutable;
import Ejecutables.ServidorEjecutable;
import Estructuras.TipoEstructura;
import java.util.Scanner;
/**
 *
 * @author gambo
 */
public class Proyecto3 {
    public static void main(String[] args) {
        Mapa mapaJugador = new Mapa(); // tamaño fijo para probar
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a DroneAttack (modo colocacion)");
        System.out.println("Usa: place <estructura> <fila> <columna>");
        System.out.println("Comando ver para imprimir mapa. exit para salir.\n");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("ver")) {
                mapaJugador.imprimirMapa();
            } else if (input.toLowerCase().startsWith("place ")) {
                String[] partes = input.split(" ");
                if (partes.length != 4) {
                    System.out.println("Formato invalido. Usa: place <estructura> <fila> <columna>");
                    continue;
                }

                try {
                    TipoEstructura estructura = TipoEstructura.valueOf(partes[1].toUpperCase());
                    
                    int fila = Integer.parseInt(partes[2]);
                    int columna = Integer.parseInt(partes[3]);

                    if (!mapaJugador.estaDentro(fila, columna)) {
                        System.out.println("Coordenadas fuera de rango.");
                        continue;
                    }

                    var celda = mapaJugador.getCelda(fila, columna);
                    if (!celda.estaVacia()) {
                        System.out.println("Ya hay algo en esa celda.");
                        continue;
                    }

                    celda.colocarEstructura(estructura);
                    System.out.println("Colocado: " + estructura + " en (" + fila + ", " + columna + ")");

                } catch (IllegalArgumentException e) {
                    System.out.println("Estructura invalida. Usa: radar, cuartel, torre, deposito");
                }
            } else {
                System.out.println("Comando no reconocido.");
            }
        }
        System.out.println("Fin del programa.");
    }
}
