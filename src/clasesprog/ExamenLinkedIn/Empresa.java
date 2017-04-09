package clasesprog.ExamenLinkedIn;

import java.util.ArrayList;
import java.util.List;

public class Empresa extends Usuario {
    private final List<Oferta> ofertas;

    public Empresa(String email, String nombre) {
        super(email, nombre);
        this.ofertas = new ArrayList();
    }
    
    @Override
    public String toString() {
        return "  * Usuario de la categoría [Empresa]" + super.toString();
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }
}