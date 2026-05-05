public class NoSePuedeCurarException extends RuntimeException {
    private int combateUltimaCuracion;
    private int combatesTotales;

    public NoSePuedeCurarException(int combateUltimaCuracion, int combatesTotales) {
        this.combateUltimaCuracion = combateUltimaCuracion;
        this.combatesTotales = combatesTotales;
    }

    public int getCombateUltimaCuracion() {
        return combateUltimaCuracion;
    }

    public int getCombatesTotales() {
        return combatesTotales;
    }
}
