package command.cart;

import command.Command;
import decorator.Component;
import java.util.ArrayList;
import java.util.List;
import singleton.CarritoCompras;

/**
 * Comando para comprar los productos del carrito.
 */
public class BuyCartCommand implements Command {
    //Atributos
    private final CarritoCompras carrito;
    private List<Component> productosComprados;

    /**
     * Constructor para el comando de comprar productos del carrito.
     */
    public BuyCartCommand() {
        this.carrito = CarritoCompras.getInstance();
    }

    // Método para ejecutar el comando
    @Override
    public void ejecutar() {
        // Verificar si el carrito está vacío
        if(carrito.getProductos().isEmpty()){
            System.out.println("No hay productos en el carrito para comprar.");
            return;
        }
        // Guardar los productos comprados antes de vaciar el carrito
        productosComprados = new ArrayList<>(carrito.getProductos());

        // Simular el proceso de compra
        double total = carrito.calcularTotal();
        System.out.println("Compra realizada.");
        carrito.toString();
        System.out.println("Total pagado: $"+ String.format("%.2f",total));

        // Vaciar el carrito después de la compra
        carrito.vaciarCarrito();
    }

    // Método para deshacer el comando
    @Override
    public void deshacer() {
        if (productosComprados != null && !productosComprados.isEmpty()) {
            for (Component producto : productosComprados) {
                carrito.agregarProducto(producto);
            }
            System.out.println("La compra ha sido cancelada y los productos restaurados al carrito");
        } else {
            System.out.println("No hay compra para deshacer");
        }
    }
}
