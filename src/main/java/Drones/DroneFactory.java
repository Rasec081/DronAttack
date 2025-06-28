/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Drones;

import java.awt.Point;

/**
 *
 * @author Daniel
 */
public class DroneFactory {
    
    public static IDron crearDrone(String tipo, Point objetivo) {
        switch (tipo.toLowerCase()) {
            case "bomb":
                return new BombDrone(objetivo);
            case "explosive":
                return new ExplosiveDrone(objetivo);
            case "sniper":
                return new SniperDrone(objetivo);
            case "multishot":
                return new MultishotDrone(objetivo);
            default:
                System.out.println("Tipo de dron no reconocido: " + tipo);
                return null;
        }
    }
}
