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
public enum TipoMensaje implements Serializable{
    CONEXION,
    DESCONEXION,
    MAPA_COMPLETO,
    ASIGNACION_NOMBRE,
    INICIO_PARTIDA,
    TURNO,
    ATAQUE,
    CHAT_USER,
    CHAT_SERVER,
    NOTIFICACION,
    ACTUALIZAR_MAPA_ENEMIGO,
    ENERGIA_EXTRA,
    RESULTADOS_ATAQUE,
    ACTUALIZAR_MAPA_PROPIO

}
