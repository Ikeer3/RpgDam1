package enemigos;

import java.util.Random;

public class Demonio extends Espectro {
    /**
     * Se crea con los mismos parámetros que el enemigo original. El constructor los adapta para el tipo de bicho.
     *
     * @param nombre
     * @param vida
     * @param ataque
     */
    public Demonio(String nombre, int vida, int ataque) {
        super(nombre, vida, ataque);
    }

    @Override
    public String getNombreMostrar() {
        return super.getNombre() + " (demonio)";
    }

    @Override
    public String getTipo() {
        return TIPO_DEMONIO;
    }

    @Override
    public int atacar() {
        Random rand = new Random();
        int ataque = super.atacar();
        if (rand.nextInt(5)==0) {
            System.out.println(getNombreMostrar() + " hace daño crítico!");
            return ataque * 2;
        } else {
            return ataque;
        }
    }
}
