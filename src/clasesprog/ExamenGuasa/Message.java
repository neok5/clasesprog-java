package clasesprog.ExamenGuasa;

// hacemos que los mensajes implementen Comparable para poder ordenarlos luego
public class Message implements Comparable<Message> {
    
    enum Type { REGULAR, CONTROL }
    
    private int idMessage;
    private String fromPhone;
    private String toPhone;
    private boolean isRead;
    private String text;
    private Type type;
    
    public Message(int idMessage, String fromPhone, String toPhone,
                            boolean isRead, String text, Type type) {
        this.idMessage = idMessage;
        this.fromPhone = fromPhone;
        this.toPhone = toPhone;
        this.isRead = isRead;
        this.text = "'" + text + "'";
        this.type =type;
    }
    
    // ordenamos por el ID de cada mensaje (cronológicamente)
    @Override
    public int compareTo(Message m) {
        return this.idMessage - m.getIdMessage();
    }
    
    @Override
    public String toString() {
        String leido = (this.isRead) ? "SI" : "NO";
        return "Mensaje #" + this.idMessage + "\n • N° teléfono origen: " + this.fromPhone
                + "\n • N° teléfono destino: " + this.toPhone + "\n • ¿Leído? " + leido
                + "\n • Texto: " + this.text + "\n • Tipo de mensaje: " + this.type.toString() + "\n";
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getFromPhone() {
        return fromPhone;
    }

    public void setFromPhone(String fromPhone) {
        this.fromPhone = fromPhone;
    }

    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}