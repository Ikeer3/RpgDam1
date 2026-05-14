package enemigos;

public class Enemigo {

    private String nombre;
    private int vida;
    private int ataque;
    private int vidaMaxima;

    public final static String TIPO_BASICO = "Básico";
    public final static String TIPO_ZOMBIE = "Zombie";
    public final static String TIPO_ESPECTRO = "Espectro";
    public final static String TIPO_DEMONIO = "Demonio";

    public Enemigo(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.vidaMaxima = vida;
    }

    public String getTipo() {
        return TIPO_BASICO;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void mostrarInfo() {
        System.out.println( getNombreMostrar() + " tiene una vida de " + vida + " y un ataque de " + ataque);
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreMostrar() {
        return nombre;
    }

    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        vida = Math.max(0, vida);
    }

    public boolean estaVivo() {
        return vida>0;
    }

    public int getAtaque() {
        return ataque;
    }

    public int atacar() {
        return getAtaque();
    }
}