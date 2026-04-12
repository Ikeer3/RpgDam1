public class Enemigo {

    private String nombre;
    private int vida;
    private int ataque;

    public Enemigo(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public void mostrarInfo() {
        // TODO
    }

    public String getNombre() {
        return nombre;
    }
}