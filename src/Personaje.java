public class Personaje {

    private String nombre;
    private int vida;
    private int vidaMax;
    private int ataque;
    private int defensa;
    private int nivel;
    private int experiencia;

    // TODO: elegir estructura para habilidades
    // private ???

    // TODO: elegir estructura para inventario
    // private ???

    public Personaje(String nombre, int vidaMax, int ataque, int defensa) {
        this.nombre = nombre;
        this.vidaMax = vidaMax;
        this.vida = vidaMax;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = 1;
        this.experiencia = 0;

        // TODO: inicializar colecciones
    }

    // =========================
    // MÉTODOS BÁSICOS
    // =========================

    public void mostrarEstado() {
        // TODO
    }

    public void descansar() {
        // TODO
    }

    // =========================
    // HABILIDADES (SET)
    // =========================

    public void anhadirHabilidad(String habilidad) {
        // TODO
    }

    public void mostrarHabilidades() {
        // TODO
    }

    public boolean tieneHabilidad(String habilidad) {
        // TODO
        return false;
    }

    // =========================
    // INVENTARIO (MAP)
    // =========================

    public void anhadirObjeto(String objeto, int cantidad) {
        // TODO
    }

    public void mostrarInventario() {
        // TODO
    }

    public boolean tieneObjeto(String objeto) {
        // TODO
        return false;
    }

    public void usarObjeto(String objeto) {
        // TODO
    }
}