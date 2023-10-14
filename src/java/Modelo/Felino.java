
package Modelo;

public class Felino extends Mascota {
    private boolean libreToxoplasmosis;

    public Felino(String nombre, String raza, String color, int edad, boolean libreToxoplasmosis) {
        super(nombre, raza, color, edad, "felino", libreToxoplasmosis, 0); 
        this.libreToxoplasmosis = libreToxoplasmosis;
    }

    public boolean isLibreToxoplasmosis() {
        return libreToxoplasmosis;
    }
}
