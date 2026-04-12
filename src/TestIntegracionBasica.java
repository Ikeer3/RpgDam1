public class TestIntegracionBasica {

    public static void main(String[] args) {
        System.out.println("=== TEST INTEGRACIÓN BÁSICA ===");

        Personaje p = new Personaje("Tanjiro", 100, 22, 10);
        Enemigo e = new Enemigo("Demonio menor", 35, 9);

        p.anhadirHabilidad("Respiracion del agua");
        p.anhadirObjeto("Pocion", 1);

        boolean test1 = p.tieneHabilidad("Respiracion del agua");
        boolean test2 = p.tieneObjeto("Pocion");
        boolean test3 = e.getNombre().equals("Demonio menor");

        if (test1 && test2 && test3) {
            System.out.println("Test de integración básica: OK");
        } else {
            System.out.println("Test de integración básica: FAIL");
        }

        System.out.println("Estado del personaje:");
        p.mostrarEstado();

        System.out.println("Habilidades:");
        p.mostrarHabilidades();

        System.out.println("Inventario:");
        p.mostrarInventario();

        System.out.println("Enemigo:");
        e.mostrarInfo();
    }
}