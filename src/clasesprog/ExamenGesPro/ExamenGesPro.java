package clasesprog.ExamenGesPro;

import clasesprog.ExamenGesPro.Excepciones.*;
import java.util.*;

/**
 * Solución examen Gestión de Proyectos Software 2015
 */
public class ExamenGesPro {
    /**
     * Método principal llamado desde el main, para ejecutar
     * pruebas sobre la aplicación de gestión de proyectos software
     */
    public static void runGesPro() {
        
        GesPro appGesPro = new GesPro();
        
        try {
            runGes1(appGesPro);
            System.out.println("********************************");
            runGes2(appGesPro);
            System.out.println("********************************\n");
            runGes3(appGesPro);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println(
                    "*** FIN DE LA DEMO DE EJECUCIÓN 'GesPro' ***\n\n\n\n\n\n\n\n\n\n");
        }
    }

    // ejemplos de uso para las funcionalidades requeridas para el Aprobado
    // addProgramador()
    // addProyecto()
    // addTarea() [newAnalisisInstance(), newDisenoInstance(), newImplementacionInstance()]
    // getDuracionProyecto()
    private static void runGes1(GesPro a)
        throws ProgramadorRepetidoException, ProyectoRepetidoException,
        ProgramadorDesconocidoException, ProyectoDesconocidoException, TareaRepetidaException {
        
        // añadimos unos cuantos Programadore(s)
        a.addProgramador("70XXXXXX", "Pepe", 3);
        a.addProgramador("74XXXXXX", "Lucia", 2);
        a.addProgramador("71XXXXXX", "Maggie", 5);
        a.addProgramador("72XXXXXX", "Juan", 1);
        a.addProgramador("73XXXXXX", "Roberto", 2);
        
        // añadimos un Proyecto a la aplicación de gestión
        a.addProyecto("001", "APP Gestión Bancaria", "BBVA", "71XXXXXX");
        
        // creamos grupos para las diferentes Tarea(s): Análisis, Diseño e Implementación
        // además, creamos también otro conjunto extra para los Patrone(s) de Disenno
        Set<Programador> analistas = new HashSet(),
                         disennadores = new HashSet(),
                         codificadores = new HashSet();
        Set<Disenno.Patron> patrones = new HashSet();
        
        // añadimos miembros a esos grupos (conjuntos)
        analistas.add(a.getPersonal().get("71XXXXXX"));
        disennadores.add(a.getPersonal().get("70XXXXXX"));
        disennadores.add(a.getPersonal().get("74XXXXXX"));
        codificadores.add(a.getPersonal().get("72XXXXXX"));
        codificadores.add(a.getPersonal().get("73XXXXXX"));
        
        patrones.add(Disenno.Patron.SINGLETON);
        patrones.add(Disenno.Patron.FACTORY);
        patrones.add(Disenno.Patron.OBSERVER);
        
        // añadimos unas cuantas Tarea(s) al Proyecto
        a.addTarea("001", new Analisis(1, "Análisis de requisitos",
                                           analistas, 5, Analisis.Metodologia.SCRUM));
        a.addTarea("001", new Disenno(2, "Diseño estructural",
                                          disennadores, 15, patrones));
        a.addTarea("001", new Implementacion(3, "Implementación y pruebas",
                                          codificadores, 10, Implementacion.Lenguaje.JAVA));
        
        // obtenemos y mostramos la duración del Proyecto
        System.out.println("\nLa duración aproximada del proyecto es de "
                                        + a.getDuracionProyecto("001") + " días.\n");
    }

    // ejemplos de uso para las funcionalidades requeridas para el Notable
    // es decir: getProgramadoresProyecto()
    private static void runGes2(GesPro a) throws ProyectoDesconocidoException {
        System.out.println("\nProgramadores del proyecto ["
            + a.getProyectos().get("001").getNombre() + "]");
        // mostramos los programadores implicados en el Proyecto, ordenados por nombre
        int indice = 1;
        for(Programador p : a.getProgramadoresProyecto("001"))
            System.out.println("\nProgramador #" + (indice++) + p);
        
        System.out.println();
    }

    // ejemplos de uso para las funcionalidades requeridas para el Sobresaliente
    // es decir: showProyectos()
    private static void runGes3(GesPro a)
        throws ProyectoRepetidoException, ProgramadorDesconocidoException {
        // añadimos un proyecto nuevo, y mostramos todos los proyectos
        a.addProyecto("002", "APP Venta Billetes", "ALSA", "73XXXXXX");
        a.showProyectos();
    }
}