package clasesprog.ExamenLinkedIn;

public class Estudiante extends PersonaFisica {
    private String titulacion;
    private int curso;

    public Estudiante(String email, String nombre, String titulacion, int curso) {
        super(email, nombre);
        this.titulacion = titulacion;
        this.curso = curso;
    }
    
    @Override
    public String toString() {
        return "  * Usuario de la categoría [Estudiante]"
            + super.toString() + "    Titulación: "  + this.titulacion
                                    + "\n    Curso actual: " + this.curso;
    }
}