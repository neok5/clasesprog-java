package clasesprog.ExamenLinkedIn;

import java.util.*;

public abstract class Usuario {
    // el email es un IDENTIFICADOR ÚNICO
    private String email;
    private String nombre;
    private final Set<Usuario> contactos;
    private final Set<Usuario> solicitudes;
    
    public Usuario(String email, String nombre) {
        this.email = email;
        this.nombre = nombre;
        this.contactos = new HashSet();
        this.solicitudes = new HashSet();
    }
    
    @Override
    public String toString() {
        String retorno = "\n    Email: " + this.email
                        + "\n    Nombre: " + this.nombre
                        + "\n    Contactos:\n";
        for(Usuario u : this.contactos)
            retorno += "      • " + u.getEmail() + " - " + u.getNombre() + "\n";
        return retorno;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Usuario> getContactos() {
        return contactos;
    }

    public Set<Usuario> getSolicitudes() {
        return solicitudes;
    }
}