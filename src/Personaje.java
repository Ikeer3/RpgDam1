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

    // Este es el constructor para una partida nueva. Hace un personaje a través del constructor que
    // recibe TODOS los parámetros, pero inicializa como vacíos algunos.
    public Personaje(String nombre, int vidaMax, int ataque, int defensa) {
        this(nombre, vidaMax, vidaMax, ataque, defensa, 1, 0, new HashSet<String>(), new HashMap<String, Integer>());
    }

    // Constructor para hacer un personaje a partir de los datos que tenemos guardados del mismo.
    public Personaje(String nombre, int vida, int vidaMax, int ataque, int defensa, int nivel, int experiencia,
    HashSet<String> habilidades, HashMap<String, Integer> inventario) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMax = vidaMax;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.habilidades = habilidades;
        this.inventario = inventario;
    }

    // =========================
    // MÉTODOS BÁSICOS
    // =========================

    public void mostrarEstado() {
        // TODO semana 3:
        // mostrar todos los datos principales del personaje
    }

    public void descansar() {
        // TODO semana 3:
        // si la vida ya está al máximo, lanzar excepción
        // si no, recuperar vida
    }

    public void ganarExperiencia(int cantidad) {
        // TODO semana 3:
        // sumar experiencia
    }

    public void atacar(Enemigo enemigo)  {
        // TODO semana 3:
        // si el personaje no puede atacar por estar muerto, lanzar excepción "PersonajeMuertoException"
        // si no, dañar al enemigo
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
        // TODO semana 3:
        // si no existe el objeto, lanzar excepción ObjetoNoDisponibleException
        // si su cantidad es 0 o menor, lanzar excepción ObjetoNoDisponibleException y eliminarlo
        // si se puede usar, restar 1
        // si queda a 0, eliminarlo del inventario
    }
}