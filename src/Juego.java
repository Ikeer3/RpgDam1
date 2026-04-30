import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    private static final int ENEMIGO_VIDA_MAXIMA = 100;
    private static final int ENEMIGO_VIDA_MINIMA = 80;
    private static final int ENEMIGO_ATAQUE_MAXIMO = 20;
    private static final int ENEMIGO_ATAQUE_MINIMO = 5;

    private static final String[] nombresEnemigos = {
            "Bowser", "Ganondorf", "Sephiroth", "Dr. Eggman",
            "Ridley", "Nemesis", "Pyramid Head", "GLaDOS",
            "Handsome Jack", "Vaas Montenegro", "Albert Wesker", "Arthas",
            "Diablo", "Kefka", "Vergil", "Akuma",
            "M. Bison", "Liquid Snake", "Saren", "The Illusive Man"
    };

    private static final String[] aliasEnemigos = {
            "Sombra Oscura", "Guardián de Fuego", "Espectro Helado", "Titán de Piedra",
            "Serpiente Abisal", "Cazador Nocturno", "Bestia Carmesí", "Hechicero Maldito",
            "Dragón de Cenizas", "Caballero Caído", "Señor de las Sombras", "Gólem de Hierro",
            "Bruja del Pantano", "Demonio Errante", "Lobo Espectral", "Centinela Antiguo",
            "Rey Esqueleto", "Engendro del Vacío", "Ángel Corrupto", "Coloso Marchito"
    };

    private Personaje jugador;
    private ArrayList<Enemigo> enemigos;

    private Scanner sc;

    public Juego() {
        this.jugador = new Personaje("Jugador", 100, 20, 10);
        this.sc = new Scanner(System.in);
        this.enemigos = new ArrayList<>();
    }

    public void iniciar() {

        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    jugador.mostrarEstado();
                    break;
                case 2:
                    buscarEnemigo();
                    break;
                case 3:
                    jugador.descansar();
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
        System.out.println("0. Salir");
        System.out.print("Elige opción: ");
    }

    private void buscarEnemigo() {

        Random random = new Random();

        String nombre = nombresEnemigos[random.nextInt(nombresEnemigos.length)] + " "
                + aliasEnemigos[random.nextInt(aliasEnemigos.length)];

        Enemigo enemigo = new Enemigo(nombre,
                random.nextInt(ENEMIGO_VIDA_MINIMA, ENEMIGO_VIDA_MAXIMA+1),
                random.nextInt(ENEMIGO_ATAQUE_MINIMO, ENEMIGO_ATAQUE_MAXIMO+1));

        enemigos.add(enemigo);
        System.out.println("Has encontrado a un enemigo:");
        enemigo.mostrarInfo();
    }

    private void mostrarEnemigosEncontrados() {

        // TODO:
        // Recorrer colección y mostrar enemigos

    }
}