/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Arena;

/**
 *
 * @author gambo
 */
public enum TipoCelda {

    VACIA(null),
    NIEBLA("/Imagenes/niebla.png"),
    CUARTEL("/Imagenes/cuartel.png"),
    RADAR("/Imagenes/radar.png"),
    DEPOSITO("/Imagenes/deposito.png"),
    TORRE("/Imagenes/torre.png"),
    DESTRUIDA("/Imagenes/destruido.png");
    
    private final String ruta;
    private TipoCelda(String ruta) {
            this.ruta = ruta;
        }
        
        public String getRuta(){
            return ruta;
        }

}
