package clasesprog.ExamenCalando;

/**
 * Clase que representa los artículos de tipo Ordenador
 */
public class Ordenador extends Articulo {
    
    // diferentes tipos de procesadores que pueden llevar los ordenadores
    enum Procesador { INTEL_i3, INTEL_i5, INTEL_i7 }
    
    // cantidad de memoria RAM del ordenador (en GB)
    private int ram;
    // tipo de procesador que lleva el equipo
    private Procesador procesador;
    
    /**
     * Constructor para crear un Articulo (Ordenador) con todas sus propiedades
     *
     * @param referencia
     * @param categoria
     * @param marca
     * @param precio
     * @param stock
     * @param ram
     * @param procesador
     */
    public Ordenador(String referencia, Tipo tipo, String marca,
                    double precio, int stock, int ram, Procesador procesador) {
        super(referencia, tipo, marca, precio, stock);
        this.ram = ram;
        this.procesador = procesador;
    }
    
    @Override
    public String toString() {
        return "*** Artículo de la categoría [Ordenador] ***" + super.toString()
                + "\nRam:         " + this.ram + "\nProcesador:  " + this.procesador;
    }

    // getters y setters específicos para los campos de Ordenador
    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }
}