
package Modelo;

import java.util.List;

public class DatosMascotas implements Calculos {

    public double getPromedioEdad(List<Mascota> mascotas) {
        if (mascotas.isEmpty()) {
            return 0.0;
        }
        int totalEdad = 0;
        for (Mascota mascota : mascotas) {
            totalEdad += mascota.getEdad();
        }
        return (double) totalEdad / mascotas.size();
    }
    @Override

    public int getcantCaninos(List<Mascota> mascotas) {
        int totalCaninos = 0;
        for (Mascota mascota : mascotas) {
            if ("canino".equals(mascota.getTipo())) {
                totalCaninos++;
            }
        }
        return totalCaninos;
    }
    @Override

    public int getCantFelinos(List<Mascota> mascotas) {
        int totalFelinos = 0;
        for (Mascota mascota : mascotas) {
            if ("felino".equals(mascota.getTipo())) {
                totalFelinos++;
            }
        }
        return totalFelinos;
    }
}
