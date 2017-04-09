package clasesprog.ExamenLinkedIn;

import clasesprog.ExamenLinkedIn.Excepciones.ContactoYaExistenteException;
import clasesprog.ExamenLinkedIn.Excepciones.PeticionDeContactoNoExistenteException;
import clasesprog.ExamenLinkedIn.Excepciones.UsuarioNoEncontradoException;
import clasesprog.ExamenLinkedIn.Excepciones.UsuarioNoEsEmpresaException;
import clasesprog.ExamenLinkedIn.Excepciones.UsuarioRepetidoException;

/**
 * Solución examen LinkedIn 2014
 */
public class ExamenLinkedIn {

    /**
     * Método principal llamado desde el main,
     * para ejecutar pruebas sobre la red profesional LinkedIn
     */
    public static void runLinkedIn() {
        
        LinkedIn redLinkedIn = new LinkedIn();
        
        try {
            runLI1(redLinkedIn);
            System.out.println("********************************\n");
            runLI2(redLinkedIn);
            System.out.println("********************************\n");
            runLI3(redLinkedIn);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println(
                    "*** FIN DE LA DEMO DE EJECUCIÓN 'LinkedIn' ***\n\n\n\n\n\n\n\n\n\n");
        }
    }

    // ejemplos de uso para las funcionalidades requeridas para el Aprobado
    // es decir: addUsuario, buscarUsuario, solicitarContacto y aceptarContacto
    private static void runLI1(LinkedIn r)
            throws UsuarioRepetidoException, UsuarioNoEncontradoException,
            ContactoYaExistenteException, PeticionDeContactoNoExistenteException {
        
        r.addUsuario(
            new Empresa("contacto@everis.es", "Everis"));
        r.addUsuario(
            new Profesional("josegarcia@gmail.com", "Jose García", "Everis", 1997));
        r.addUsuario(
            new Profesional("alfonsorodriguez@hotmail.com", "Alfonso Rodriguez", "Indra", 2003));
        r.addUsuario(
            new Estudiante("luisillo@yahoo.es", "Luis de Guindos", "Grado II", 2));
        r.addUsuario(
            new Empresa("contacto@telefonica.es", "Telefónica"));
        r.addUsuario(
            new Estudiante("mnaniano@gmail.com", "Mariano Naniano", "Grado Derecho", 4));
        r.addUsuario(
            new Empresa("contacto@AAPP.es", "Gobierno de España"));
        
        
        Usuario user;
        try {
            user = r.buscarUsuario("zzz@blabla.com");
        }
        catch(UsuarioNoEncontradoException unee) {
            user = null;
        }
        String respuesta = (user == null) ?
                "No, no existe." : "Si, si existe, y es el siguiente:\n\n" + user;
        System.out.println("¿Existe el usuario con email 'zzz@blabla.com'?\n"
                + respuesta);
        
        user = r.buscarUsuario("contacto@everis.es");
        respuesta = (user == null) ?
                "No, no existe." : "Si, si existe, y es el siguiente:\n\n" + user;
        System.out.println("\n¿Existe el usuario con email 'contacto@everis.com'?\n"
                + respuesta);
        
        r.solicitarContacto("mnaniano@gmail.com", "contacto@everis.es");
        r.aceptarContacto("contacto@everis.es", "mnaniano@gmail.com");
        
        user = r.buscarUsuario("contacto@everis.es");
        respuesta = (user == null) ?
                "No, no existe." : "Si, si existe, y es el siguiente:\n\n" + user;
        System.out.println("\n¿Existe el usuario con email 'contacto@everis.com'?\n"
                + respuesta);
        
        user = r.buscarUsuario("mnaniano@gmail.com");
        respuesta = (user == null) ?
                "No, no existe." : "Si, si existe, y es el siguiente:\n\n" + user;
        System.out.println("\n¿Existe el usuario con email 'mnaniano@gmail.com'?\n"
                + respuesta + "\n");
    }

    // ejemplos de uso para las funcionalidades requeridas para el Notable
    // es decir: addOfertaEmpleo, mostrarOfertasEmpleo y listarUsuarios
    private static void runLI2(LinkedIn r)
            throws UsuarioNoEncontradoException, UsuarioNoEsEmpresaException {
        
        r.listarUsuarios();
        
        r.addOfertaEmpleo("contacto@everis.es", new Oferta("Becario", 0));
        r.addOfertaEmpleo("contacto@telefonica.es", new Oferta("Analista Jefe", 3));
        r.addOfertaEmpleo("contacto@everis.es", new Oferta("Jefe de Proyecto", 5));
        
        System.out.println("Ofertas de empleo para "
                + r.buscarUsuario("mnaniano@gmail.com").getNombre()
                + "\n                      (" + r.buscarUsuario(
                            "mnaniano@gmail.com").getEmail() + ")");
        r.mostrarOfertas("mnaniano@gmail.com");
    }

    // ejemplos de uso para las funcionalidades requeridas para el Sobresaliente
    // es decir, que todas las funcionalidades propaguen las excepciones descritas
    private static void runLI3(LinkedIn r) {
        try {
            r.addUsuario(new Empresa("contacto@telefonica.es", "Telefónica"));
        }
        catch(UsuarioRepetidoException ure) {
            System.out.println("ERROR - Ese usuario ya existe.");
        }
        finally {
            System.out.println();
        }
        
        
        try {
            r.buscarUsuario("pruebaDeError");
        }
        catch(UsuarioNoEncontradoException unee) {
            System.out.println("ERROR - Este usuario no existe" + unee.getMessage());
        }
        finally {
            System.out.println();
        }
        
        
        try {
            r.solicitarContacto("contacto@everis.es", "mnaniano@gmail.com");
        }
        catch(ContactoYaExistenteException cyee) {
            System.out.println("ERROR - Esos usuarios ya están en contacto.");
        }
        catch(Exception e) {
            // para no repetir la de UsuarioNoEncontradoException
        }
        finally {
            System.out.println();
        }
        
        
        try {
            r.aceptarContacto("contacto@telefonica.es", "alfonsorodriguez@hotmail.com");
        }
        catch(PeticionDeContactoNoExistenteException pdcnee) {
            System.out.println("ERROR - No existe una solicitud para ese usuario.");
        }
        catch(Exception e) {
            
        }
        finally {
            System.out.println();
        }
        
        
        try {
            r.addOfertaEmpleo("luisillo@yahoo.es", new Oferta("Ey", 99));
        }
        catch(UsuarioNoEsEmpresaException uneee) {
            System.out.println("ERROR - El usuario no es una Empresa.");
        }
        catch(Exception e) {
            
        }
        finally {
            System.out.println();
        }
    }
}