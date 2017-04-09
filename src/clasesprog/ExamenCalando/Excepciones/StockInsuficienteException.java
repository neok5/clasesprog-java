package clasesprog.ExamenCalando.Excepciones;

public class StockInsuficienteException extends Exception {
    // almacena la referencia del artículo sin stock suficiente,
    // para proporcionar esa información en caso de ser necesario
    private final String referencia;

    public StockInsuficienteException(String referencia) {
        super(" - REFERENCIA: " + referencia);
        this.referencia = referencia;
    }

    public String getReferencia() {
        return referencia;
    }
}