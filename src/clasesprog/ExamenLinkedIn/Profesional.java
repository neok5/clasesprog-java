package clasesprog.ExamenLinkedIn;

public class Profesional extends PersonaFisica {
    private String empresa;
    private int anioEntrada;

    public Profesional(String email, String nombre, String empresa, int anioEntrada) {
        super(email, nombre);
        this.empresa = empresa;
        this.anioEntrada = anioEntrada;
    }
    
    @Override
    public String toString() {
        return "  * Usuario de la categoría [Profesional]"
            + super.toString() + "    Empresa: "  + this.empresa
                                + "\n    Año de entrada: " + this.anioEntrada;
    }
}