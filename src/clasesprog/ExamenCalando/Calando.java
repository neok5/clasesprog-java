package clasesprog.ExamenCalando;

import java.util.*;
import clasesprog.ExamenCalando.Excepciones.*;

/**
 * Clase que representa la tienda online Calando
 */
public class Calando {
    // mapa de artículos del almacén, donde la referencia del
    // artículo actua como clave, y el Articulo como valor
    private final Map<String, Articulo> almacen;
    // mapa de usuarios registrados en el sistema, donde el email
    // es la clave, y el Usuario es el valor, en cada entrada
    private final Map<String, Usuario> usuarios;
    
    /**
     * Constructor básico para la Tienda (se puede omitir,
     * puesto que por defecto se crea el mismo)
     */
    public Calando() {
        this.almacen = new HashMap();
        this.usuarios = new HashMap();
    }
    
    /**
     * Incluye en el almacén el artículo de tipo Ropa especificado por los parámetros
     *
     * @param referencia del artículo a incluir
     * @param tipo del artículo a incluir
     * @param marca del artículo a incluir
     * @param precio del artículo a incluir
     * @param stock en el almacén del artículo a incluir
     * @param talla de la prenda de Ropa a incluir
     * @param composicion de la prenda de Ropa a incluir
     * @param temporada de la prenda de Ropa a incluir
     * @throws TipoException si el tipo no es uno de los admitidos (CAMISA, PANTALON, CHAQUETA)
     * @throws ArticuloRepetidoException en caso de que la referencia ya exista
     */
    public void addRopa(String referencia, Articulo.Tipo tipo, String marca, double precio,
            int stock, Ropa.Talla talla, Ropa.Composicion composicion, Ropa.Temporada temporada)
                                                throws TipoException, ArticuloRepetidoException {
        // si no es de uno de los tipos admitidos, lanza una excepción
        if(!(tipo == Articulo.Tipo.CAMISA
          || tipo == Articulo.Tipo.PANTALON
          || tipo == Articulo.Tipo.CHAQUETA))
            throw new TipoException();
        
        // si el artículo es repetido (misma referencia), lanza una excepción
        if(this.almacen.containsKey(referencia))
            throw new ArticuloRepetidoException();
        // y sino, no lanza la excepción y añade el artículo al almacén
        else
            this.almacen.put(referencia,
                new Ropa(referencia, tipo, marca, precio, stock, talla, composicion, temporada));
    }
    
    /**
     * Incluye en el almacén el artículo de tipo Ordenador especificado por los parámetros
     *
     * @param referencia del artículo a incluir
     * @param tipo del artículo a incluir
     * @param marca del artículo a incluir
     * @param precio del artículo a incluir
     * @param stock en el almacén del artículo a incluir
     * @param ram del Ordenador a incluir en el almacén
     * @param procesador del Ordenador a incluir en el almacén
     * @throws TipoException si el tipo no es uno de los admitidos (DESKTOP, LAPTOP)
     * @throws ArticuloRepetidoException en caso de que la referencia ya exista
     */
    public void addOrdenador(String referencia, Articulo.Tipo tipo, String marca, double precio,
                                    int stock, int ram, Ordenador.Procesador procesador)
                                                throws TipoException, ArticuloRepetidoException {
        // si no es de uno de los tipos admitidos, lanza una excepción
        if(!(tipo == Articulo.Tipo.DESKTOP || tipo == Articulo.Tipo.LAPTOP))
            throw new TipoException();
        
        // si el artículo es repetido (misma referencia), lanza una excepción
        if(this.almacen.containsKey(referencia))
            throw new ArticuloRepetidoException();
        // y sino, no lanza la excepción y añade el artículo al almacén
        else
            this.almacen.put(referencia,
                new Ordenador(referencia, tipo, marca, precio, stock, ram, procesador));
    }
    
    /**
     * Incluye en el almacén el artículo de tipo Electrodomestico especificado por los parámetros
     *
     * @param referencia del artículo a incluir
     * @param tipo del artículo a incluir
     * @param marca del artículo a incluir
     * @param precio del artículo a incluir
     * @param stock en el almacén del artículo a incluir
     * @param potencia del Electrodomestico a incluir en el almacén
     * @throws TipoException si el tipo no es uno de los admitidos (MICROONDAS, SECADOR, LAVADORA)
     * @throws ArticuloRepetidoException en caso de que la referencia ya exista
     */
    public void addElectrodomestico(String referencia, Articulo.Tipo tipo, String marca,
        double precio, int stock, int potencia) throws TipoException, ArticuloRepetidoException {
        // si no es de uno de los tipos admitidos, lanza una excepción
        if(!(tipo == Articulo.Tipo.MICROONDAS
          || tipo == Articulo.Tipo.SECADOR
          || tipo == Articulo.Tipo.LAVADORA))
            throw new TipoException();
        
        // si el artículo es repetido (misma referencia), lanza una excepción
        if(this.almacen.containsKey(referencia))
            throw new ArticuloRepetidoException();
        // y sino, no lanza la excepción y añade el artículo al almacén
        else
            this.almacen.put(referencia,
                new Electrodomestico(referencia, tipo, marca, precio, stock, potencia));
    }
    
