package clasesprog.ExamenCalando;

/**
 * Clase que representa los artículos de tipo Ropa
 */
public class Ropa extends Articulo {
    
    // diferentes tallas posibles para cada artículo de tipo Ropa
    enum Talla { XS, S, M, L, XL, XXL }
    // diferentes composiciones (materiales) posibles para cada artículo de tipo Ropa
    enum Composicion { LANA, ALGODON, ACRILICO }
    // diferentes temporadas posibles para cada artículo de tipo Ropa
    enum Temporada { FW, SS }

    // talla de la pieza de Ropa correspondiente
    Talla talla;
    // material principal con el que está hecha la pieza
    Composicion composicion;
    // temporada de moda correspondiente a la prenda
    Temporada temporada;

    /**
     * Constructor para crear un Articulo (Ropa) con todas sus propiedades
     *
     * @param referencia
     * @param categoria
     * @param marca
     * @param precio
     * @param stock
     * @param talla
     * @param composicion
     * @param temporada
     */
    public Ropa(String referencia, Tipo tipo, String marca, double precio,
        int stock, Talla talla, Composicion composicion, Temporada temporada) {
        super(referencia, tipo, marca, precio, stock);
        this.talla = talla;
        this.composicion = composicion;
        this.temporada = temporada;
    }
    
    @Override
    public String toString() {
        return "*** Artículo de la categoría [Ropa] ***"
            + super.toString() + "\nTalla:       "  + this.talla
                + "\nComposición: " + this.composicion + "\nTemporada:   " + this.temporada;
    }
    
    // getters y setters específicos para los campos de Ropa
    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Composicion getComposicion() {
        return composicion;
    }

    public void setComposicion(Composicion composicion) {
        this.composicion = composicion;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }
}