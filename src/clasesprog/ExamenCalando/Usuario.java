package clasesprog.ExamenCalando;

/**
 * Clase que representa a los usuarios de la tienda Calando
 */
public class Usuario {
    
    // email del cliente usuario [IDENTIFICADOR ÚNICO]
    private String email;
    // contraseña del cliente usuario
    private String password ;
    // dirección física para los envíos del cliente usuario
    private String direccion;
    
    /**
     * Constructor para el Usuario, inicializando sus propiedades
     *
     * @param email
     * @param password
     * @param direccion
     */
    public Usuario(String email, String password, String direccion) {
        this.email = email;
        this.password = password;
        this.direccion = direccion;
    }

    // getters y setters de los campos de Usuario
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}