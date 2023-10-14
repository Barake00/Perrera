package Modelo;
import Controlador.RegistroMascotas;
import java.util.List;


public interface Calculos {
    public double getPromedioEdad(List<Mascota> mascotas);
    public int getcantCaninos(List<Mascota> mascotas);
    public int getCantFelinos(List<Mascota> mascotas);
}
