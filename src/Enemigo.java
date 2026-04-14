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
        System.out.println( nombre + " tiene una vida de " + vida + " y un ataque de " + ataque);
    }

    public String getNombre() {
        return nombre;
    }

    public void recibirDanio(int cantidad) {
        // TODO semana 3:
        // restar vida al enemigo
        // la vida no debe quedar por debajo de 0
    }

    public boolean estaVivo() {
        // TODO semana 3:
        // devolver true si el enemigo sigue vivo, false si no
        return false;
    }
}