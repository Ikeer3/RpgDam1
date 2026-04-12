public class TestPersonajeHabilidades {

    public static void main(String[] args) {
        System.out.println("=== TEST HABILIDADES ===");

        Personaje p = new Personaje("Naruto", 100, 20, 10);

        p.anhadirHabilidad("Rasengan");
        p.anhadirHabilidad("Clones");
        p.anhadirHabilidad("Rasengan");

        boolean test1 = p.tieneHabilidad("Rasengan");
        boolean test2 = p.tieneHabilidad("Clones");
        boolean test3 = !p.tieneHabilidad("Chidori");

        if (test1 && test2 && test3) {
            System.out.println("Test de habilidades: OK");
        } else {
            System.out.println("Test de habilidades: FAIL");
        }

        System.out.println("Habilidades registradas:");
        p.mostrarHabilidades();
    }
}