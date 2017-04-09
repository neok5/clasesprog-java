package clasesprog.Excepciones;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;

/**
 * Clase que contiene los ejemplos de ejecución
 * para el tema de las excepciones en Java
 */
public class EjemplosExcep {

    /**
     * Método principal del paquete Excepciones (invocado desde el main)
     */
    public static void runExcepciones() {
        runEx1();
        System.out.println("********************************\n");
        runEx2();
        System.out.println("********************************\n");
        // debemos recoger la IOException que lanza runEx3, pero no hacemos nada con ella
        try {
            runEx3();
        } catch(Exception e) { }
        System.out.println("********************************\n");
        try { 
            runEx4();
        } catch(Exception e) { }
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    /**
     * Ejemplo de captura de excepciones simple (try, catch, finally)
     */
    private static void runEx1() {
        // operaciones normales de ejecución del programa
        // ...
        // ...
        // ...
        // fin de las operaciones normales del programa
        
        // ejecución de una porción de código susceptible de lanzar una excepción
        try {
            // el método sort lanzará un NullPointerException si recibe un null
            Collections.sort(null);
        }
        // bloque de código que tratará la excepción cuando la capture
        catch(Exception e) {
            System.out.println("Se ha capturado la excepción E:\n" + e);
        }
        // bloque opcional, que contiene instrucciones que se ejecutan siempre
        finally {
            System.out.println("Texto que se imprimirá siempre por pantalla.");
        }
        
        
        
        
        
        // ejecución SIN errores
        try {
            System.out.println("\nIntentamos ejecutar el bloque de instrucciones:");
            System.out.println("Instrucción 1.");
            System.out.println("Instrucción 2.");
            System.out.println("Instrucción 3, etc.");
        }
        catch (Exception e) {
            System.out.println("Instrucciones a ejecutar cuando se produce un error");
        }
        finally {
            System.out.println("Instrucciones a ejecutar siempre (con o sin errores)");
        }
        
        
        
        
        
        // ejecución CON errores
        try {
            System.out.println("\nIntentamos ejecutar el bloque de instrucciones:");
            System.out.println("Instrucción 1.");
            int n = Integer.parseInt("M"); //error forzado en tiempo de ejecución.
            System.out.println("Instrucción 2.");
            System.out.println("Instrucción 3, etc.");
        }
        catch (Exception e) {
            System.out.println("Instrucciones a ejecutar cuando se produce un error");
        }
        finally {
            System.out.println("Instrucciones a ejecutar siempre (con o sin errores)");
        }
        
        
        
        
        
        try {
            // el método sort lanzará un NullPointerException si recibe un null
            Collections.sort(null);
            
            // se lanzará una ArithmeticException (indicando que se intenta dividir / 0)
            int num = 5/0;
            
            // se accede fuera de sus límites, se lanzará ArrayIndexOutOfBoundsException
            String[] prueba = new String[5];
            // si el índice de acceso es > 4 || < 0, sale de los límites
            String cad = prueba[7];
        }
        // captura de una de las posibles excepciones, la del puntero null
        catch(NullPointerException npe) {
            // tratamiento específico que se hace si se captura una excepción concreta
            System.out.println("\nSe ha capturado la excepción NPE:\n" + npe);
        }
        // captura de otra posible excepción, una excepción aritmética al dividir / 0
        catch(ArithmeticException ae) {
            System.out.println("\nSe ha capturado la excepción AE:\n" + ae);
        }
        // captura de otra posible excepción, al acceder fuera de los límites de un array
        catch(ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("\nSe ha capturado la excepción AIOOBE:\n" + aioobe);
        }
        // se pueden poner varios bloques catch, uno detrás de otro, comenzando por
        // los más específicos, hasta las excepciones con mayor generalidad (Exception)
        catch(Exception e) {
            System.out.println("\nSe ha capturado la excepción E:\n" + e);
        } System.out.println();
    }

    /**
     * Ejemplo de lanzamiento y captura de excepciones simple (throw y throws)
     */
    private static void runEx2() {
        try {
            runEx2aux(0);
        }
        catch(Exception e) {
            System.out.println(e + "\n");
        }
    }
    
    /** 
     * Método auxiliar para el método runEx2(), que se encarga de ejecutar
     * una serie de acciones predefinidas, según el parámetro pasado.
     * Puede lanzar excepciones comprobadas, no comprobadas, o no hacer nada,
     * siempre mostrando antes por pantalla un mensaje con lo que va a hacer.
     * 
     * @param accion la acción que queremos ejecutar
     * @throws IOException si se selecciona la acción 3
     * @throws SQLException si se selecciona la acción 4
     * @throws Exception si se selecciona la acción 5 o 6 (sin o con mensaje)
     */
    private static void runEx2aux(int accion)
            throws IOException, SQLException, Exception {
 // private static void runEx2aux(int accion) thrwos Exception (opcional, pero no aconsejado)
        switch(accion) {
            case 0: System.out.println("No se hace nada.\n"); break;
            case 1: System.out.println("Se lanza una NullPointerException (no comprobada):");
                    throw new NullPointerException("Puntero a objeto nulo");
            case 2: System.out.println("Se lanza una ArithmeticException (no comprobada):");
                    throw new ArithmeticException("División entre 0 o desbordamiento");
            case 3: System.out.println("Se lanza una IOException (comprobada):");
                    throw new IOException("Fallo de E/S genérico");
            case 4: System.out.println("Se lanza una SQLException (comprobada):");
                    throw new SQLException("Fallo en cosulta SQL a database");
            case 5: System.out.println("Se lanza una Exception genérica sin mensaje (comprobada):");
                    throw new Exception();
            case 6: System.out.println("Se lanza una Exception genérica con mensaje (comprobada):");
                    throw new Exception("Excepción genérica");
            default: System.out.println("Valor no admitido.\n");
        }
    }

    /**
     * Ejemplo de uso con excepciones comprobadas y no comprobadas
     *
     * @throws IOException
     */
    private static void runEx3() throws IOException {
        // excepción no comprobada (no es necesario relanzarla ni declarar su lanzamiento)
        try {
            throw new NullPointerException();
        }
        catch(ArithmeticException e) {
            
        }
        
        // excepción comprobada, se debe capturar o relanzar (declarando su lanzamiento)
        try {
            throw new IOException();
        }
        catch(ArithmeticException e) {
            
        }
        
        // en ninguno de los dos try-catch estamos capturando realmente la excepción que lanzamos
        // (en el primero lanzamos NullPointerException y en el segundo IOException, y en
        //  ningún caso los capturamos, puesto que solo tenemos catch para ArithmeticExcepcion)
        
        // sin embargo, mientras que en el primero no se produce ningún error, en el caso del
        // segundo, debemos declarar el lanzamiento de la excepcion (throws IOException)
        // en la signatura del método, al tratarse de una excepción comprobada, cosa que
        // no ocurre ni se necesita para la excepción no comprobada de NullPointerException
    }

    /**
     * Ejemplo de creación de excepciones propias
     * (clases que extiendan Exception o de RuntimeException)
     *
     * @throws MiExcepcionComprobada
     */
    private static void runEx4() throws MiExcepcionComprobada {
        // similar al método anterior (runEx3) pero con excepciones propias
        
        // lanzamos nuestra excepción comprobada, debemos declarar su lanzamiento
        try {
            throw new MiExcepcionComprobada();
        }
        catch(ArithmeticException e) { System.out.println(e); }
        
        System.out.println();
        
        // lanzamos nuestra excepción no comprobada, no es necesario declarar el lanzamiento
        try {
            throw new MiExcepcionNoComprobada();
        }
        catch(ArithmeticException e) { System.out.println(e.getMessage()); }
    }
    
    /**
     * Clase de excepción comprobada nueva
     */
    static class MiExcepcionComprobada extends Exception {
        public MiExcepcionComprobada() {
            super("Necesito comprobación por parte del compilador.");
        }
    }
    
    /**
     * Clase de excepción no comprobada nueva
     */
    static class MiExcepcionNoComprobada extends RuntimeException {
        public MiExcepcionNoComprobada() {
            super("No necesito comprobación por parte del compilador.");
        }
    }
}