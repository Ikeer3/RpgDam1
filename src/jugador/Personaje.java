package jugador;

import enemigos.Enemigo;
import excepciones.NoSePuedeCurarException;
import excepciones.ObjetoNoDisponibleException;
import excepciones.PersonajeMuertoException;
import excepciones.VidaYaCompletaException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Personaje {

    protected final static int VIDA_INICIAL = 100;
    protected final static int ATAQUE_INICIAL = 10;
    protected final static int DEFENSA_INICIAL = 10;
    public final static String NOMBRE_CLASE = "Genérico";
    private final static int EXPERIENCIA_SUBIR_NIVEL = 200;

    private String nombre;
    private int vida;
    private int vidaMax;
    private int ataque;
    private int defensa;
    private int nivel;
    private int experiencia;
    private String clase;

    // Podríamos declararlos como Set y Map, pero hasta que veamos interfaces no lo haremos
    private HashSet<String> habilidades;
    private HashMap<String, Integer> inventario;

    // Necesitamos llevar una cuenta de combates para curarnos. Por ello, guardaremos internamente 2 variables:
    // - Número de combates.
    // - Número de última curación.
    // Por ejemplo, si tenemos 10 combates realizados, y nos hemos curado en el combate 8, no nos deja curarnos aún.
    // Además, esta información también tiene que ir guardada en el fichero de guardado/cargado de partida.
    // En una partida nueva ambos valores se inicializan a 0.
    // Finalmente, necesitaremos también una función "combatio()" que sume 1 al número de combates. A esta
    //  función hay que llamar siempre que se haga un combate.

    private int numeroCombates;
    private int combateUltimaCuracion;


    // Este es el constructor para una partida nueva. Hace un personaje a través del constructor que
    // recibe TODOS los parámetros, pero inicializa como vacíos algunos.
    public Personaje(String nombre, int vidaMax, int ataque, int defensa, String clase) {
        this(nombre, vidaMax, vidaMax, ataque, defensa, 1, 0, new HashSet<String>(), new HashMap<String, Integer>(),0,0, clase);
    }

    // Inicializa un personaje de nivel 1.
    public Personaje(String nombre, String clase) {
        this(nombre, VIDA_INICIAL, ATAQUE_INICIAL, DEFENSA_INICIAL, clase );
    }

    // Inicializa un personaje de nivel 1.
    public Personaje(String nombre) {
        this(nombre, NOMBRE_CLASE );
    }

    // Constructor para hacer un personaje a partir de los datos que tenemos guardados del mismo.
    public Personaje(String nombre, int vida, int vidaMax, int ataque, int defensa, int nivel, int experiencia,
    HashSet<String> habilidades, HashMap<String, Integer> inventario, int numeroCombates, int combateUltimaCuracion, String clase) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMax = vidaMax;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.habilidades = habilidades;
        this.inventario = inventario;
        this.numeroCombates = numeroCombates;
        this.combateUltimaCuracion = combateUltimaCuracion;
        this.clase = clase == null ? NOMBRE_CLASE:clase;
    }

    // =========================
    // MÉTODOS BÁSICOS
    // =========================

    public void mostrarEstado() {
        // Podríamos usar String, pero introducimos StringBuffer como una manera más eficiente
        // de manejar concatenar cadenas, etc.
        StringBuffer habilidadesEnString = new StringBuffer();
        for (String habilidad:habilidades) {
            habilidadesEnString.append(habilidad).append(" - ");
        }
        // Opcionalmente, podríamos ponerlo más bonito eliminando el " - " que añadimos al final (si lo hemos añadido)

        StringBuffer inventarioEnString = new StringBuffer();

        for (String objeto: inventario.keySet()) {
            inventarioEnString.append(objeto + ": " + inventario.get(objeto) + " - ");
        }
        // Opcionalmente, podríamos ponerlo más bonito eliminando el " - " que añadimos al final (si lo hemos añadido)


        System.out.println("Jugador.Personaje - " + clase + " - " +
                "\tNombre:'" + nombre + '\'' +
                "\n\tVida=" + vida +
                " de " + vidaMax +
                "\n\tAtaque=" + ataque +
                "\n\tDefensa=" + defensa +
                "\n\tNivel=" + nivel +
                "\n\tExperiencia=" + experiencia +
                "\n\tHabilidades=" + habilidadesEnString.toString() +
                "\n\tInventario=" + inventarioEnString.toString() +
                "\n\tCombates=" + numeroCombates +
                "\n\tCombates última curación=" + combateUltimaCuracion);
    }

    public void descansar() throws VidaYaCompletaException {
        if (vida==vidaMax) {
            throw new VidaYaCompletaException(vida);
        } else {
            vida = vidaMax;
        }
    }

    public void ganarExperiencia(int cantidad) {
        // Habría que comprobar que la experiencia es positiva, pero no se ha pedido en el enunciado.
        // Como solución, no daremos error, simplemente no sumamos si es negativa.
        // Vamos a subir de nivel primero con 200 puntos de experiencia

        experiencia += Math.max(0,cantidad);
        int nivelTrasGanar = experiencia/EXPERIENCIA_SUBIR_NIVEL + 1; // 190 exp: nivel 1; 250; nivel 2, etc.
        if (nivelTrasGanar > nivel) {
            System.out.println("Has subido de nivel! Tu nivel ahora es " + nivelTrasGanar);
            // por si acaso se ha ganado mucha experiencia como para subir 2 niveles, hacemos un bucle para ir desde el nivel antiguo hasta el de ahora
            Random rand = new Random();
            for (int n=nivel; n<nivelTrasGanar; n++) {
                vidaMax += rand.nextInt(10,21);
                System.out.println("Vida máxima pasa a " + vidaMax);
                ataque += 10;
                System.out.println("Ataque pasa a " + ataque);
                System.out.println("Recupera toda la vida!");
                vida = vidaMax;
            }
        }
        nivel = nivelTrasGanar;


    }

    public void atacar(Enemigo enemigo) throws PersonajeMuertoException {
        if (vida<=0) {
            throw new PersonajeMuertoException();
        } else {
            System.out.println(getNombre() + " hace " + ataque + " a " + enemigo.getNombre());
            enemigo.recibirDanio(ataque);
        }
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

    public String getNombre() {
        return nombre;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public HashSet<String> getHabilidades() {
        return habilidades;
    }

    public HashMap<String, Integer> getInventario() {
        return inventario;
    }

    public void usarObjeto(String objeto) throws ObjetoNoDisponibleException {

        if (!inventario.containsKey(objeto)) {
            throw new ObjetoNoDisponibleException(objeto);
        } else {
            if (inventario.get(objeto)<=0) {
                inventario.remove(objeto);
                throw new ObjetoNoDisponibleException(objeto);
            } else {
                int cantidadTrasUsar = inventario.get(objeto)-1;
                inventario.put(objeto, cantidadTrasUsar);
                System.out.println("Usando " + objeto + ". Quedan " + cantidadTrasUsar);
                if (cantidadTrasUsar==0) {
                    System.out.println("Eliminando el objeto del inventario.");
                    inventario.remove(objeto);
                }
            }
        }
    }
    public void recibirDanho(int cantidad) {
        int danho = Math.max(0, cantidad-defensa);
        System.out.println(getNombre() + " recibe " + danho + " de daño.");
        vida -= danho;
    }

    public void curar() throws NoSePuedeCurarException {
        if (numeroCombates-combateUltimaCuracion<3) {
            throw new NoSePuedeCurarException(combateUltimaCuracion, numeroCombates);
        } else {
            int curacion = vidaMax/2;
            vida = Math.min(vidaMax, vida + curacion);
            combateUltimaCuracion = numeroCombates;
            System.out.println(getNombre() + " se cura. Tiene ahora: " + vida + " de vida.");
        }
    }

    // Métodos extra

    /**
     * Hay que llamar a este métod cada vez que se hace un combate.
     */
    public void combatio() {
        numeroCombates++;
    }

    public int getNumeroCombates() {
        return numeroCombates;
    }

    public int getCombateUltimaCuracion() {
        return combateUltimaCuracion;
    }

    public String getClase() {
        return clase;
    }

}