    /**
     * Registra un nuevo usuario en el sistema (en la tienda)
     *
     * @param email del usuario a registrar (no podrá ser repetido)
     * @param password del usuario a registrar
     * @param direccion del usuario a registrar
     * @throws UsuarioRepetidoException en caso de que el email ya exista
     */
    public void addUser(String email, String password, String direccion)
                                        throws UsuarioRepetidoException {
        // si el email es repetido, lanza una excepción
        if(this.usuarios.containsKey(email))
            throw new UsuarioRepetidoException();
        // y sino, no lanza la excepción y añade el usuario
        else
            this.usuarios.put(email, new Usuario(email, password, direccion));
    }
    
    /**
     * Efectúa la compra de los artículos que el usuario ha metido en el carrito de la compra
     *
     * @param email del Usuario que está comprando
     * @param password del Usuario que está comprando
     * @param carrito con el conjunto de pedidos del Usuario que está comprando
     * @return el precio total de la compra, es decir, el importe de la factura
     * @throws UsuarioNotFoundException si el Usuario no está registrado en la Tienda
     * @throws UsuarioNotAuthorizedException si la contraseña del Usuario no es correcta
     * @throws ArticuloNotFoundException si el Articulo no existe en el almacén
     * @throws StockInsuficienteException si el stock del almacén es insuficiente para el Pedido
     */
    public int comprar(String email, String password, Set<Pedido> carrito)
                            throws UsuarioNotFoundException, UsuarioNotAuthorizedException,
                                        ArticuloNotFoundException, StockInsuficienteException {
        // variable que almacena el precio total de la compra
        int precio = 0;
        
        // si el Usuario no existe, se lanza una excepción
        if(!usuarios.containsKey(email))
            throw new UsuarioNotFoundException();
        
        // si la contraseña no existe, se lanza una excepción
        if(!usuarios.get(email).getPassword().equals(password))
            throw new UsuarioNotAuthorizedException();        
            
        // se comprueba que en el carrito no hay dos objetos Pedido con la misma referencia
        Set<String> auxRefRep = new HashSet();
        for(Pedido ped : carrito) {
            if(!auxRefRep.add(ped.getReferencia())) {
                System.out.println("ERROR - Carrito con referencias de Pedido repetidas.");
                return precio;
            }
        }
        
        // variable para almacenar la referencia de cada Pedido dentro del
        // bucle al crearla fuera, se ahorra memoria, no creándola e
        // inicializándola cada vez que haya una iteración del bucle
        String referencia;
        // de la misma forma para la cantidad de cada Pedido y el stock en el almacén
        int cantidad, stock;
        
        // recorremos el conjunto de Pedidos
        for(Pedido ped : carrito) {
            // al principio de cada iteración, extraemos la información del Pedido que toque
            referencia = ped.getReferencia();
            cantidad = ped.getCantidad();
            stock = this.almacen.get(referencia).getStock();
            
            // si no existe el Artículo referenciado por el Pedido, se lanza una expcepción
            if(!this.almacen.containsKey(referencia))
                throw new ArticuloNotFoundException(referencia);
            
            // si no queda stock en el almacén para ese artículo, se lanza una excepción
            if(stock < cantidad)
                throw new StockInsuficienteException(referencia);
            
            // si todo está correcto, procedemos a hacer efectiva la compra
            // restamos la cantidad correspondiente de cada Pedido en el almacén
            this.almacen.get(referencia).setStock(stock - cantidad);
            // obtenemos el importe de la factura (el precio total)
            precio += cantidad*this.almacen.get(referencia).getPrecio();
        }
        
        // devolvemos el precio como valor final de la compra
        return precio;
    }
    
    /**
     * Imprime por pantalla todos los artículos existentes en el almacén, junto con sus detalles
     * Los artículos se mostrarán ordenados por tipo, marca y precio (ascendentemente, menor a mayor)
     */
    public void visualizar() {
        // obtenemos la lista de Articulo(s) del almacén
        List<Articulo> aux = new ArrayList(this.almacen.values());
        // creamos un comparador de artículos (externo) y lo usamos para ordenar
        // los artículos según tipo, marca y precio (respectivamente)
        ComparadorArticulos comp = new ComparadorArticulos();
        Collections.sort(aux, comp);
        
        // listamos por pantalla todos los Articulo(s) ordenados
        for(Articulo a : aux) {
            System.out.println(a + "\n");
        }
    }
    
    /**
     * Devuelve una colección de artículos que cumplen una determinada condición
     *
     * @param c condición que se le pasa al método para filtrar
     * @return la colección de artículos que cumplan dicha condición
     */
    public Collection<Articulo> filtrar(Condicion c) {
        // creamos una lista auxiliar para los artículos del almacén, para no modificar la original
        List<Articulo> articulosFiltrados = new ArrayList(this.almacen.values());
        
        // invertimos la condición original, puesto que removeIf lo que hace
        // es eliminar de la lista aquellos que cumplen la condición, manteniendo
        // los que no la cumplen, y precisamente nos interesa justo lo contrario
        c.setPredicado(c.getPredicado().negate());
        // eliminamos aquellos que cumplan la condición invertida (no cumplen la original)
        articulosFiltrados.removeIf(c.getPredicado());
        
        // devolvemos la lista de artículos filtrados final
        return articulosFiltrados;
    }
}