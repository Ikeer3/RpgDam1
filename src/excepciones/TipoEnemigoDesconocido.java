package excepciones;

public class TipoEnemigoDesconocido extends Exception {
    private String tipoEnemigo;

    public TipoEnemigoDesconocido(String tipoEnemigo) {
        this.tipoEnemigo = tipoEnemigo;
    }
}
