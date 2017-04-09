package clasesprog.ExamenCalando;

import java.util.function.Predicate;

/**
 * Representa una Condicion concreta a la hora de filtrar la lista de Articulo(s)
 */
public class Condicion {
    // predicado para cada Condicion. Usamos internamente programación
    // funcional, expresiones lambda y la clase Predicate de la API de Java
    Predicate<Articulo> predicado;

    /**
     * Constructor que permite concatenar diferentes Condicione(s)
     * mediante operadores lógicos como AND, OR y NOT
     *
     * @param predicado el predicado final que contiene la Condicion resultante
     */
    private Condicion(Predicate<Articulo> predicado) {
        this.predicado = predicado;
    }
    
    /**
     * Constructor para condiciones simples de Tipo
     *
     * @param tipo el tipo a evaluar en el filtrado de la lista
     */
    public Condicion(Articulo.Tipo tipo) {
        // expresión lambda equivalente:
        // predicado = (Articulo t) -> t.getTipo().equals(tipo);
        predicado = new Predicate<Articulo>() {
            @Override
            public boolean test(Articulo t) {
                return t.getTipo().equals(tipo);
            }
        };
    }
    
    /**
     * Constructor para condiciones simples de Marca
     *
     * @param marca la marca a evaluar en el filtrado de la lista
     */
    public Condicion(String marca) {
        // expresión lambda equivalente:
        // predicado = (Articulo t) -> t.getMarca().equals(marca);
        predicado = new Predicate<Articulo>() {
            @Override
            public boolean test(Articulo t) {
                return t.getMarca().equals(marca);
            }
        };
    }
    
    /**
     * Constructor para condiciones simples de Precio
     *
     * @param precio el precio a evaluar en el filtrado de la lista
     */
    public Condicion(int precio) {
        // expresión lambda equivalente:
        // predicado = (Articulo t) -> t.getPrecio() < precio;
        predicado = new Predicate<Articulo>() {
            @Override
            public boolean test(Articulo t) {
                return t.getPrecio() < precio;
            }
        };
    }
    
    /**
     * Permite concatenar dos condiciones diferentes mediante un operador lógico AND
     *
     * @param c segunda condición a enlazar con el AND
     * @return la condición resultado del AND
     */
    public Condicion and(Condicion c) {
        return new Condicion(this.getPredicado().and(c.getPredicado()));
    }
    
    /**
     * Permite concatenar dos condiciones diferentes mediante un operador lógico OR
     *
     * @param c segunda condición a enlazar con el OR
     * @return la condición resultado del OR
     */
    public Condicion or(Condicion c) {
        return new Condicion(this.getPredicado().or(c.getPredicado()));
    }
    
    /**
     * Permite invertir la Condicion sobre la que se llama (this)
     *
     * @return la condición resultado del NOT
     */
    public Condicion not() {
        return new Condicion(this.getPredicado().negate());
    }

    // getter y setter para el predicado que almacena cada Condicion
    public Predicate<Articulo> getPredicado() {
        return predicado;
    }

    public void setPredicado(Predicate<Articulo> predicado) {
        this.predicado = predicado;
    }
}