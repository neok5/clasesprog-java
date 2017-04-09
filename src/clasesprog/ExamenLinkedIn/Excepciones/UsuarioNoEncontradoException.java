package clasesprog.ExamenLinkedIn.Excepciones;

public class UsuarioNoEncontradoException extends Exception {
    private final String idUsuario;
    
    public UsuarioNoEncontradoException(String id) {
        super(" - ID USUARIO: " + id);
        this.idUsuario = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }
}