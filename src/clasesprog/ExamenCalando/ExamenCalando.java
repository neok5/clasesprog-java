package clasesprog.ExamenCalando;

import clasesprog.ExamenCalando.Excepciones.ArticuloNotFoundException;
import clasesprog.ExamenCalando.Excepciones.ArticuloRepetidoException;
import clasesprog.ExamenCalando.Excepciones.StockInsuficienteException;
import clasesprog.ExamenCalando.Excepciones.TipoException;
import clasesprog.ExamenCalando.Excepciones.UsuarioNotAuthorizedException;
import clasesprog.ExamenCalando.Excepciones.UsuarioNotFoundException;
import clasesprog.ExamenCalando.Excepciones.UsuarioRepetidoException;
import java.util.HashSet;
import java.util.Set;

/**
 * Solución examen Calando 2015
 */
public class ExamenCalando {

    /**
     * Método principal llamado desde el main,
     * para ejecutar pruebas sobre la tienda Calando
     */
    public static void runCalando() {
        // creamos una Tienda inicial, común a todos los subMétodos
        Calando tiendaCalando = new Calando();
        // y la pasamos como parámetro a cada uno de ellos
        try {
            runCa1(tiendaCalando);
            System.out.println("********************************\n");
            runCa2(tiendaCalando);
            System.out.println("********************************\n");
            runCa3(tiendaCalando);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println(
                    "*** FIN DE LA DEMO DE EJECUCIÓN 'Calando' ***\n\n\n\n\n\n\n\n\n\n");
        }
    }

    /**
     * Ejemplo de uso para añadir artículos al almacén
     * de la Tienda, y mostrarlos por pantalla ordenados
     *
     * @param t Tienda general para todas las pruebas
     */
    private static void runCa1(Calando t) throws TipoException, ArticuloRepetidoException {
        // añadimos varios Articulo(s) al almacén de la Tienda
        t.addRopa("10", Articulo.Tipo.CAMISA, "Armani", 70, 500,
                Ropa.Talla.L, Ropa.Composicion.ALGODON, Ropa.Temporada.FW);
        t.addRopa("12", Articulo.Tipo.CHAQUETA, "Armani", 150, 230,
                Ropa.Talla.L, Ropa.Composicion.ALGODON, Ropa.Temporada.FW);
        t.addElectrodomestico(
                "30", Articulo.Tipo.LAVADORA, "Whirpool", 300, 800, 700);
        t.addOrdenador("20", Articulo.Tipo.LAPTOP, "Lenovo", 900, 80,
                16, Ordenador.Procesador.INTEL_i5);
        t.addElectrodomestico(
                "32", Articulo.Tipo.SECADOR, "Rowenta", 30, 450, 200);
        t.addRopa("14", Articulo.Tipo.CAMISA, "Ralph Lauren", 90, 420,
                Ropa.Talla.S, Ropa.Composicion.LANA, Ropa.Temporada.SS);
        t.addOrdenador("21", Articulo.Tipo.DESKTOP, "HP", 1200, 40,
                32, Ordenador.Procesador.INTEL_i7);
        t.addRopa("11", Articulo.Tipo.PANTALON, "Emidio Tucci", 230, 800,
                Ropa.Talla.L, Ropa.Composicion.ACRILICO, Ropa.Temporada.SS);
        t.addElectrodomestico(
                "31", Articulo.Tipo.MICROONDAS, "Balay", 50, 5000, 30);

        // los mostramos por pantalla
        t.visualizar();
    }

    /**
     * Ejemplo de uso para registrar algún Usuario en la Tienda,
     * y más tarde realizar una compra creando un carrito con Pedido(s)
     *
     * @param t Tienda general para todas las pruebas
     */
    private static void runCa2(Calando t) throws UsuarioRepetidoException, UsuarioNotFoundException,
            UsuarioNotAuthorizedException, ArticuloNotFoundException, StockInsuficienteException {
        // añádimos 3 Usuario(s) a la Tienda
        t.addUser("user2@gmail.com", "pass123", "Calle Falsa, 23, Murcia");
        t.addUser("user1@hotmail.com", "pass123", "Calle Hey!, 40, Guadalajara");
        t.addUser("user3@yahoo.es", "pass123", "Calle Avenida, 99, Albacete");
        
        // creamos un carrito de la compra
        Set<Pedido> carrito = new HashSet();
        carrito.add(new Pedido("31", 3));
        carrito.add(new Pedido("21", 1));
        carrito.add(new Pedido("14", 4));
        // e intentamos realizar una compra
        int precioTotal = t.comprar("user2@gmail.com", "pass123", carrito);
        
        // listamos las referencias y cantidades de los
        // artículos adquiridos, asi como el precio total
        System.out.println("Se han adquirido los siguientes artículos:\n");
        for(Pedido p : carrito)
            System.out.println(
                    p.getCantidad() + " artículo(s) con referencia '" + p.getReferencia() + "'.");
        
        System.out.println("\nEl precio total de la compra es de " + precioTotal + " €.\n");
    }

    /**
     * Ejemplo de uso para realizar una búsqueda filtrada
     * de algunos Articulo(s) en el almacén de la Tienda
     *
     * @param t Tienda general para todas las pruebas
     */
    private static void runCa3(Calando t) {
        // buscamos artículos que sean de la marca 'Armani'
        System.out.println("### Artículos de la marca 'Armani':\n");
        for(Articulo a : t.filtrar(new Condicion("Armani")))
            System.out.println(a + "\n");
        
        // buscamos artículos que sean del tipo 'Camisa'
        System.out.println("### Artículos del tipo 'Camisa':\n");
        for(Articulo a : t.filtrar(new Condicion(Articulo.Tipo.CAMISA)))
            System.out.println(a + "\n");
        
        // buscamos artículos que tengan un precio inferior a 100 €
        System.out.println("### Artículos con un precio inferior a 100€:\n");
        for(Articulo a : t.filtrar(new Condicion(100)))
            System.out.println(a + "\n");
        
        // buscamos artículos de la marca 'Armani' que tengan un precio inferior a 100 €
        System.out.println("### Artículos 'Armani' con un precio inferior a 100€:\n");
        for(Articulo a : t.filtrar(new Condicion("Armani").and(new Condicion(100))))
            System.out.println(a + "\n");
        
        // buscamos Ordenadores que tengan un precio inferior a 950 €
        System.out.println("### Ordenadores con un precio inferior a 950€:\n");
        for(Articulo a : t.filtrar(new Condicion(Articulo.Tipo.DESKTOP).or(
                new Condicion(Articulo.Tipo.LAPTOP)).and(new Condicion(950))))
            System.out.println(a + "\n");
        
        // buscamos Ordenadores que tengan un precio inferior a 100 €
        System.out.println("### Ordenadores con un precio inferior a 100€:\n");
        for(Articulo a : t.filtrar(new Condicion(Articulo.Tipo.DESKTOP).or(
                new Condicion(Articulo.Tipo.LAPTOP)).and(new Condicion(100))))
            System.out.println(a + "\n");
    }
}