package enemigos;

import java.util.Random;

public class Espectro extends Zombie {
    /**
     * Se crea con los mismos parámetros que el enemigo original. El constructor los adapta para el tipo de bicho.
     *
     * @param nombre
     * @param vida
     * @param ataque
     */
    public Espectro(String nombre, int vida, int ataque) {
        super(nombre, vida, ataque);
    }

    @Override
    public String getNombreMostrar() {
        return super.getNombre() + " (espectro)";
    }

    @Override
    public String getTipo() {
        return TIPO_ESPECTRO;
    }

    @Override
    public void recibirDanio(int cantidad) {
        Random rand = new Random();
        if (rand.nextInt(10)==0) {
            System.out.println(getNombreMostrar() + " esquiva el ataque!");
        } else {
            super.recibirDanio(cantidad);
        }

    }
}
