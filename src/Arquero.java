import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * El arquero es capaz de provocar impactos críticos un 10% de las veces
 */
public class Arquero extends Personaje {
    public Arquero(String nombre, int vidaMax, int ataque, int defensa) {
        super(nombre, vidaMax, ataque, defensa);
    }

    public Arquero(String nombre, int vida, int vidaMax, int ataque, int defensa, int nivel, int experiencia, HashSet<String> habilidades, HashMap<String, Integer> inventario) {
        super(nombre, vida, vidaMax, ataque, defensa, nivel, experiencia, habilidades, inventario, 0, 0);
    }

    public Arquero(String nombre) {
        // Inicializamos el arquero con algo más de ataque que los valores por defecto
        super(nombre, Personaje.VIDA_INICIAL, (int) Math.ceil(Personaje.ATAQUE_INICIAL * 1.1d) , Personaje.DEFENSA_INICIAL);
    }

    @Override
    public void atacar(Enemigo enemigo) throws PersonajeMuertoException {
        System.out.println(getNombre() + " ataca a " + enemigo.getNombre()+ ". ");
        if (getVida()<=0) {
            throw new PersonajeMuertoException();
        } else {
            Random random = new Random();
            boolean esCritico = random.nextInt(10)==0;
            if (esCritico) {
                int danho = getAtaque() * 2;
                enemigo.recibirDanio(getAtaque() * 2);
                System.out.println(getNombre() + " hace un ataque crítico! Hace " + danho);
            } else {
                super.atacar(enemigo);
            }

        }
    }

}
