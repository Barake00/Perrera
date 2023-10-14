package Modelo;

public class Mascota {
    private String nombre;
    private String raza;
    private String color;
    private int edad;
    private String tipo;
    private boolean toxoplasmosis; 
    private int nivelEntrenamiento;

    public Mascota(String nombre, String raza, String color, int edad, String tipo, boolean toxoplasmosis, int nivelEntrenamiento) {
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.edad = edad;
        this.tipo = tipo;
        this.toxoplasmosis = toxoplasmosis;
        this.nivelEntrenamiento = nivelEntrenamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public String getColor() {
        return color;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean tieneToxoplasmosis() {
        return toxoplasmosis;
    }

    public int getNivelEntrenamiento() {
        return nivelEntrenamiento;
    }
}
