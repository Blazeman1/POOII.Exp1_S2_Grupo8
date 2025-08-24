package singleton;

import decorator.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase CarritoCompras que implementa el patrón Singleton.
 * Esta clase gestiona los productos en el carrito de compras.
 * **/
public class CarritoCompras {
    private static CarritoCompras instance;
    private final List<Component> productos;

    /**
     * Constructor privado para evitar instanciación externa.
     * */
    private CarritoCompras(){
        this.productos = new ArrayList<>();
    }

    /**
     * Método para obtener la instancia única de CarritoCompras.
     * */
    public static synchronized CarritoCompras getInstance(){
        if(instance == null){
            instance = new CarritoCompras();
        }
        return instance;
    }

    // Métodos de instancia
    /**
     * Método de instancia para agregar un producto al carrito de compras.
     * @param producto El producto a agregar al carrito de compras.
     * */
    public void agregarProducto(Component producto){
        productos.add(producto);
    }

    /**
     * Método de instancia para eliminar un producto del carrito de compras.
     * @param producto El producto a eliminar del carrito de compras.
     * */
    public boolean eliminarProducto(Component producto){
        return productos.remove(producto);
    }

    /**
     * Método de instancia para obtener la lista de productos en el carrito de compras.
     * @return La lista de productos en el carrito de compras.
     * */
    public List<Component> getProductos(){
        return productos;
    }


    /**
     * Método de instancia para calcular el total del carrito de compras.
     * @return El total del carrito de compras.
     * */
    public double calcularTotal(){
        return productos.stream().mapToDouble(Component::getPrice).sum();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Carrito de compra:\n");
        if(productos.isEmpty()){
            sb.append("\nEl carrito está vacío.\n");
        } else {
            productos.forEach(p -> sb.append(" - ").append(p.getDescription()).append("\n"));
            sb.append("Total: $").append(String.format("%.2f", calcularTotal()));
        }
        return sb.toString();
    }


    /**
     * Metodo de instancia para vaciar el carrito de compras.
     * */
    public void vaciarCarrito() {
        productos.clear();
    }
}
