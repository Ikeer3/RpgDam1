public class TestPersonajeDescanso {

    public static void main(String[] args) {
        System.out.println("=== TEST DESCANSO ===");

        Personaje p = new Personaje("Goku", 100, 30, 15);

        System.out.println("Estado inicial:");
        p.mostrarEstado();

        p.descansar();

        System.out.println("Estado tras descansar:");
        p.mostrarEstado();

        System.out.println("Comprobación visual: la vida no debe superar la vida máxima.");
    }
}