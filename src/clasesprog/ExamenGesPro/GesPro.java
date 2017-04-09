package clasesprog.ExamenGesPro;

import java.util.*;
import clasesprog.ExamenGesPro.Excepciones.*;

/**
 * Clase que representa la aplicación de gestión de proyectos software
 */
public class GesPro {
    
    // la clave es la referencia y el valor el Proyecto
    private final Map<String,Proyecto> proyectos;
    // la clave es el dni y el valor el Programador
    private final Map<String,Programador> personal;
    
    public GesPro() {
        this.proyectos = new HashMap();
        this.personal = new HashMap();
    }
    
    public void addProgramador(String dni, String nombre, int antiguedad)
                                        throws ProgramadorRepetidoException {
        
        if(this.personal.containsKey(dni))
            throw new ProgramadorRepetidoException();
        
        this.personal.put(dni, new Programador(dni, nombre, antiguedad));
    }

    public void addProyecto(String referencia, String nombre, String cliente, String dniLider)
                            throws ProyectoRepetidoException, ProgramadorDesconocidoException {
        
        if(this.proyectos.containsKey(referencia))
            throw new ProyectoRepetidoException();
        
        if(!this.personal.containsKey(dniLider))
            throw new ProgramadorDesconocidoException();
        
        this.proyectos.put(
                referencia,
                new Proyecto(referencia, nombre, cliente, this.personal.get(dniLider)));
    }
    
    public void addTarea(String referencia, Tarea tarea)
        throws ProyectoDesconocidoException, TareaRepetidaException {
        
        if(!this.proyectos.containsKey(referencia))
            throw new ProyectoDesconocidoException();
        //           AutoBoxing (espera Integer y se le pasa int) ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        if(this.proyectos.get(referencia).getTareas().containsKey(tarea.getCodigo()))
            throw new TareaRepetidaException();
        
        if(tarea instanceof Analisis)
            tarea = newAnalisisInstance(tarea, ((Analisis) tarea).getMetodologia());
        
        else if(tarea instanceof Disenno)
            tarea = newDisennoInstance(tarea, ((Disenno) tarea).getPatrones());
        
        else if(tarea instanceof Implementacion)
            tarea = newiImplementacionInstance(tarea, ((Implementacion) tarea).getLenguaje());
        
        this.proyectos.get(referencia).getTareas().put(tarea.getCodigo(), tarea);
    }
    
    @SuppressWarnings("NonPublicExported")
    // para evitar el aviso de 'Exporting non-public type through public API'
    private Analisis newAnalisisInstance(Tarea tarea, Analisis.Metodologia metodologia) {
        
        return new Analisis(tarea.getCodigo(),
            tarea.getDescripcion(), tarea.getMiembros(), tarea.getDuracion(), metodologia);
    }
    
    @SuppressWarnings("NonPublicExported")
    // para evitar el aviso de 'Exporting non-public type through public API'
    private Disenno newDisennoInstance(Tarea tarea, Set<Disenno.Patron> patrones) {
        
        return new Disenno(tarea.getCodigo(),
            tarea.getDescripcion(), tarea.getMiembros(), tarea.getDuracion(), patrones);
    }
    
    @SuppressWarnings("NonPublicExported")
    // para evitar el aviso de 'Exporting non-public type through public API'
    private Implementacion newiImplementacionInstance(Tarea tarea,
                                                     Implementacion.Lenguaje lenguaje) {
        
        return new Implementacion(tarea.getCodigo(),
            tarea.getDescripcion(), tarea.getMiembros(), tarea.getDuracion(), lenguaje);
    }
    
    public int getDuracionProyecto(String referencia) throws ProyectoDesconocidoException {
        
        if(!this.proyectos.containsKey(referencia))
            throw new ProyectoDesconocidoException();
        
        int duracion = 0;
        
        for(Tarea t : this.proyectos.get(referencia).getTareas().values())
            duracion += t.getDuracion();
        
        return duracion;
    }
    
    public Set<Programador> getProgramadoresProyecto(String referencia)
                                    throws ProyectoDesconocidoException {
        if(!this.proyectos.containsKey(referencia))
            throw new ProyectoDesconocidoException();
        
        // vamos a devolver un conjunto ordenado según el nombre de los Programadore(s)
        // de ahí que el Set que devolvamos sea directamente un TreeSet (orden natural)
        Set<Programador> progPro = new TreeSet();
        // agregamos al líder del proyecto
        progPro.add(this.proyectos.get(referencia).getLider());
        // y a cada uno de los Programadore(s) de las diferentes Tarea(s) del proyecto
        for(Tarea t : this.proyectos.get(referencia).getTareas().values())
            progPro.addAll(t.getMiembros());
        
        return progPro;
    }
    
    public void showProyectos() {
        List<Proyecto> projects = new ArrayList();
        projects.addAll(this.proyectos.values());
        Collections.sort(projects);
        
        int indice = 1;
        for(Proyecto p : projects)
            System.out.println("Proyecto #" + (indice++) + "\n" + p + "\n");
    }

    public Map<String, Proyecto> getProyectos() {
        return proyectos;
    }

    public Map<String, Programador> getPersonal() {
        return personal;
    }
}