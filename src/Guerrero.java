import java.util.HashMap;
import java.util.HashSet;

/**
 * El guerrero es capaz de recibir golpes más fuertes. Absorbe el 10% del daño.
 */
public class Guerrero extends Personaje {
    public Guerrero(String nombre, int vidaMax, int ataque, int defensa) {
        super(nombre, vidaMax, ataque, defensa);
    }

    public Guerrero(String nombre, int vida, int vidaMax, int ataque, int defensa, int nivel, int experiencia, HashSet<String> habilidades, HashMap<String, Integer> inventario) {
        super(nombre, vida, vidaMax, ataque, defensa, nivel, experiencia, habilidades, inventario, 0, 0);
    }

    public Guerrero(String nombre) {
        // Inicializamos el guerrero con más vida
        super(nombre, (int) Math.ceil(Personaje.VIDA_INICIAL * 1.1d), Personaje.ATAQUE_INICIAL , Personaje.DEFENSA_INICIAL);
    }

    @Override
    public void recibirDanho(int cantidad) {
        // Primero multiplicamos por 0,9; después, aproximamos al siguiente entero - 5.9 nos da 6 - y lo transformamos de double a entero.
        super.recibirDanho(  (int) Math.ceil(cantidad * 0.9));
    }
}
