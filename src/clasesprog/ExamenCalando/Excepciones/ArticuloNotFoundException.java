package clasesprog.ExamenCalando.Excepciones;

public class ArticuloNotFoundException extends Exception {
    // almacena la referencia del artículo inexistente en el almacén,
    // para proporcionar esa información en caso de ser necesario
    private final String referencia;
    
    public ArticuloNotFoundException(String referencia) {
        super(" - REFERENCIA: " + referencia);
        this.referencia = referencia;
    }

    public String getReferencia() {
        return referencia;
    }
}