public class TestEnemigo {

    public static void main(String[] args) {
        System.out.println("=== TEST ENEMIGO ===");

        Enemigo e = new Enemigo("Ninja renegado", 40, 12);

        if (e.getNombre().equals("Ninja renegado")) {
            System.out.println("Test getNombre(): OK");
        } else {
            System.out.println("Test getNombre(): FAIL");
        }

        System.out.println("Información del enemigo:");
        e.mostrarInfo();
    }
}