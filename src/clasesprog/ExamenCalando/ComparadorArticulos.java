package clasesprog.ExamenCalando;

import java.text.Collator;
import java.util.Comparator;

/**
 * Comparador externo, creado para ordenar la lista de artículos
 * por tipo, marca y precio, y mostrarla luego por pantalla
 */
public class ComparadorArticulos implements Comparator<Articulo> {

    @Override
    public int compare(Articulo a, Articulo b) {
        // almacena el resultado global de la comparación de los artículos
        // se inicializa a 0, porque si son exactamente iguales, es lo que devuelve
        int resultado = 0;
        
        // comparador lexicográfico para el tipo y marcas de los artículos
        Collator comp = Collator.getInstance();
        // resultado de la comparación de los tipos (lexicográficamente)
        // los Tipos, al ser Enumerados, hay que transformarlos a String
        // puesto que lo que espera el Collator es comparar String
        int resTipo = comp.compare(a.getTipo().toString(), b.getTipo().toString());
        
        // si el Tipo es menor (alfabéticamente) o mayor, se devuelve que
        // el primer Articulo es menor o mayor que el segundo Articulo
        if(resTipo < 0)
            resultado = -1;
        else if(resTipo > 0)
            resultado = 1;
        // si ambos son del mismo tipo, se pasa a comparar la marca y precio
        else {
            // resultado de la comparación de las marcas (lexicográficamente)
            int resMarca = comp.compare(a.getMarca(), b.getMarca());
            
            // si la Marca es menor (alfabéticamente) o mayor, se devuelve que
            // el primer Articulo es menor o mayor que el segundo Articulo
            if(resMarca < 0)
                resultado = -1;
            else if(resMarca > 0)
                resultado = 1;
            // si ambos son también de la misma marca, se pasa a comparar el precio
            else {
                if(a.getPrecio() < b.getPrecio())
                    resultado = -1;
                else if(a.getPrecio() > b.getPrecio())
                    resultado = 1;
            }
        }
        // si son del mismo tipo, marca y precio se devuelve 0, y en
        // caso contrario se devuelve que uno es menor o mayor que el otro
        return resultado;
    }
}