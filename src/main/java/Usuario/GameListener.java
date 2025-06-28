/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Usuario;

/**
 *
 * @author Daniel
 */
public interface GameListener {
    void energiaActualizada(int energia);
    void estructurasActualizadas(int activas);
    void mapaActualizado(); // cuando se descubre o actualiza algo
    void notificacion(String mensaje); // ataques, destrucción, etc.
    void turnoActualizado(boolean esMiTurno);
    void impactosActualizados(int impactos);
    void zonasReveladasActualizadas(int cantidad);
}
