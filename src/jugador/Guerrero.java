package jugador;

import java.util.HashMap;
import java.util.HashSet;

/**
 * El guerrero es capaz de recibir golpes más fuertes. Absorbe el 10% del daño.
 */
public class Guerrero extends Personaje {

    public final static String NOMBRE_CLASE = "Guerrero";

    public Guerrero(String nombre, int vidaMax, int ataque, int defensa) {
        super(nombre, vidaMax, ataque, defensa, NOMBRE_CLASE);
    }

    public Guerrero(String nombre, int vida, int vidaMax, int ataque, int defensa, int nivel, int experiencia, HashSet<String> habilidades, HashMap<String, Integer> inventario, int numeroCombates, int combateUltimaCuracion) {
        super(nombre, vida, vidaMax, ataque, defensa, nivel, experiencia, habilidades, inventario, numeroCombates, combateUltimaCuracion, NOMBRE_CLASE);
    }

    public Guerrero(String nombre) {
        // Inicializamos el guerrero con más vida
        super(nombre, (int) Math.ceil(Personaje.VIDA_INICIAL * 1.1d), Personaje.ATAQUE_INICIAL , Personaje.DEFENSA_INICIAL, NOMBRE_CLASE);
    }

    @Override
    public void recibirDanho(int cantidad) {
        // Primero multiplicamos por 0,9; después, aproximamos al siguiente entero - 5.9 nos da 6 - y lo transformamos de double a entero.
        super.recibirDanho(  (int) Math.ceil(cantidad * 0.9));
    }
}
