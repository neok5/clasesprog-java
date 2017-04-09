package clasesprog.Colecciones;

// en este caso se importa el paquete entero, porque se usarán muchos
// de los componentes del mismo, y es más sencillo que hacer muchos imports
import java.util.*;
import java.text.Collator;
// importamos la clase Fecha creada en el paquete de Interfaces, para reutilizarla
import clasesprog.Interfaces.Comparadores.Fecha;

/**
 * Clase que contiene los ejemplos de ejecución sobre las
 * colecciones creadas para el tema de las Colecciones Java
 */
public class EjemplosCole {
    
    /**
     * Método principal del paquete Colecciones (invocado desde el main)
     */
    public static void runColecciones() {
        runCole1();
        System.out.println("********************************\n");
        runCole2();
        System.out.println("********************************\n");
        runCole3();
        System.out.println("********************************\n");
        runCole4();
        System.out.println("********************************\n");
        runCole5();
        System.out.println("********************************\n");
        runCole6();
        System.out.println("********************************\n");
        runCole7();
        System.out.println("********************************\n");
        runCole8();
        System.out.println("********************************\n");
        runCole9();
        System.out.println("********************************\n");
        runCole10();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    /**
     * Ejemplo de uso Collection
     */
    private static void runCole1() {
        // creamos una nueva Collection de String vacía,
        // y lo inicializamos como un ArrayList
        // además creamos otra variable Collection sin inicializar
        Collection<String> coleccion = new ArrayList(), coleccionCopia;
        
        // añadimos elementos a la colección original
        coleccion.add("Uno"); coleccion.add("Dos"); coleccion.add("Tres");
        coleccion.add("Cuatro"); coleccion.add("Cinco"); coleccion.add("Seis");
        
        // creamos una copia de la colección a partir de la original
        coleccionCopia = new ArrayList(coleccion);
        
        System.out.println("¿Son ambas colecciones iguales? "
                                + coleccion.equals(coleccionCopia));
        
        System.out.println("\n¿Contiene la primera colección el elemento \"Dos\"? "
                                + coleccion.contains("Dos"));
        
        System.out.println("\n¿Contiene la primera colección el elemento \"Ocho\"? "
                                + coleccion.contains("Ocho"));
        
        System.out.println("\nEl tamaño de la copia de la colección es: "
                                                    + coleccionCopia.size());
        
        // eliminamos dos elementos en la copia
        coleccionCopia.remove("Dos"); coleccionCopia.remove("Seis");
        
        System.out.println("\nDespués de eliminar 2 elementos, el tamaño es: "
                                                        + coleccionCopia.size());
        
        // vaciamos la copia
        coleccionCopia.clear();
        
        System.out.println("\n(vaciamos la copia) ¿La copia está vacía? "
                                                            + coleccionCopia.isEmpty());
        
        // volvemos a copiar el original en la copia
        coleccionCopia.addAll(coleccion);
        
        System.out.println("\n(añadimos todos los elementos de la original"
                + " a la copia\nde nuevo) La lista de elementos de la copia es:\n");
        for(String cad : coleccionCopia) {
            System.out.println(cad);
        }
        System.out.println();
    }

    /**
     * Ejemplo de uso Set
     */
    private static void runCole2() {
        // creamos un Set vacío de enteros
        Set<Integer> conjunto = new HashSet();
        
        // añadimos algunos elementos
        conjunto.add(1); conjunto.add(2); conjunto.add(3);
        conjunto.add(4); conjunto.add(5); conjunto.add(6);
        conjunto.add(7); conjunto.add(8); conjunto.add(9);
        
        // listamos sus elementos
        System.out.println("Conjunto de elementos:\n");
        for(int n : conjunto) {
            System.out.print(n + " ");
        }
        System.out.println("\n");
        
        // intentamos añadir elementos repetidos y sin repetir
        // añade el 23 pero no el 5, y devuelve además true y false respectivamente
        System.out.println("¿Añadimos el elemento 5? -> " + conjunto.add(5));
        System.out.println("¿Añadimos el elemento 23? -> " + conjunto.add(23));
        
        // listamos sus elementos
        // como se puede ver, añade los elementos sin orden
        // apareciendo el 23 entre el 7 y el 8
        System.out.println("\nConjunto de elementos:\n");
        for(int n : conjunto) {
            System.out.print(n + " ");
        }
        
        System.out.println("\n\n¿El conjunto contiene el elemento null? "
                                                + conjunto.contains(null));
        System.out.println("(añadimos null, e intentamos añadirlo reiteradas veces)");
        // añadimos un elemento nulo
        conjunto.add(null); // VER CON EL DEPURADOR
                            // dado que no se puede listar por pantalla
        
        // si intentamos realizar operaciones sobre cada elemento del conjunto, y está null,
        // saltará una excepción NullPointerException (NPE), puesto que intentaría
        // invocar un método sobre un objeto null, cosa que no está permitido hacer
        
        // añadimos más elementos null, sin que pase nada, no modifica el conjunto
        conjunto.add(null); conjunto.add(null); conjunto.add(null);
        
        System.out.println("¿El conjunto contiene el elemento null? "
                                                + conjunto.contains(null));
        
        System.out.println("(borramos null)");
        conjunto.remove(null);
        System.out.println("¿El conjunto contiene el elemento null? "
                                                + conjunto.contains(null) + "\n");
    }

    /**
     * Ejemplo de uso SortedSet (orden natural y orden total)
     */
    private static void runCole3() {
        // TreeSet ordenado según el orden natural de sus elementos;
        // deben implementar la interfaz interfaz Comparable (como Integer)
        SortedSet<Integer> conjunto_ON = new TreeSet();
        
        // intentamos obtener el Comparator del conjunto, si existe
        System.out.println("CONJUNTO ORDEN NATURAL\n");
        if (conjunto_ON.comparator() == null)
            System.out.println("No existe un comparador (se usa orden natural).\n");
        else
            System.out.println("Existe un comparador (se usa orden total del comparador).\n");
        
        // añadimos elementos desordenadamente
        conjunto_ON.add(4); conjunto_ON.add(2); conjunto_ON.add(99); conjunto_ON.add(5);
        conjunto_ON.add(1); conjunto_ON.add(0); conjunto_ON.add(32); conjunto_ON.add(40);
        
        // listamos los elementos, y como se puede ver, salen ordenados
        System.out.println("Conjunto de elementos ordenados:");
        for(int n : conjunto_ON) {
            System.out.print(n + " ");
        }
        
        System.out.println("\n\nEl primer elemento es: " + conjunto_ON.first());
        System.out.println("El último elemento es: " + conjunto_ON.last());
        
        // creamos un nuevo conjunto para almacenar subconjuntos
        SortedSet<Integer> subConjunto_ON;
        
        // subconjunto de los elementos entre el 2 (incluido) y el 40 (excluido)
        subConjunto_ON = conjunto_ON.subSet(2, 40);
        
        System.out.print("\n(elementos entre el 2 y el 40) -> ");
        for(int n : subConjunto_ON) {
            System.out.print(n + " ");
        }
        
        // subconjunto de los elementos entre el 2 (incluido) y el 41 (excluido)
        // aquí si incluye el 40, al ser estrictamente menor que el 41
        subConjunto_ON = conjunto_ON.subSet(2, 41);
        
        System.out.print("\n(elementos entre el 2 y el 41) -> ");
        for(int n : subConjunto_ON) {
            System.out.print(n + " ");
        }
        
        // subconjunto de los elementos menores que 5
        subConjunto_ON = conjunto_ON.headSet(5);
        
        System.out.print("\n(elementos estrictamente menores que 5) -> ");
        for(int n : subConjunto_ON) {
            System.out.print(n + " ");
        }
        
        // subconjunto de los elementos iguales o mayores que 5
        subConjunto_ON = conjunto_ON.tailSet(5);
        
        System.out.print("\n(elementos iguales o mayores que 5) -> ");
        for(int n : subConjunto_ON) {
            System.out.print(n + " ");
        } System.out.println("\n");
        
        // TreeSet ordenado según el orden total impuesto por
        // el comparador (Comparator) que se le pasa como parámetro;
        // en este caso usamos un Collator, que permite comparar String
        Collator comp = Collator.getInstance();
        // Collator.PRIMARY indica rigurosidad débil ("a" = "A" = "á" = "Á")
        comp.setStrength(Collator.PRIMARY);
        SortedSet<String> conjunto_OT = new TreeSet(comp);
        
        // intentamos obtener el Comparator del conjunto, si existe
        System.out.println("CONJUNTO ORDEN TOTAL\n");
        if (conjunto_OT.comparator() == null)
            System.out.println("No existe un comparador (se usa orden natural).\n");
        else
            System.out.println("Existe un comparador (se usa orden total del comparador).\n");
        
        // añadimos elementos desordenadamente
        conjunto_OT.add("coche"); conjunto_OT.add("tronco"); conjunto_OT.add("pajaro");
        conjunto_OT.add("amanecer"); conjunto_OT.add("mar"); conjunto_OT.add("hola");
        
        // listamos los elementos, y como se puede ver, salen ordenados
        System.out.println("Conjunto de elementos ordenados:\n");
        for(String cad : conjunto_OT) {
            System.out.println(cad);
        }
        
        // borramos 2 palabras
        conjunto_OT.remove("coche"); conjunto_OT.remove("tronco");
        
        // listamos los elementos después de borrar 2 palabras
        System.out.println("\nConjunto de elementos ordenados:\n"
                                        + "(después de borrar coche y tronco)\n");
        for(String cad : conjunto_OT) {
            System.out.println(cad);
        } System.out.println();
    }

    /**
     * Ejemplo de uso Queue
     */
    private static void runCole4() {
        // creamos un Queue vacío de String
        Queue<String> cola = new LinkedList();
        
        // añadimos elementos a la cola
        // utilizamos add, en lugar de offer, puesto que en este caso,
        // no ha lugar a error, debido a que la cola no tiene capacidad restringida
        cola.add("tiburon"); cola.add("ejercito"); cola.add("dado");
        cola.add("colapso"); cola.add("zanahoria"); cola.add("arbitro");
        
        // listamos los elementos
        System.out.println("Cola de elementos:\n");
        for(String cad : cola) {
            System.out.println(cad);
        }
        
        // obtenemos el elemento en la cabeza de la cola, sin eliminarlo de la misma
        System.out.println("\nEl primer elemento de la cola es: " + cola.element());
        // borramos dos elementos, los dos primeros
        String borrado1 = cola.remove(), borrado2 = cola.remove();
        System.out.println("(borramos dos elementos de la cola): " + borrado1 +
                                                                " y " + borrado2);
        // obtenemos el primer elemento de la cola, sin eliminarlo de la misma
        // en este caso usamos peek(), que nos devolvería null en caso de cola vacía
        System.out.println("El primer elemento de la cola es: " + cola.peek());
        System.out.println("(seguimos borrando elementos hasta que no quede ninguno)");
        // borramos elementos utilizando poll, en lugar de remove, puesto que, si llegamos
        // a dejar la cola vacía, e intentamos borrar otro elemento más, devolverá null
        // pero no lanzará una excepción. Si utilizásemos remove si lanzaría una excepción
        cola.remove(); cola.remove(); cola.remove(); cola.remove();
        
        // listamos los elementos
        System.out.println("\nCola de elementos (ahora vacía):\n");
        for(String cad : cola) {
            System.out.println(cad);
        }
        
        // añadimos un elemento "ultimo" e intentamos extraer un elemento 2 veces sucesivas
        // cola.remove() lanzaría una excepción NoSuchElementException
        // utilizando poll(), no lanza una excepción, y vemos que devuelve null
        cola.add("ultimo");
        System.out.println("Los valores devueltos después de 2 operaciones"
                + "\nde extracción son: *" + cola.remove() + "* y *" + cola.poll() + "*\n");
    }

    /**
     * Ejemplo de uso List
     */
    private static void runCole5() {
        // creamos una lista compuesta por los elementos pasados
        // como parámetro al método estático asList() de la clase Arrays
        List<String> nombresRios = Arrays.asList(
                                        "Guadiana", "Duero", "Sil", "Tajo", "Ebro");
        
        // listamos los elementos de los nombres de los rios desordenadamente
        System.out.println("Algunos ríos (desordenados) son:\n");
        for(String rio : nombresRios) {
            System.out.println(rio);
        }
        
        // ordenamos los rios alfabeticamente, según su orden natural (sin comparador)
        // String impone un orden natural interno, puesto que implementa Comparable
        Collections.sort(nombresRios);
        
        // listamos los elementos de los nombres de los rios ordenadamente
        System.out.println("\nAlgunos ríos (ordenados) son:\n");
        for(String rio : nombresRios) {
            System.out.println(rio);
        }
        
        // creamos una nueva List vacía de Integer
        List<Integer> lista = new ArrayList();
        
        // añadimos elementos a la lista vacía inicial
        lista.add(23); lista.add(5); lista.add(1); lista.add(99); lista.add(-8);
        lista.add(-3); lista.add(7); lista.add(512); lista.add(-58); lista.add(81);
        
        // listamos los enteros desordenadamente
        System.out.println("\nLos enteros (desordenados) son:\n");
        for(int num : lista) {
            System.out.print(num + " ");
        }
        
        // ordenamos los enteros numéricamente (según su valor), utilizando
        // un comparador externo en este caso, creado ad hoc para este ejemplo
        // utilizamos una lista auxiliar para no corromper la original
        List<Integer> listaAux = new ArrayList(lista);
        Collections.sort(listaAux, new ComparadorEnteros());
        
        // listamos los enteros ordenadamente
        System.out.println("\n\nLos enteros (ordenados) son:\n");
        for(int num : listaAux) {
            System.out.print(num + " ");
        }
        
        // añadimos elementos siempre en la tercera posición de la lista
        lista.add(2, 0); lista.add(2, 0); lista.add(2, 0); lista.add(2, 0);
        
        // listamos los enteros desordenadamente
        System.out.println("\n\nLos enteros (desordenados) son:");
        System.out.println("(hemos añadido 4 ceros en la tercera posición)\n");
        for(int num : lista) {
            System.out.print(num + " ");
        }
        
        // obtenemos el elemento de una posición concreta
        System.out.println("\n\nEl elemento en la posición séptima es: "
                                                        + lista.get(6));
        
        // consultamos el tamaño de la lista
        System.out.println("\nLa lista tiene " + lista.size() + " elementos.");
        
        // obtenemos la posición de un elemento concreto
        // las posiciones comienzan por 0, por eso se suma 1
        System.out.println("\nEl elemento '512' ocupa la posición:\n\t\t"
            + lista.indexOf(512) + " (real, inicio 0) " + (lista.indexOf(512)+1) + " (normal, inicio 1)");
        
        // creamos una colección auxiliar, que será un subconjunto de la orginal
        // si utilizamos mal los indices, puede lanzarse una IndexOutOfBoundsException
        // indice inferior incluido, indice superior excluido
        List<Integer> subLista = new ArrayList(lista.subList(10, lista.size()));
        
        // listamos la sublista creada
        System.out.println("\n(hemos creado una sublista con los 4 últimos elementos)");
        System.out.println("La sublista (desordenada) es:\n");
        for(int num : subLista) {
            System.out.print(num + " ");
        }
        
        // comprobamos si la lista original contiene la sublista
        System.out.println("\n\n¿La sublista de los 4 últimos elementos"
                + "\nestá contenida en la lista original? " + lista.containsAll(subLista));
        
        Collections.sort(subLista);
        System.out.println("\n(ordenamos la sublista)\n");
        
        // listamos la sublista creada ordenada
        System.out.println("La sublista (ordenada) es:");
        for(int num : subLista) {
            System.out.print(num + " ");
        } System.out.println("\n");
        
        // comprobamos si la lista original contiene la sublista
        System.out.println("¿La sublista de los 4 últimos elementos"
                + "\nestá contenida en la lista original? " + lista.containsAll(subLista));
        
        // añadimos un elemento distinto a la sublista, que no estuviera en la lista inicial
        subLista.add(50);
        
        System.out.println("\n(añadimos un elemento nuevo y\n"
                            + "diferente a todas las listas -> 50)\n");
        // volvemos a hacer la misma comprobación de antes
        System.out.println("¿La sublista de los 4 últimos elementos"
                + "\nestá contenida en la lista original? " + lista.containsAll(subLista) + "\n");
    }

    /**
     * Ejemplo de uso iteradores (Iterable e Iterator)
     */
    private static void runCole6() {
        // creamos un iterador sobre las unidades (enteros del 0 al 0)
        Iterator<Integer> itNum = new Unidades().iterator();
        
        // listamos dichos enteros por pantalla. Uso básico del iterador
        System.out.println("Lista de unidades (expresadas como enteros):\n");
        while(itNum.hasNext()) {
            System.out.print(itNum.next() + " ");
        } System.out.println("\n");
        
        // creamos una Collection cualquiera, por ejemplo una List, para iterar sobre ella
        Iterator<String> itRios =
                    Arrays.asList("Guadiana", "Duero", "Sil", "Tajo", "Ebro").iterator();
        
        // listamos por pantalla, una vez más
        System.out.println("Lista de ríos:\n");
        while(itRios.hasNext()) {
            System.out.println(itRios.next());
        }
        
        // si reutilizamos un iterador, vemos como ya no tiene elementos
        System.out.println("\nVolvemos a tratar de utilizar un iterador anterior:");
        while(itRios.hasNext()) {
            System.out.println(itRios.next());
        } System.out.println("\n\n\n(vemos como ahora está vacio)");
        
        // creamos una lista de elementos, para poner en práctica otro ejemplo
        List<String> lista = new ArrayList();
        lista.add("coche"); lista.add("farola"); lista.add("altavoz"); lista.add("oceano");
        
        // listamos la lista original con un for each
        System.out.println("\nLista de palabras (for each):\n");
        for(String s : lista) {
            System.out.println(s);
        }
        
        // ahora utilizamos un iterador para hacer lo mismo
        System.out.println("\nLista de palabras (iterador):\n");
        Iterator<String> it = lista.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        // listamos con un iterador ya usado
        System.out.println("\nLista de palabras (iterador 2a vez):\n");
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        // listamos la lista original con un for each por segunda vez
        // como vemos, la lista original no se destruye, el iterador es una copia
        System.out.println("\nLista de palabras (for each 2a vez):\n");
        for(String s : lista) {
            System.out.println(s);
        }

        // listamos con un iterador nuevo, creado otra vez
        System.out.println("\nLista de palabras (iterador nuevo):\n");
        Iterator<String> it2 = lista.iterator();
        while(it2.hasNext()) {
            System.out.println(it2.next());
        }
        
        // ejemplo de uso sobre cómo los objetos
        // son referencias (punteros) y no valores
        // lista de listas principal
        List<List<String>> lList = new ArrayList();
        // listas internas que se añaden a la lista de listas
        List<String> list1 = new ArrayList()
                   , list2 = new ArrayList()
                   , list3 = new ArrayList();
        // rellenamos las listas interiores
        list1.add("Lista 1 - Elemento 1"); list1.add("Lista 1 - Elemento 2");
        list2.add("Lista 2 - Elemento 3"); list2.add("Lista 2 - Elemento 4");
        // y las añadimos a la lista principal
        lList.add(list1); lList.add(list2); lList.add(list3);
        // aquí trabajamos sobre el puntero a la tercera lista, por tanto,
        // estamos modificando directamente la lista ya añadida a la lista de listas
        list3.add("Lista 3 - Elemento 5"); list3.add("Lista 3 - Elemento 6");
        
        // listamos la lista de listas completa mediante un for each
        for(List<String> l : lList) {
            System.out.println();
            // listamos cada lista interna usando un iterador de String
            Iterator<String> itList = l.iterator();
            while(itList.hasNext()) {
                System.out.println(itList.next());
            }
        }
        
        // creamos un iterador para la lista de listas
        Iterator<List<String>> itll = lList.iterator();
        // listamos las listas internas de la lista de listas principal
        System.out.println();
        while(itll.hasNext()) {
            System.out.println(itll.next());
        }
        
        // reiniciamos el iterador
        itll = lList.iterator();
        while(itll.hasNext()) {
            List<String> aux = itll.next();
            // si la lista contiene ese String la limpiamos (vaciamos)
            // de tal forma que al llegar a la segunda lista,
            // la borra, dejando el resto intactas
            if(aux.contains("Lista 2 - Elemento 3"))
                aux.clear();
        }
        
        // volvemos a listar las listas con un for each esta vez
        // y vemos como ahora, la segunda lista está vacía (borrada)
        System.out.println();
        for(List<String> ll : lList) {
            System.out.println(ll);
        } System.out.println();
    }
    
    /**
     * Ejemplo de uso iteradores de listas (ListIterator)
     */
    private static void runCole7() {
        // creamos un iterador sobre las unidades (enteros del 0 al 0)
        ListIterator<Integer> itNum = new Unidades().getList().listIterator();
        
        // listamos las unidades por pantalla en orden normal
        System.out.println("Lista de unidades (orden normal):\n");
        while(itNum.hasNext()) {
            System.out.print(itNum.next() + " ");
        }
        
        // listamos las unidades por pantalla en orden inverso
        System.out.println("\n\nLista de unidades (orden inverso):\n");
        while(itNum.hasPrevious()) {
            System.out.print(itNum.previous()+ " ");
        }
        
        // iterador de lista normal que empieza en el 5
        itNum = new Unidades().getList().listIterator(5);
        
        // listamos las unidades por pantalla en orden normal, desde el 5 (inclusive)
        System.out.println("\n\nLista de unidades (orden normal) desde el 5 inclusive:\n");
        while(itNum.hasNext()) {
            System.out.print(itNum.next()+ " ");
        }
        
        // iterador de lista inverso que empieza en el 5
        // hace falta "reiniciar" el iterador, para volver a situar el indice en el 5
        itNum = new Unidades().getList().listIterator(5);
        
        // listamos las unidades por pantalla en orden inverso, desde el 5 (exclusive)
        System.out.println("\n\nLista de unidades (orden inverso) desde el 5 exclusive:\n");
        while(itNum.hasPrevious()) {
            System.out.print(itNum.previous()+ " ");
        } System.out.println("\n");
    }

    /**
     * Ejemplo de uso Map
     */
    private static void runCole8() {
        // creamos un nuevo Map vacío
        Map<String, Integer> listin = new HashMap();
        
        // añadimos algunos elementos, es decir, algunas entradas, al mapa
        listin.put("Jose", 987400001); listin.put("Pedro", 987400002);
        listin.put("Ana", 987400003); listin.put("Nerea", 987400004);
        listin.put("Daniel", 987400005); listin.put("Lucia", 987400006);
        
        // listamos las claves contenidas en el Map
        System.out.println("Las claves del Map son:\n");
        for(String clave : listin.keySet())
            System.out.println(clave);
        
        // el metodo keySet devuelve un Set, pero podemos crear un List a partir de él
        List<String> claves = new ArrayList(listin.keySet());
        // hacemos esto, porque el método sort solo admite parámetros de tipo List, no Set
        // ordenamos la lista
        Collections.sort(claves);
        // listamos las claves de forma ordenada
        System.out.println("\nLas claves ordenadas del Map son:\n");
        for(String clave : claves)
            System.out.println(clave);
        
        // listamos los valores contenidos en el Map
        System.out.println("\nLos valores del Map son:\n");
        for(Integer valor : listin.values())
            System.out.println(valor);
        
        // listamos las entradas (clave, valor) contenidas en el Map
        System.out.println("\nLas entradas (completas) del Map son (vista por defecto):\n");
        for(Map.Entry<String, Integer> entrada : listin.entrySet()) {
            System.out.println(entrada);
        }
        
        // listamos las entradas dándole nuestro propio formato
        System.out.println("\nLas entradas (completas) del Map son (vista personalizada):\n");
        for(Map.Entry<String, Integer> entrada : listin.entrySet()) {
            System.out.println("[" + entrada.getValue() + "] " + entrada.getKey());
        }
        
        // comprobamos si una determinada clave está en el mapa
        System.out.println("\n¿El n° de teléfono de 'Enrique' está en el listín? "
                                                                   + listin.containsKey("Enrique"));
        
        // comprobamos si un determinado valor está en el mapa
        System.out.println("¿El n° de teléfono 987400002 está en el listín? "
                                                                   + listin.containsValue(987400002));
        
        // obtenemos el n° de teléfono de una persona concreta (devuelve null si no existe)
        System.out.println("¿Cuál es el número de teléfono de 'Nerea'? " + listin.get("Nerea"));
        
        // mostramos cuántos números de teléfono contiene el listín
        System.out.println("El listín tiene un total de " + listin.size() + " n° de teléfono");
        
        // borramos un número
        listin.remove("Daniel");
        System.out.println("(borramos el n° de teléfono de Daniel)");
        // mostramos cuántos números de teléfono contiene el listín
        System.out.println("El listín tiene un total de " + listin.size() + " n° de teléfono\n");
    }

    /**
     * Ejemplo de uso SortedMap
     */
    private static void runCole9() {
        // creamos un nuevo SortedMap vacío,
        // una "base de datos" para los clientes de una empresa
        SortedMap<Integer, Cliente> clientDB = new TreeMap();
        
        // comprobamos si el SortedMap usa orden natural o total
        System.out.println("¿Estamos usando ORDEN NATURAL para las entradas? "
                                                + (clientDB.comparator() == null));
        
        // añadimos unos cuantos clientes de forma totalmente desordenada
        // la clave es un ID de cliente, y el valor es el Cliente en si mismo
        clientDB.put(4, new Cliente("Cliente 4", "71566312-J", new Fecha(18, 12, 1982)));
        clientDB.put(2, new Cliente("Cliente 2", "71424512-J", new Fecha(5, 8, 1990)));
        clientDB.put(1, new Cliente("Cliente 1", "71826312-J", new Fecha(23, 5, 1992)));
        clientDB.put(3, new Cliente("Cliente 3", "71926342-J", new Fecha(4, 1, 1965)));
        
        // listamos los clientes por pantalla
        System.out.println("\nLista de clientes de la empresa:\n");
        for(Map.Entry<Integer, Cliente> entrada : clientDB.entrySet())
            System.out.println("[" + entrada.getKey() + "] " + entrada.getValue());
        
        // imprimimos el primer cliente de la 'base de datos'
        System.out.println("\nEl primer cliente es: " + clientDB.get(clientDB.firstKey()));
        
        // imprimimos el último cliente de la 'base de datos'
        System.out.println("El último cliente es: " + clientDB.get(clientDB.lastKey()));
        
        // obtenemos los 2 primeros clientes, y los listamos
        // para el headMap, el parámetro marca el límite superior (exclusive) <
        System.out.println("\nLista de los 2 primeros clientes:\n");
        for(Map.Entry<Integer, Cliente> entrada : clientDB.headMap(3).entrySet())
            System.out.println("[" + entrada.getKey() + "] " + entrada.getValue());
        
        // obtenemos los 2 últimos clientes, y los listamos
        // para el tailMap, el parámetro marca el límite inferior (inclusive) >=
        System.out.println("\nLista de los 2 últimos clientes:\n");
        for(Map.Entry<Integer, Cliente> entrada : clientDB.tailMap(3).entrySet())
            System.out.println("[" + entrada.getKey() + "] " + entrada.getValue());
        
        // obtenemos los 2 clientes intermedios, y los listamos
        // para el subMap, el primer parámetro marca el límite inferior (inclusive) >=
        // y el segundo parámetro marca el límite superior (exclusive) <
        System.out.println("\nLista de los 2 últimos clientes:\n");
        for(Map.Entry<Integer, Cliente> entrada : clientDB.subMap(2,4).entrySet())
            System.out.println("[" + entrada.getKey() + "] " + entrada.getValue());
        System.out.println();
        
        // se puede utilizar también un ORDEN TOTAL, mediante un comparador (Comparator)
        // igual que se hacía con los conjuntos SortedSet
        // no lo he añadido porque es repetir el ejemplo de nuevo, y la finalidad es la misma
    }

    /**
     * Ejemplo de uso Collections
     */
    private static void runCole10() {
        // inicio método addAll
        System.out.println("--- MÉTODO ADDALL ---\n");
        
        // creamos una lista de rios vacía
        List<String> listaRios = new ArrayList();
        
        // añadimos unos cuantos rios
        listaRios.add("Ebro"); listaRios.add("Tajo"); listaRios.add("Duero");
        
        // creamos un array estático con más ríos
        String[] masRios = {"Guadiana", "Sil"};
        
        // añadimos a la lista original primero los rios del array estático
        Collections.addAll(listaRios, masRios);
        // y más tarde ríos como elementos sueltos
        Collections.addAll(listaRios, "Júcar", "Segura", "Tormes");
        
        // listamos los ríos, y vemos como están todos añadidos
        for(String rio : listaRios)
            System.out.println(rio);
        
        
        
        
        
        // inicio método copy
        System.out.println("\n--- MÉTODO COPY ---\n");
        
        // copiamos la lista de rios anterior, eliminamos los 3 últimos e imprimimos
        List<String> riosNuevo = new ArrayList();
        
        // la lista inicial es de tamaño 0, por ese se deben añadir 8 elementos vacíos
        Collections.addAll(riosNuevo, "", "", "", "", "", "", "", "");
        Collections.copy(riosNuevo, listaRios);
        
        // eliminamos los 3 últimos elementos
        riosNuevo.remove(riosNuevo.size()-1);
        riosNuevo.remove(riosNuevo.size()-1);
        riosNuevo.remove(riosNuevo.size()-1);
        
        // imprimimos
        for(String rio : riosNuevo)
            System.out.println(rio);
        
        
        
        
        
        // inicio método disjoint
        System.out.println("\n--- MÉTODO DISJOINT ---\n");
        
        // comprobamos si la lista de ríos original y la lista de nuevos rios son disjuntas
        System.out.println("¿Son disjuntas (no tienen elementos comunes) la lista\nde ríos "
        + "original y la lista de nuevos ríos? " + Collections.disjoint(listaRios, riosNuevo));
        
        
        
        
        
        // inicio método shuffle
        System.out.println("\n--- MÉTODO SHUFFLE ---\n");
        
        // creamos una lista nueva a partir de un conjunto de String
        List<String> lista = Arrays.asList("abecedario", "persona", "moto", "caracol", "yoyo");
        
        // imprimimos la lista
        System.out.println("Lista original:\n" + lista);
        
        // mezclamos (barajamos) los elementos de la lista
        // con cada ejecución del programa, el orden de la lista final variará
        // debido precisamente a que las permutaciones que hace son aleatorias
        Collections.shuffle(lista);
        
        // volvemos a imprimir por pantalla la lista
        System.out.println("\nLista 'barajada':\n" + lista);
    }
    
    /**
     * Clase interna auxiliar que se usa como comparador externo de enteros
     * (usado en runCole5())
     */
    static class ComparadorEnteros implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.intValue() - o2.intValue();
        }
    }
    
    /**
     * Clase interna auxiliar que se usa para ejemplificar un objeto Iterable
     * Su único método devuelve un iterador sobre una lista de unidades (0-9)
     */
    static class Unidades implements Iterable<Integer> {
        private final Collection<Integer> unidades = new ArrayList();
        
        public Unidades() {
            for(int i = 0; i < 10; i++)
                unidades.add(i);
        }
        
        @Override
        public Iterator<Integer> iterator() {
            return unidades.iterator();
        }
        
        /**
         * @return la lista de unidades como un objeto List<Integer>
         */
        public List<Integer> getList() {
            return (List<Integer>) this.unidades;
        }
    }
    
    /**
     * Clase interna auxiliar para representar clientes de una empresa
     */
    static class Cliente {
        private String nombre;
        private String dni;
        private Fecha fechaNac;
        
        public Cliente(String nombre, String dni, Fecha fechaNac) {
            this.nombre = nombre;
            this.dni = dni;
            this.fechaNac = fechaNac;
        }
        
        @Override
        public String toString() {
            return this.nombre + " | " + this.dni + " | " + this.fechaNac.getDay()
                    + "/" + this.fechaNac.getMonth() + "/" + this.fechaNac.getYear();
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public Fecha getFechaNac() {
            return fechaNac;
        }

        public void setFechaNac(Fecha fechaNac) {
            this.fechaNac = fechaNac;
        }
    }
}