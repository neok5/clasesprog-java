package clasesprog.Interfaces.Comparadores;

import java.util.Comparator;

public class ComparadorFechas implements Comparator<Fecha>{

    @Override
    public int compare(Fecha o1, Fecha o2) {
        // variable resultado, para tener 1 sola sentencia return, al final
        // se inicializa al resultado por defecto (0)
        int resultado = 0;
        // si el año es menor, el elemento this es menor
        if(o1.getYear() < o2.getYear())
            resultado = -1;
        // si el año es mayor, el this es mayor que el parámetro
        else if(o1.getYear() > o2.getYear())
            resultado = 1;
        // si los años son iguales, se pasa a comparar los meses y años
        else {
            if (o1.getMonth() < o2.getMonth()) {
                resultado = -1;
            } else if (o1.getMonth() > o2.getMonth()) {
                resultado = 1;
            } else { // los años y meses son iguales, se pasa a comparar días
                if (o1.getDay() < o2.getDay()) {
                    resultado = -1;
                } else if (o1.getDay() > o2.getDay()) {
                    resultado = 1;
                }
            }
        }
        // si son iguales en año, mes y día, son iguales en todo, devuelve 0
        return resultado;
    }
}