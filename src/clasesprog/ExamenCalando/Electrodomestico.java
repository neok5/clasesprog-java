package clasesprog.ExamenCalando;

/**
 * Clase que representa los artículos de tipo Electrodomestico
 */
public class Electrodomestico extends Articulo {
    
    // potencia del electrodoméstico (en W - Watios)
    private int potencia;

    /**
     * Constructor para crear un Articulo (Electrodoméstico) con todas sus propiedades
     *
     * @param referencia
     * @param categoria
     * @param marca
     * @param precio
     * @param stock
     * @param potencia
     */
    public Electrodomestico(String referencia, Tipo tipo,
                    String marca, double precio, int stock, int potencia) {
        super(referencia, tipo, marca, precio, stock);
        this.potencia = potencia;
    }
    
    @Override
    public String toString() {
        return "*** Artículo de la categoría [Electrodoméstico] ***"
                + super.toString() + "\nPotencia:    " + this.potencia;
    }

    // getters y setters específicos para el campo de Electrodomestico
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
}