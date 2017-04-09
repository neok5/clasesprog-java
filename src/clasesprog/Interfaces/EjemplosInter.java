package clasesprog.Interfaces;

import clasesprog.Interfaces.Animales.*;
import clasesprog.Interfaces.Comparadores.*;
import clasesprog.Interfaces.Figuras.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjemplosInter {

    public static void runInterfaces() {
        runInter1();
        System.out.println("********************************\n");
        runInter2();
        System.out.println("********************************\n");
        runInter3();
        System.out.println("********************************\n");
        runInter4();
        System.out.println("********************************\n");
        runInter5();
        System.out.println("********************************\n");
        runInter6();
        System.out.println("********************************\n");
        runInter7();
        System.out.println("********************************\n");
        runInter8();
        System.out.println("********************************\n");
        runInter9();
        System.out.println("********************************\n");
        runInter10();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
    
    // uso de MiLista
    private static void runInter1() {
        // al crear el objeto de tipo List (una interfaz), se debe hacer
        // utilizando con el new() una clase que implemente dicha interfaz
        List lista = new MiLista();
        
        System.out.println("El tamaño de la lista es: " + lista.size());
        System.out.println("\n¿La lista está vacía? " + lista.isEmpty());
        
        lista.add(new Object());
        System.out.println("\nEl tamaño de la lista es: " + lista.size());
        System.out.println("\n¿La lista está vacía? " + lista.isEmpty());
    }

    // uso de subpaquete Figuras
    private static void runInter2() {
        // creamos una lista de figuras genéricas
        List<FiguraIF> lista = new ArrayList();
        // para almacenar el perímetro y áreas totales de las figuras
        double perimT = 0;
        double areaT = 0;
        
        // añadimos unas cuantas figuras
        lista.add(new Circulo(1));
        lista.add(new Cuadrado(5));
        lista.add(new TrianguloEq(3));
        lista.add(new TrianguloIsos(2, 4));
        
        for(FiguraIF fig : lista) {
            perimT += fig.calcularPerimetro();
            areaT += fig.calcularArea();
        }
        
        System.out.println("En total hay " + lista.size() + " figuras.\n"
                            + "El perímetro total es: " + perimT
                            + ".\nEl área total es: " + areaT + ".\n");
    }

    // uso de subpaquete Animales
    private static void runInter3() {
        // creamos 3 animales diferentes
        AnimalIF aniGato = new Gato("Calcetines");
        AnimalIF aniPerro = new Perro("Rex");
        AnimalIF aniOveja = new Oveja("Dolly");
        
        // los metemos en una lista
        List<AnimalIF> lista = new ArrayList();
        lista.add(aniGato);
        lista.add(aniOveja);
        lista.add(aniPerro);
        
        // consultamos su estado
        // aquí los elementos deben ser Animal, no AnimalIF (método getNombre()
        // definido en Animal, no en Animal IF), por eso se hace el cast ((Animal) an)
        for(AnimalIF an : lista) {
            System.out.println("¿Está " + ((Animal) an).getNombre() + " vivo? "
                                + AnimalIF.isAlive());
        }
        
        System.out.println();
        
        // les hacemos presentarse con una descripción genérica (animal)
        // aquí los elementos deben ser Animal, no AnimalIF (método getNombre()
        // definido en Animal, no en Animal IF), por eso se hace el cast ((Animal) an)
        for(AnimalIF an : lista) {
            System.out.println("Hola, soy " + ((Animal) an).getNombre() + " y "
                                + an.presentacionGenerica());
        }
        
        System.out.println();
        
        // les hacemos presentarse con una descripción específica
        // aquí los elementos deben ser Animal, no AnimalIF (método getNombre()
        // definido en Animal, no en Animal IF), por eso se hace el cast ((Animal) an)
        for(AnimalIF an : lista) {
            System.out.println("Hola, soy " + ((Animal) an).getNombre() + " y "
                                + an.presentacionConcreta());
        }
        
        System.out.println();
        
        // les hacemos emitir su sonido característico
        for(AnimalIF an : lista) {
            an.emitirSonido();
        }
        
        System.out.println();
        
        // les hacemos caminar
        for(AnimalIF an : lista) {
            an.caminar();
        }
        
        System.out.println();
    }

    // uso de comparadores (Comparable)
    // comparando fechas
    private static void runInter4() {
        FechaComparable fecha1 = new FechaComparable(23, 5, 1992, "*mi cumpleaños A*");
        FechaComparable fecha2 = new FechaComparable(27, 5, 1992, "*4 días después de mi cumpleaños*");
        FechaComparable fecha3 = new FechaComparable(23, 5, 1992, "*mi cumpleaños B*");
        FechaComparable fecha4 = new FechaComparable(23, 12, 1992, "*7 meses después de mi cumpleanos*");
        FechaComparable fecha5 = new FechaComparable(23, 5, 1994, "*mi segundo cumpleaños*");
        
        // procedemos a comparar fechas cronológicamente
        System.out.println("Orden cronológico"
                        + "\n-1 (anterior) | 0 (igual) | 1 (posterior)\n");
        
        System.out.println("¿Cómo es la fecha de " + fecha1.getNombre() +
        " respecto a\nla fecha de " + fecha2.getNombre() + "? " + fecha1.compareTo(fecha2) + "\n");
        
        System.out.println("¿Cómo es la fecha de " + fecha1.getNombre() +
        " respecto a\nla fecha de " + fecha3.getNombre() + "? " + fecha1.compareTo(fecha3) + "\n");
        
        System.out.println("¿Cómo es la fecha de " + fecha4.getNombre() +
        " respecto a\nla fecha de " + fecha3.getNombre() + "? " + fecha4.compareTo(fecha3) + "\n");
        
        System.out.println("¿Cómo es la fecha de " + fecha5.getNombre() +
        " respecto a\nla fecha de " + fecha2.getNombre() + "? " + fecha5.compareTo(fecha2) + "\n");
        
        System.out.println("¿Cómo es la fecha de " + fecha1.getNombre() +
        " respecto a\nla fecha de " + fecha4.getNombre() + "? " + fecha1.compareTo(fecha4) + "\n");
    }

    // comparando frases (cadenas de caracteres)
    private static void runInter5() {
        
        FraseComparable frase1 = new FraseComparable("*soy una frase*");
        FraseComparable frase2 = new FraseComparable("*soy una frase*");
        FraseComparable frase3 = new FraseComparable("*soy una frases*");
        FraseComparable frase4 = new FraseComparable("*138*");
        FraseComparable frase5 = new FraseComparable("*19*");
        FraseComparable frase6 = new FraseComparable("*soy otra frase más*");
        FraseComparable frase7 = new FraseComparable("*soy otra frase más.*");
        FraseComparable frase8 = new FraseComparable("*soy otra frase más2*");
        
        // procedemos a comparar frases lexicográficamente (alfabéticamente)
        System.out.println("Orden lexicográfico (orden de diccionario)"
                        + "\n-1 (anterior) | 0 (igual) | 1 (posterior)\n");
        
        System.out.println("¿Cómo es la frase de " + frase1.getFrase() +
        " respecto a\nla frase de " + frase2.getFrase() + "? " + frase1.compareTo(frase2) + "\n");
        
        System.out.println("¿Cómo es la frase de " + frase1.getFrase() +
        " respecto a\nla frase de " + frase3.getFrase() + "? " + frase1.compareTo(frase3) + "\n");
        
        System.out.println("¿Cómo es la frase de " + frase1.getFrase() +
        " respecto a\nla frase de " + frase6.getFrase() + "? " + frase1.compareTo(frase6) + "\n");
        
        // el orden lexicográfico es diferente del numérico. 19 < 138, sin embargo
        // "138" es anterior a "19" lexicográficamente hablando (alfabéticamente)
        System.out.println("¿Cómo es la frase de " + frase4.getFrase() +
        " respecto a\nla frase de " + frase5.getFrase() + "? " + frase4.compareTo(frase5) + "\n");
        
        System.out.println("¿Cómo es la frase de " + frase6.getFrase() +
        " respecto a\nla frase de " + frase7.getFrase() + "? " + frase6.compareTo(frase7) + "\n");
        
        System.out.println("¿Cómo es la frase de " + frase6.getFrase() +
        " respecto a\nla frase de " + frase8.getFrase() + "? " + frase6.compareTo(frase8) + "\n");
    }

    // uso de comparadores (Comparator)
    // comparando fechas
    private static void runInter6() {
        Fecha fecha1 = new Fecha(23, 5, 1992, "*mi cumpleaños A*");
        Fecha fecha2 = new Fecha(26, 5, 1992, "*4 días después de mi cumpleaños*");
        Fecha fecha3 = new Fecha(23, 5, 1992, "*mi cumpleaños B*");
        Fecha fecha4 = new Fecha(23, 12, 1992, "*7 meses después de mi cumpleanos*");
        Fecha fecha5 = new Fecha(23, 5, 1994, "*mi segundo cumpleaños*");
        
        // creamos un objeto comparador, con una lógica de comparación
        // interna que ya hemos definido previamente para las Fechas
        ComparadorFechas compFe = new ComparadorFechas();
        
        // procedemos a comparar fechas cronológicamente
        System.out.println("Orden cronológico"
                        + "\n-1 (anterior) | 0 (igual) | 1 (posterior)\n");
        
        System.out.println("¿Cómo es la fecha de " + fecha1.getNombre() +
        " respecto a\nla fecha de " + fecha2.getNombre() + "? " + compFe.compare(fecha1, fecha2) + "\n");
        
        System.out.println("¿Cómo es la fecha de " + fecha1.getNombre() +
        " respecto a\nla fecha de " + fecha3.getNombre() + "? " + compFe.compare(fecha1, fecha3) + "\n");
        
        System.out.println("¿Cómo es la fecha de " + fecha4.getNombre() +
        " respecto a\nla fecha de " + fecha3.getNombre() + "? " + compFe.compare(fecha4, fecha3) + "\n");
        
        System.out.println("¿Cómo es la fecha de " + fecha5.getNombre() +
        " respecto a\nla fecha de " + fecha2.getNombre() + "? " + compFe.compare(fecha5, fecha2) + "\n");
        
        System.out.println("¿Cómo es la fecha de " + fecha1.getNombre() +
        " respecto a\nla fecha de " + fecha4.getNombre() + "? " + compFe.compare(fecha1, fecha4) + "\n");
    }
    
    // comparando frases (cadenas de caracteres)
    private static void runInter7() {
        Frase frase1 = new Frase("*soy una frase*");
        Frase frase2 = new Frase("*soy una frase*");
        Frase frase3 = new Frase("*soy una frases*");
        Frase frase4 = new Frase("*138*");
        Frase frase5 = new Frase("*19*");
        Frase frase6 = new Frase("*soy otra frase más*");
        Frase frase7 = new Frase("*soy otra frase más.*");
        Frase frase8 = new Frase("*soy otra frase más2*");
        
        // creamos un objeto comparador, con una lógica de comparación
        // interna que ya hemos definido previamente para las Frases
        ComparadorFrases compFra = new ComparadorFrases();
        
        // procedemos a comparar frases lexicográficamente (alfabéticamente)
        System.out.println("Orden lexicográfico (orden de diccionario)"
                        + "\n-1 (anterior) | 0 (igual) | 1 (posterior)\n");
        
        System.out.println("¿Cómo es la frase de " + frase1.getFrase() +
        " respecto a\nla frase de " + frase2.getFrase() + "? " + compFra.compare(frase1, frase2) + "\n");
        
        System.out.println("¿Cómo es la frase de " + frase1.getFrase() +
        " respecto a\nla frase de " + frase3.getFrase() + "? " + compFra.compare(frase1, frase3) + "\n");
        
        System.out.println("¿Cómo es la frase de " + frase1.getFrase() +
        " respecto a\nla frase de " + frase6.getFrase() + "? " + compFra.compare(frase1, frase6) + "\n");
        
        // el orden lexicográfico es diferente del numérico. 19 < 138, sin embargo
        // "138" es anterior a "19" lexicográficamente hablando (alfabéticamente)
        System.out.println("¿Cómo es la frase de " + frase4.getFrase() +
        " respecto a\nla frase de " + frase5.getFrase() + "? " + compFra.compare(frase4, frase5) + "\n");
        
        System.out.println("¿Cómo es la frase de " + frase6.getFrase() +
        " respecto a\nla frase de " + frase7.getFrase() + "? " + compFra.compare(frase6, frase7) + "\n");
        
        System.out.println("¿Cómo es la frase de " + frase6.getFrase() +
        " respecto a\nla frase de " + frase8.getFrase() + "? " + compFra.compare(frase6, frase8) + "\n");
    }

    // ordenando una lista de fechas
    private static void runInter8() {
        FechaComparable fecha1 = new FechaComparable(23, 5, 1992, "*23/05/1992*");
        FechaComparable fecha2 = new FechaComparable(27, 5, 1992, "*27/05/1992*");
        FechaComparable fecha3 = new FechaComparable(23, 5, 1994, "*23/05/1994*");
        FechaComparable fecha4 = new FechaComparable(23, 5, 1992, "*23/05/1992*");
        FechaComparable fecha5 = new FechaComparable(23, 12, 1992, "*23/12/1992*");
        
        // añadimos las frases a la lista
        List<FechaComparable> lista = new ArrayList();
        lista.add(fecha1);
        lista.add(fecha2);
        lista.add(fecha3);
        lista.add(fecha4);
        lista.add(fecha5);
        
        // listamos todas las frases desordenadas
        System.out.println("Lista de fechas desordenadas:\n");
        for(FechaComparable f : lista) {
            System.out.println(f.getNombre());
        }
        
        // ordenamos la lista automáticamente, puesto que los elementos
        // de la lista son Comparables por si mismos (FechaComparable)
        Collections.sort(lista);
        
        // listamos todas las frases ordenadas
        System.out.println("\nLista de fechas ordenadas:\n");
        for(FechaComparable f : lista) {
            System.out.println(f.getNombre());
        }
        System.out.println();
    }

    // ordenando una lista de frases
    private static void runInter9() {
        Frase frase1 = new Frase("*robot*");
        Frase frase2 = new Frase("*batidora*");
        Frase frase3 = new Frase("*perro*");
        Frase frase4 = new Frase("*sartén*");
        Frase frase5 = new Frase("*alfombra*");
        
        // añadimos las frases a la lista
        List<Frase> lista = new ArrayList();
        lista.add(frase1);
        lista.add(frase2);
        lista.add(frase3);
        lista.add(frase4);
        lista.add(frase5);
        
        // listamos todas las frases desordenadas
        System.out.println("Lista de frases desordenadas:\n");
        for(Frase f : lista) {
            System.out.println(f.getFrase());
        }
        
        // creamos un objeto comparador, con una lógica de comparación
        // interna que ya hemos definido previamente para las Frases
        ComparadorFrases compFra = new ComparadorFrases();
        
        // ordenamos la lista acorde al comparador de frases que tenemos
        lista.sort(compFra);
        
        // listamos todas las frases ordenadas
        System.out.println("\nLista de frases ordenadas:\n");
        for(Frase f : lista) {
            System.out.println(f.getFrase());
        }
    }

    // ejemplos de uso de isLess, isEquals, isGreater
    private static void runInter10() {
        // añadimos las palabras a la lista
        List<FraseComparable> lista = new ArrayList();
        lista.add(new FraseComparable("*robot*"));
        lista.add(new FraseComparable("*batidora*"));
        lista.add(new FraseComparable("*perro*"));
        
        // listamos todas las frases desordenadas
        System.out.println("Lista de palabras:\n");
        for(FraseComparable f : lista) {
            System.out.println(f.getFrase());
        }
        
        System.out.println("\n¿Va antes " + lista.get(1).getFrase() + " que "
                + lista.get(0).getFrase() + "? " + lista.get(1).isLess(lista.get(0)));
        
        System.out.println("\n¿Va antes " + lista.get(0).getFrase() + " que "
                + lista.get(2).getFrase() + "? " + lista.get(0).isLess(lista.get(2)));
        
        System.out.println("\n¿Va después " + lista.get(2).getFrase() + " que "
                + lista.get(1).getFrase() + "? " + lista.get(2).isGreater(lista.get(1)));
    }
}