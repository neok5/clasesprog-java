package clasesprog.ExamenLinkedIn;

import clasesprog.ExamenLinkedIn.Excepciones.*;
import java.util.*;

/**
 * Clase que representa la red profesional LinkedIn
 */
public class LinkedIn {
    // la clave es el email del Usuario, y el valor el propio Usuario
    private final Map<String, Usuario> usuariosRegistrados;
    
    public LinkedIn() {
        usuariosRegistrados = new HashMap();
    }
    
    public void addUsuario(Usuario user) throws UsuarioRepetidoException {
        if(this.usuariosRegistrados.containsKey(user.getEmail()))
            throw new UsuarioRepetidoException();
        
        this.usuariosRegistrados.put(user.getEmail(), user);
    }
    
    public Usuario buscarUsuario(String id) throws UsuarioNoEncontradoException {
        if(!this.usuariosRegistrados.containsKey(id))
            throw new UsuarioNoEncontradoException(id);
        
        return this.usuariosRegistrados.get(id);
    }
    
    public void solicitarContacto(String idSolicitante, String idSolicitado)
            throws UsuarioNoEncontradoException, ContactoYaExistenteException {
        
        if(!this.usuariosRegistrados.containsKey(idSolicitante))
            throw new UsuarioNoEncontradoException(idSolicitante);
        if(!this.usuariosRegistrados.containsKey(idSolicitado))
            throw new UsuarioNoEncontradoException(idSolicitado);
        
        if(this.usuariosRegistrados.get(idSolicitante).getContactos().
                contains(this.usuariosRegistrados.get(idSolicitado)))
            throw new ContactoYaExistenteException();
        
        this.usuariosRegistrados.get(idSolicitado).
                getSolicitudes().add(this.usuariosRegistrados.get(idSolicitante));
    }
    
    public void aceptarContacto(String idAceptante, String idAceptado)
        throws UsuarioNoEncontradoException, PeticionDeContactoNoExistenteException {
        
        if(!this.usuariosRegistrados.containsKey(idAceptante))
            throw new UsuarioNoEncontradoException(idAceptante);
        if(!this.usuariosRegistrados.containsKey(idAceptado))
            throw new UsuarioNoEncontradoException(idAceptado);
        
        if(!this.usuariosRegistrados.get(idAceptante).getSolicitudes().
                contains(this.usuariosRegistrados.get(idAceptado)))
            throw new PeticionDeContactoNoExistenteException();
        
        this.usuariosRegistrados.get(idAceptante).
                getContactos().add(this.usuariosRegistrados.get(idAceptado));
        this.usuariosRegistrados.get(idAceptado).
                getContactos().add(this.usuariosRegistrados.get(idAceptante));
        this.usuariosRegistrados.get(idAceptante).
                getSolicitudes().remove(this.usuariosRegistrados.get(idAceptado));
    }
    
    public void addOfertaEmpleo(String idEmpresa, Oferta oferta)
        throws UsuarioNoEncontradoException, UsuarioNoEsEmpresaException {
        
        if(!this.usuariosRegistrados.containsKey(idEmpresa))
            throw new UsuarioNoEncontradoException(idEmpresa);
        
        if(!(this.usuariosRegistrados.get(idEmpresa) instanceof Empresa))
            throw new UsuarioNoEsEmpresaException();
        
        ((Empresa) this.usuariosRegistrados.get(idEmpresa)).getOfertas().add(oferta);
    }
    
    public void mostrarOfertas(String idUsuario)
        throws UsuarioNoEncontradoException {
        
        if(!this.usuariosRegistrados.containsKey(idUsuario))
            throw new UsuarioNoEncontradoException(idUsuario);
        
        List<Oferta> ofertasParaUsuario = new ArrayList();
        for(Usuario user : this.usuariosRegistrados.get(idUsuario).getContactos())
            if(user instanceof Empresa)
                ofertasParaUsuario.addAll(((Empresa) user).getOfertas());
        
        for(int i = 0; i < ofertasParaUsuario.size(); i++)
            System.out.println("Oferta #" + (i+1)
                + "\n" + ofertasParaUsuario.get(i) + "\n");
    }
    
    public void listarUsuarios() {
        List<Usuario> usuariosOrdenados =
                new ArrayList(this.usuariosRegistrados.values());
        usuariosOrdenados.sort(new ComparadorUsuarios());
        
        for(int i = 0; i < usuariosOrdenados.size(); i++)
            System.out.println("Usuario #" + (i+1)
                + "\n" + usuariosOrdenados.get(i) + "\n");
    }
}