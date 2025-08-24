package command.cart;

import command.Command;
import decorator.Component;
import singleton.CarritoCompras;

/**
 * Comando para eliminar un producto del carrito.
 */
public class DeteleProductCommand implements Command {

    // Atributos
    private final Component producto;
    private final CarritoCompras carrito;
    private boolean wasRemoved;

    /**
     * Constructor para el comando de eliminar producto del carrito.
     * @param producto El producto a eliminar del carrito.
     */
    public DeteleProductCommand(Component producto) {
        this.producto = producto;
        this.carrito = CarritoCompras.getInstance();
    }

    // Método para ejecutar el comando
    @Override
    public void ejecutar() {
        wasRemoved = carrito.eliminarProducto(producto);
        if(wasRemoved) {
            System.out.println("Producto eliminado: " + producto.getDescription());
        } else {
            System.out.println("El producto no se encontró en el carrito: " + producto.getDescription());
        }
    }

    // Método para deshacer el comando
    @Override
    public void deshacer() {
        if(wasRemoved) {
            carrito.agregarProducto(producto);
            System.out.println("Producto restaurado: " + producto.getDescription());
        } else {
            System.out.println("No se puede restaurar el producto ya que no fue eliminado: " + producto.getDescription());
        }
    }
}
