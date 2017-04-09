package clasesprog.ExamenGuasa;

import java.util.*;

public class Usuario {
    private String email;
    // se utiliza una lista para almacenar
    // los teléfonos asociados a cada Usuario
    private final List<String> telefonosAsociados;
    // lista de mensajes enviados por el Usuario
    private final List<Message> mEnviados;
    // lista de mensajes recibidos por el Usuario
    private final List<Message> mRecibidos;
    
    public Usuario(String email, List<String> telefonosAsociados) {
        this.email = email;
        this.telefonosAsociados = telefonosAsociados;
        this.mEnviados = new ArrayList();
        this.mRecibidos = new ArrayList();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTelefonosAsociados() {
        return telefonosAsociados;
    }

    public List<Message> getmEnviados() {
        return mEnviados;
    }

    public List<Message> getmRecibidos() {
        return mRecibidos;
    }
}