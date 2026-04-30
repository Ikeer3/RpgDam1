import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    private static final int ENEMIGO_VIDA_MAXIMA = 100;
    private static final int ENEMIGO_VIDA_MINIMA = 80;
    private static final int ENEMIGO_ATAQUE_MAXIMO = 20;
    private static final int ENEMIGO_ATAQUE_MINIMO = 5;

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



        // TODO:
        // 1. Crear enemigo aleatorio
        // 2. Añadirlo a la colección
        // 3. Mostrar información

    }

    private void mostrarEnemigosEncontrados() {

        // TODO:
        // Recorrer colección y mostrar enemigos

    }
}