package command.cart;

import command.Command;
import decorator.Component;
import singleton.CarritoCompras;

/**
 * Comando para agregar un producto al carrito.
 */
public class AddProductCommand implements Command {
    // Atributos
    private final Component producto;
    private final CarritoCompras carritoCompras;

    /**
     * Constructor para el comando de agregar producto al carrito.
     * @param producto El producto a agregar al carrito.
     */
    public AddProductCommand(Component producto){
        this.producto = producto;
        this.carritoCompras = CarritoCompras.getInstance();
    }

    // Método para ejecutar el comando
    @Override
    public void ejecutar() {
        carritoCompras.agregarProducto(producto);
        System.out.println("Producto agregado: " + producto.getDescription());
    }

    // Método para deshacer el comando
    @Override
    public void deshacer() {
        carritoCompras.eliminarProducto(producto);
        System.out.println("Producto removido: " + producto.getDescription());
    }
}
