package clasesprog.Interfaces;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// clase que implementa la interfaz List a modo de ejemplo,
// implementando alguno de sus métodos
public class MiLista implements List<Object> {
    // estructura de datos interna para manejar los elementos de la lista
    private final Object[] elements;
    // contador para tener un índice y n° de elementos de la lista
    private int counter;
    
    public MiLista() {
        // se crea por defecto una lista de tamaño 100
        this.elements = new Object[100];
        // y se inicializa el contador a 0
        this.counter = 0;
    }

    @Override
    public int size() {      
        return counter;
    }
    
    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean add(Object e) {
        // se comprueba la nulidad del parámetro pasado
        if(e != null) {
            // si no es nulo, se añáde el elemento
            this.elements[counter] = e;
            // se incrementa el contador
            counter++;
            // y se devuelve true
            return true;
        }
        return false;
    }

    // resto de métodos de la interfaz List sin implementar
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<Object> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(Collection<? extends Object> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends Object> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object get(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(int index, Object element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object remove(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<Object> listIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<Object> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Object> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}