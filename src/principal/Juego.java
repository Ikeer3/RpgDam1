package principal;

import enemigos.Demonio;
import enemigos.Espectro;
import enemigos.Zombie;
import excepciones.TipoEnemigoDesconocido;
import jugador.Arquero;
import jugador.Guerrero;
import jugador.Mago;
import jugador.Personaje;
import enemigos.Enemigo;
import excepciones.NoSePuedeCurarException;
import excepciones.PersonajeMuertoException;
import excepciones.VidaYaCompletaException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    private final static int ENEMIGO_VIDA_MAXIMA = 120;
    private final static int ENEMIGO_VIDA_MINIMA = 80;
    private final static int ENEMIGO_ATAQUE_MAXIMO = 20;
    private final static int ENEMIGO_ATAQUE_MINIMO = 5;


    private final static String[] nombreEnemigos = {
            "Aiden", "Nyx", "Valeria", "Kael", "Riven",
            "Elara", "Dante", "Selene", "Orion", "Vesper",
            "Lucian", "Freya", "Cassian", "Lyra", "Draven",
            "Aria", "Magnus", "Zara", "Ezra", "Nova",
            "Rowan", "Seraphina", "Axel", "Iris", "Theron"
    };

    private final static String[] aliasEnemigos = {
            "the Fallen", "the Unbroken", "the Silent Blade", "the Last Shadow", "the Stormbringer",
            "the Iron Fist", "the Void Walker", "the Night Reaper", "the Flame Warden", "the Soul Hunter",
            "the Crimson Vow", "the Black Revenant", "the Thunderlord", "the Blood Oath", "the Phantom Strike",
            "the Abyss Caller", "the Dread Knight", "the Frostborn", "the Warborn", "the Doombringer",
            "the Eclipse", "the Relentless", "the Vindicator", "the Shadowborn", "the Riftbreaker"
    };

    private Personaje jugador;

    // Podríamos declararlo como "List", pero hasta ver interfaces no lo hacemos.
    private ArrayList<Enemigo> enemigos;

    private Scanner sc;

    public Juego() {


        this.sc = new Scanner(System.in);
        int opcion = 0;
        while (opcion < 1 ||opcion > 3) {
            try {
                System.out.println("Elige tu clase: Guerrero (1), Mago (2), Arquero (3)");
                opcion = sc.nextInt();
                if (opcion<1 || opcion>3) {
                    System.out.println("Selecciona una opción válida");
                }
            } catch (Exception e) {
                System.out.println("Selecciona una opción válida");
            }

        }
        // tras tener la opción seleccionada, consumimos lo que queda en el buffer
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        String nombre = "jugador";
        if (opcion==1) {
            this.jugador = new Guerrero(nombre);
        } else if (opcion == 2) {
            this.jugador = new Mago(nombre);
        } else {
            this.jugador = new Arquero(nombre);
        }

        // Alternativamente, podemos inicializar nuestro personaje así:
        //this.jugador = opcion == 1 ? new Jugador.Guerrero(nombre) : opcion==2 ? new Jugador.Mago(nombre) : new Jugador.Arquero(nombre);

        this.enemigos = new ArrayList<Enemigo>();
    }

    public void iniciar() {
        int opcion;

        do {
            System.out.println("Pulsa una tecla para continuar");
            sc.nextLine();
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    jugador.mostrarEstado();
                    break;
                case 2:
                    Enemigo aEnfrentar = buscarEnemigo();
                    enemigos.add(aEnfrentar);
                    try {
                        combatir(aEnfrentar);
                    } catch (PersonajeMuertoException pme) {
                        System.out.println("No puedes atacar! Tu pj está muerto.");
                    }
                    break;
                case 3:
                    try {
                        boolean descansoExitoso = jugador.descansar();
                        if (!descansoExitoso) {
                            System.out.println("Un enemigo interrumpe el sueño!");
                            Enemigo nuevo = generarEnemigoPasado();
                            enemigos.add(nuevo);
                            combatir(nuevo);
                        }
                    } catch (VidaYaCompletaException vame) {
                        System.out.println("No se puede descansar. La vida está al máximo: " + vame.getVidaActual());
                    } catch (PersonajeMuertoException e) {
                        System.out.println("Un personaje muerto NO puede combatir.");
                    } catch (TipoEnemigoDesconocido e) {
                        System.out.println("Se ha encontrado un tipo de enemigo desconocido. No se sabe qué hacer con él: " + e.getTipoEnemigo());
                        System.out.println("Abortando la partida.");
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    jugador.mostrarInventario();
                    break;
                case 5:
                    jugador.mostrarHabilidades();
                    break;
                case 6:
                    mostrarEnemigosEncontrados();
                    break;
                case 7:
                    guardarPersonaje();
                    break;
                case 8:
                    cargarPersonaje();
                    break;
                case 9:
                    try {
                        jugador.curar();
                    } catch (NoSePuedeCurarException nspce) {
                        System.out.println("No se puede curar. El personaje lleva " + nspce.getCombatesTotales() + " combates, y se ha curado en el combate " + nspce.getCombateUltimaCuracion());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }


    private void mostrarMenu() {
        System.out.println();
        System.out.println("===== MENU =====");
        System.out.println("1. Ver estado");
        System.out.println("2. Buscar enemigo");
        System.out.println("3. Descansar");
        System.out.println("4. Ver inventario");
        System.out.println("5. Ver habilidades");
        System.out.println("6. Ver enemigos encontrados");
        System.out.println("7. Guardar personaje");
        System.out.println("8. Cargar personaje");
        System.out.println("9. Curar");
        System.out.println("0. Salir");
        System.out.print("Elige opción: ");
    }

    /**
     * Esta función recupera un enemigo pasado y devuelve su siguiente evolución.
     * Si no hay evolución (no hay nada más alto que demonio), devuelve una nueva copia del demonio.
     * Si no puede devolver ninguno, genera un enemigo básico nuevo. .
     * @return
     */
    private Enemigo generarEnemigoPasado() throws TipoEnemigoDesconocido {
        Random rand = new Random();
        Enemigo resultado = null;
        if (enemigos.size()>0) {
            Enemigo original = enemigos.get(rand.nextInt(enemigos.size()));
            switch (original.getTipo()) {
                case Enemigo.TIPO_BASICO:
                    resultado = new Zombie(original.getNombre(), original.getVidaMaxima(), original.getAtaque());
                    break;
                case Enemigo.TIPO_ZOMBIE:
                    resultado = new Espectro(original.getNombre(), original.getVidaMaxima(), original.getAtaque());
                    break;
                case Enemigo.TIPO_ESPECTRO:
                    resultado = new Demonio(original.getNombre(), original.getVidaMaxima(), original.getAtaque());
                    break;
                case Enemigo.TIPO_DEMONIO:
                    resultado = new Demonio(original.getNombre(), original.getVidaMaxima(), original.getAtaque());
                    break;
                default:
                    throw new TipoEnemigoDesconocido(original.getTipo());
            }
        } else {
            resultado = buscarEnemigo();
        }
        return resultado;

    }

    private Enemigo buscarEnemigo() {

        // Para crear un enemigo aleatorio, vamos a usar 2 arrays de nombre y alias (constantes) para generar nombres aleatorios
        // Además, vamos a usar límites superiores e inferiores para el ataque y la vida, para que también sean aleatorios..
        Random aleatorio = new Random();

        String nombre = nombreEnemigos[aleatorio.nextInt(nombreEnemigos.length)] + " " +
                aliasEnemigos[aleatorio.nextInt(aliasEnemigos.length)];
        Enemigo enemigo = new Enemigo(nombre,
                aleatorio.nextInt(ENEMIGO_VIDA_MINIMA, ENEMIGO_VIDA_MAXIMA+1),
                aleatorio.nextInt(ENEMIGO_ATAQUE_MINIMO, ENEMIGO_ATAQUE_MAXIMO+1)
                );
        System.out.println("Has encontrado a un enemigo:");
        enemigo.mostrarInfo();
        return enemigo;
    }

    private void mostrarEnemigosEncontrados() {

        System.out.println("Hasta ahora has encontrado " + enemigos.size());
        System.out.println("Te has encontrado con: ");
        for (int i = 0; i<enemigos.size(); i++) {
            System.out.println((i+1) + " - " + enemigos.get(i).getNombreMostrar()) ;
        }
    }

    private void guardarPersonaje() {
        try {
            GestorFicheros.guardarPersonaje(jugador);
        } catch (IOException e) {
            System.out.println("No se ha podido guardar el personaje.");
            e.printStackTrace();
        }
    }

    private void cargarPersonaje() {
        try {
            jugador = GestorFicheros.cargarPersonaje();
        } catch (IOException e) {
            System.out.println("No se ha podido cargar el personaje.");
            e.printStackTrace();
        }
    }

    private boolean combatir(Enemigo enemigo) throws PersonajeMuertoException {
        System.out.println("Comienza la pelea");
        this.jugador.combatio();
        boolean turnoJugador = true;
        boolean finalizado = false;
        boolean ganaJugador = true;

        while (!finalizado) {
            if (turnoJugador) {
                jugador.atacar(enemigo);
                if (!enemigo.estaVivo()) {
                    finalizado = true;
                    ganaJugador = true;
                    System.out.println("El jugador ha ganado! Le queda de vida: " + jugador.getVida());
                }
            } else {
                jugador.recibirDanho(enemigo.atacar());
                if (jugador.getVida()<=0) {
                    System.out.println("El jugador ha perdido!");
                    finalizado = true;
                    ganaJugador = false;
                }
            }
            turnoJugador = !turnoJugador;
        }

        if (ganaJugador) {
            jugador.ganarExperiencia(enemigo.getVidaMaxima());
        }
        return ganaJugador;
    }

}