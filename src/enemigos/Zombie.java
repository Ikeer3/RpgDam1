package enemigos;

public class Zombie extends Enemigo{

    /**
     * Se crea con los mismos parámetros que el enemigo original. El constructor los adapta para el tipo de bicho.
     * @param nombre
     * @param vida
     * @param ataque
     */
    public Zombie(String nombre, int vida, int ataque) {
        super(nombre , (int) Math.ceil(vida * 1.2d), (int) Math.ceil(ataque * 1.2d));
    }

    @Override
    public String getNombreMostrar() {
        return super.getNombre() + "(zombie)";
    }

    @Override
    public String getTipo() {
        return TIPO_ZOMBIE;
    }

}
