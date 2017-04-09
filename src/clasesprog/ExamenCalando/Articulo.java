package clasesprog.ExamenCalando;

/**
 * Clase que describe todos los artículos de forma genérica
 */
public class Articulo {
    
    // el enumerado se hace interno a la clase Articulo, para que al usarlo
    // desde el exterior, se tenga que referenciar siempre a la clase Articulo
    enum Tipo {CAMISA, PANTALON, CHAQUETA, DESKTOP,
                LAPTOP, MICROONDAS, SECADOR, LAVADORA }
    
    // referencia del artículo [IDENTIFICADOR ÚNICO]
    private String referencia;
    // clase de artículo representada mediante un enumerado
    private Tipo tipo;
    // representa la marca comercial del artículo
    private String marca;
    // precio del artículo
    private double precio;
    // n° de unidades en el almacén
    private int stock;
    
    /**
     * Constructor para crear un Articulo genérico con todas sus propiedades
     *
     * @param referencia referencia del articulo (identificador único)
     * @param tipo tipo de articulo
     * @param marca marca comercial del articulo
     * @param precio precio del artículo exacto
     * @param stock unidades disponibles del artículo en el almacén
     */
    public Articulo(String referencia, Tipo tipo,
                                String marca, double precio, int stock) {
        this.referencia = referencia;
        this.tipo = tipo;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "\nTipo:        " + this.tipo +
            "\nMarca:       " + this.marca + "\nPrecio:      " + this.precio
                + "\nReferencia:  " + this.referencia + "\nStock:       " + this.stock;
    }

    // conjunto de getters y setters para los campos del Articulo
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}