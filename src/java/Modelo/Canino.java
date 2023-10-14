
package Modelo;

public class Canino extends Mascota {
    private int nivelEntrenamiento;

    public Canino(String nombre, String raza, String color, int edad, int nivelEntrenamiento) {
        super(nombre, raza, color, edad, "canino", false, nivelEntrenamiento);
        this.nivelEntrenamiento = nivelEntrenamiento;
    }

   
    
}
