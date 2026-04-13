import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Personaje {

    private String nombre;
    private int vida;
    private int vidaMax;
    private int ataque;
    private int defensa;
    private int nivel;
    private int experiencia;

    // Podríamos declararlos como Set y Map, pero hasta que veamos interfaces no lo haremos
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
        this.habilidades = new HashSet<String>();
        this.inventario = new HashMap<String, Integer>();
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
        System.out.println("Añadiendo la habilidad: " + habilidad);
        if (habilidades.contains(habilidad)) {
            System.out.println("No se puede añadir " + habilidad + ": ¡ya la tenía!");
        } else {
            this.habilidades.add(habilidad);
            System.out.println("Habilidad " + habilidad + " añadida.");
        }
    }

    public void mostrarHabilidades() {
        if (habilidades.isEmpty()) {
            System.out.println("No tienes habilidades");
        } else {
            System.out.println("Tienes " + habilidades.size() + " habilidades. Las habilidades son: ");
            for (String habilidad : habilidades) {
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

        // Versión extendida (la más clara a estas alturas)
        int cantidadAConfigurar;
        if (inventario.containsKey(objeto)) {
            cantidadAConfigurar = cantidad + inventario.get(objeto);
        } else {
            cantidadAConfigurar = cantidad;
        }
        inventario.put(objeto, cantidadAConfigurar);

        // Versión simplificada a una operación ternaria
        // inventario.put(objeto, inventario.containsKey(objeto)?inventario.get(objeto) + cantidad : cantidad);

        System.out.println("Ahora de " + objeto + " hay " + inventario.get(objeto));
    }

    public void mostrarInventario() {
        System.out.println("Mostrando inventario: ");

        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío!");
        } else {
            // Versión estándar
            Set<String> todasLasClaves = inventario.keySet();
            for (String clave : todasLasClaves) {
                System.out.println("- " + clave + ": " + inventario.get(clave));
            }

            // Versión usando "Entry<key,value" - no estudiada en clase.
            // for (Map.Entry<String,Integer> claveValor : inventario.entrySet()) {
            //     System.out.println("- " + claveValor.getKey() + ": " + claveValor.getValue());
            // }
        }
    }

    public boolean tieneObjeto(String objeto) {
        return inventario.containsKey(objeto);
    }

    public void usarObjeto(String objeto) {
        if (!inventario.containsKey(objeto))  {
            System.out.println("No tienes ningún objeto de tipo " + objeto);
        } else {
            // En el caso de que por algún error se haya guardado un número negativo o 0 de objetos:
            if (inventario.get(objeto) <= 0) {
                System.out.println("No tienes ningún objeto de tipo " + objeto);
                inventario.remove(objeto);
            } else {
                inventario.put(objeto, inventario.get(objeto) -1);
                System.out.println("Se ha usado un " + objeto);
                if (inventario.get(objeto) == 0) {
                    System.out.println("No te quedan más. Eliminando del inventario.");
                    inventario.remove(objeto);
                } else {
                    System.out.println("Te quedan de " + objeto + " " + inventario.get(objeto));
                }
            }
        }
    }
}