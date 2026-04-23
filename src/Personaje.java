import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Personaje {

    private String nombre;
    private int vida;
    private int vidaMax;
    private int ataque;
    private int defensa;
    private int nivel;
    private int experiencia;

    private HashSet<String> habilidades;
    private HashMap<String, Integer> inventario;

    public Personaje(String nombre, int vidaMax, int ataque, int defensa) {
        this.nombre = nombre;
        this.vidaMax = vidaMax;
        this.vida = vidaMax;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = 1;
        this.experiencia = 0;
        this.habilidades = new HashSet<>();
        this.inventario = new HashMap<>();
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
        if (habilidades.contains(habilidad)) {
            System.out.println("La habilidad " + habilidad + " ya existe. No se puede añadir!!");
        } else {
            habilidades.add(habilidad);
            System.out.println("La habilidad " + habilidad + " ha sido añadida correctamente!!");
        }
    }

    public void mostrarHabilidades() {
        if (habilidades.isEmpty()) {
            System.out.println("No tienes ninguna habilidad");
        } else {
            System.out.println("Tienes " + habilidades.size() + ". Las habilidades son: ");
            for (String habilidad: habilidades) {
                System.out.println("- " + habilidad);
            }
        }
    }

    public boolean tieneHabilidad(String habilidad) {
        return habilidades.contains(habilidad);
    }

    // =========================
    // INVENTARIO (MAP)
    // =========================

    public void anhadirObjeto(String objeto, int cantidad) {
        System.out.println("Añadiendo " + cantidad + " de " + objeto);
        int cantidadAnhadir;
        if (inventario.containsValue(objeto)) {
            cantidadAnhadir = cantidad + inventario.get(objeto);
        } else {
            cantidadAnhadir = cantidad;
        }
        inventario.put(objeto, cantidadAnhadir);
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("No tienes ningún objeto. El inventario está vacío");
        } else {
            System.out.println("Tienes " + inventario.size() + ". Los objetos son: ");
            Set<String> todasClaves = inventario.keySet();
            for (String clave: todasClaves) {
                System.out.println("- " + clave + ": " + inventario.get(clave));
            }
        }
    }

    public boolean tieneObjeto(String objeto) {
        return inventario.containsKey(objeto);
    }

    public void usarObjeto(String objeto) {
        if (!inventario.containsKey(objeto)) {
            System.out.println("No tienes ningún objeto de tipo " + objeto);
        } else {
            if (inventario.get(objeto) <= 0) {
                System.out.println("No tienes ningún objeto de tipo " + objeto);
                inventario.remove(objeto);
            } else {
                inventario.put(objeto, inventario.get(objeto) - 1);
                System.out.println("Se ha usado un " + objeto);
                if (inventario.get(objeto) == 0) {
                    System.out.println("No te quedan más. Eliminado del inventario");
                    inventario.remove(objeto);
                } else {
                    System.out.println("Te quedan " + objeto + " " + inventario.get(objeto));
                }
            }
        }
    }
}