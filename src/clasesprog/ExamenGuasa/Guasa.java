package clasesprog.ExamenGuasa;

import java.util.*;
import java.util.function.Predicate;

/**
 * Clase que representa el sistema de mensajería instantánea Guasa
 */
public class Guasa {
    
    // el enunciado dice que todo Usuario debe poder ser referenciado tanto
    // por el email, como por alguno de sus teléfonos asociados. Por tanto,
    // debemos mantener dos colecciones Map con el fin de registrar tanto
    // entradas de tipo (email, Usuario) como de tipo (telefono, email)
    
    // la clave es el email y el valor el Usuario
    private Map<String, Usuario> usuariosReg;
    // la clave es el teléfono y el valor el email
    private Map<String, String> telefonosReg;
    // contador para los mensajes que se envían y reciben en el sistema
    private int mCounter;
    
    public Guasa() {
        this.usuariosReg = new HashMap();
        this.telefonosReg = new HashMap();
        this.mCounter = 1;
    }
    
    public int registerUser(String phone, String email) {
        int resultado;
        
        if(this.telefonosReg.containsKey(phone))
            resultado = -1; // ERROR - El teléfono ya estaba registrado
        else if(this.usuariosReg.containsKey(email)) {
            // añadimos el teléfono a los teléfonos asociados al Usuario
            this.usuariosReg.get(email).getTelefonosAsociados().add(phone);
            // añadimos el teléfono a la lista de teléfonos registrados
            this.telefonosReg.put(phone, email);
            // todo correcto
            resultado = 0;
        }
        else {
            // transformamos el teléfono en una lista de teléfonos
            List<String> aux = new ArrayList(); aux.add(phone);
            // añadimos un nuevo usuario al registro
            this.usuariosReg.put(email, new Usuario(email, aux));
            // añadimos un nuevo teléfono al registro
            this.telefonosReg.put(phone, email);
            // todo correcto
            resultado = 0;
        }
        
        return resultado;
    }
    
    public int sendMessageByPhone(String fromPhone, String toPhone, String text) {
        int resultado;
        
        if(!this.usuariosReg.containsKey(this.telefonosReg.get(fromPhone)))
            resultado = -1; // ERROR - El usuario identificado por fromPhone no existe
        else if(!this.usuariosReg.containsKey(this.telefonosReg.get(toPhone)))
            resultado = -2; // ERROR - El usuario identificado por toPhone no existe
        else {
            // todo correcto
            resultado = this.mCounter++;
            
            Message m = new Message(resultado, fromPhone, toPhone,
                                    false, text, Message.Type.REGULAR);
            
            // obtenemos el email, y a partir de él, el Usuario,
            // para actualizar los buzones de emisor y destinatario
            this.usuariosReg.get(
                    this.telefonosReg.get(fromPhone)).getmEnviados().add(m);
            this.usuariosReg.get(
                    this.telefonosReg.get(toPhone)).getmRecibidos().add(m);
        }
        
        return resultado;
    }
    
    public int sendMessageByEmail(String fromPhone, String toEmail, String text) {
        int resultado;
        
        if(!this.usuariosReg.containsKey(this.telefonosReg.get(fromPhone)))
            resultado = -1; // ERROR - El usuario identificado por fromPhone no existe
        else if(!this.usuariosReg.containsKey(toEmail))
            resultado = -2; // ERROR - El usuario identificado por toEmail no existe
        else {
            // todo correcto
            resultado = 0;
            
            Message m;
            
            for(String tel : this.usuariosReg.get(toEmail).getTelefonosAsociados()) {
                m = new Message(
                    this.mCounter++, fromPhone, tel, false, text, Message.Type.REGULAR);
                
                this.usuariosReg.get(
                    this.telefonosReg.get(fromPhone)).getmEnviados().add(m);
                this.usuariosReg.get(toEmail).getmRecibidos().add(m);
            }
        }
        
        return resultado;
    }
    
    public Collection<Message> receiveMessages(String userPhone, String friendPhone) {
        Collection<Message> mensajes = null;
        String userEmail = this.telefonosReg.get(userPhone),
                friendEmail = this.telefonosReg.get(friendPhone);
        
        if(this.usuariosReg.containsKey(userEmail)
        && this.usuariosReg.containsKey(friendEmail)) {
            // lista que almacena todos los mensajes enviados y recibidos
            // entre el emisor (userPhone) y el receptor (friendPhone)
            mensajes = new ArrayList();
            
            // almacenamos todos los mensajes enviado por userPhone y por friendPhone
            mensajes.addAll(this.usuariosReg.get(userEmail).getmEnviados());
            mensajes.addAll(this.usuariosReg.get(friendEmail).getmEnviados());
            
            // eliminamos aquellos que no sean los mensajes de nuestro interés
            mensajes.removeIf(new Predicate() {
                @Override
                public boolean test(Object t) {
                    return !((((Message) t).getFromPhone().equals(userPhone)
                           || ((Message) t).getFromPhone().equals(friendPhone))
                          && (((Message) t).getToPhone().equals(userPhone)
                           || ((Message) t).getToPhone().equals(friendPhone))); } });
                    
            // ordenamos según su ID (Message es Comparable)
            Collections.sort((List<Message>) mensajes);
            // por cada mensaje
            for(Message m : mensajes) {
                if (!m.isIsRead()) {
                    // se marca como leído solo si es un mensaje (friendPhone -> userPhone)
                    if (m.getFromPhone().equals(friendPhone)) {
                        m.setIsRead(true);
                    }
                    // si es REGULAR, se manda mensaje de control
                    if (m.getType().equals(Message.Type.REGULAR)) {
                        sendControlMessage(userPhone, friendPhone, m.getIdMessage());
                    }
                }
            }
        }
        
        return mensajes;
    }
    
    private void sendControlMessage(String fromPhone, String toPhone, int idMessage) {
        // enviamos un mensaje de CONTROL con el texto adecuado, y el idMessage recibido
        Message m = new Message(this.mCounter++, fromPhone, toPhone,
            false, "El mensaje [" + idMessage + "] ha sido leído", Message.Type.CONTROL);

        // obtenemos el email, y a partir de él, el Usuario,
        // para actualizar los buzones de emisor y destinatario
        this.usuariosReg.get(
                this.telefonosReg.get(fromPhone)).getmEnviados().add(m);
        this.usuariosReg.get(
                this.telefonosReg.get(toPhone)).getmRecibidos().add(m);
    }
}