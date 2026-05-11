package jugador;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * El mago puede usar su magia para esquivar ataques. Esquiva el 20% de los ataques.
 */
public class Mago extends Personaje {

    public final static String NOMBRE_CLASE = "Mago";

    public Mago(String nombre, int vidaMax, int ataque, int defensa) {
        super(nombre, vidaMax, ataque, defensa, NOMBRE_CLASE);
    }

    public Mago(String nombre, int vida, int vidaMax, int ataque, int defensa, int nivel, int experiencia, HashSet<String> habilidades, HashMap<String, Integer> inventario, int numeroCombates, int combateUltimaCuracion) {
        super(nombre, vida, vidaMax, ataque, defensa, nivel, experiencia, habilidades, inventario, numeroCombates, combateUltimaCuracion, NOMBRE_CLASE);
    }

    public Mago(String nombre) {
        // Inicializamos el mago con más ataque pero menos vida
        super(nombre, (int) Math.floor(Personaje.VIDA_INICIAL * 0.9d), (int) Math.ceil(Personaje.ATAQUE_INICIAL*1.2) , Personaje.DEFENSA_INICIAL, NOMBRE_CLASE);
    }

    @Override
    public void recibirDanho(int cantidad) {
        Random random = new Random();
        boolean esquiva = random.nextInt(10) <=1; // Esquiva sacando 0 o 1, no esquiva sacando 2, 3, ..., 9
        if (esquiva) {
            System.out.println(getNombre() + " esquiva el ataque!");
        } else {
            super.recibirDanho(cantidad);
        }
    }
}
