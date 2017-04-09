package clasesprog.ExamenGuasa;

import java.util.Collection;

/**
 * Solución examen Guasa 2017
 */
public class ExamenGuasa {
    
    /**
     * Método principal llamado desde el main, para ejecutar
     * pruebas sobre el sitema de mensajería instantánea Guasa
     */
    public static void runGuasa() {
        
        Guasa sisMensGuasa = new Guasa();

        runGua1(sisMensGuasa);
        System.out.println("********************************\n");
        runGua2(sisMensGuasa);

        System.out.println("*** FIN DE LA DEMO DE EJECUCIÓN 'Guasa' ***\n\n\n\n\n\n\n\n\n\n");
    }

    // ejemplos de uso para las funcionalidades requeridas para el Aprobado y el Notable
    // es decir: registerUser, sendMessageByPhone, receiveMessages y sendControlMessage
    private static void runGua1(Guasa g) {
        // registramos unos cuántos usuarios
        g.registerUser("601", "user1");
        g.registerUser("602", "user2");
        g.registerUser("603", "user3");
        g.registerUser("604", "user4");
        g.registerUser("605", "user5");
        
        // enviamos algunos mensajes
        g.sendMessageByPhone("601", "602", "Hola usuario 2, soy el usuario 1.");
        g.sendMessageByPhone("604", "601", "Hola usuario 1, soy el usuario 4.");
        g.sendMessageByPhone("603", "605", "Hola usuario 5, soy el usuario 3.");
        g.sendMessageByPhone("604", "602", "Hola usuario 2, soy el usuario 4.");
        
        // probamos a recibir todos los mensajes intercambiados
        // entre los usuarios 2 y 4, y los listamos por pantalla
        System.out.println();
        for(Message m : g.receiveMessages("602", "604"))
            System.out.println(m);
        
        System.out.println("-----------------------");
        
        System.out.println();
        for(Message m : g.receiveMessages("602", "604"))
            System.out.println(m);
        
        System.out.println("-----------------------");
        
        System.out.println();
        for(Message m : g.receiveMessages("604", "602"))
            System.out.println(m);
    }

    // ejemplos de uso para las funcionalidades requeridas para el Sobresaliente
    // es decir: sendMessageByEmail
    private static void runGua2(Guasa g) {
        // añadimos algún teléfono más a alguno de los usuarios ya existentes
        g.registerUser("611", "user1");
        g.registerUser("621", "user1");
        g.registerUser("631", "user1");
        
        // enviamos mensajes usando el email como referencia
        g.sendMessageByEmail("605", "user1", "Soy un mensaje cuádruple enviado referenciando"
                            + "\n           un email, desde el usuario 5 al usuario 1.");
        
        // recibimos los mensajes entre el usuario 1 y el usuario 5
        for(Message m : g.receiveMessages("601", "605"))
            System.out.println(m);
        
        // recibimos los mensajes entre el usuario 1 y el usuario 5
        for(Message m : g.receiveMessages("601", "605"))
            System.out.println(m);
    }
}