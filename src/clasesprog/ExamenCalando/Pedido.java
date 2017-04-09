package clasesprog.ExamenCalando;

/**
 * Clase que describe la intención del Usuario de comprar un Articulo determinado
 */
public class Pedido {
    // referencia del artículo que corresponde al Pedido
    private String referencia;
    // n° de unidades del artículo que se incluyen en el Pedido
    private int cantidad;
    
    /**
     * Constructor de Pedido con los dos campos que tiene como parámetros
     *
     * @param referencia del artículo del Pedido
     * @param cantidad total de artículos del mismo tipo que incluye el Pedido
     */
    public Pedido(String referencia, int cantidad) {
        this.referencia = referencia;
        this.cantidad = cantidad;
    }

    // getters y setters de los campos del Pedido
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}