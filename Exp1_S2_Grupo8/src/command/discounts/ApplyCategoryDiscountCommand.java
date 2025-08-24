
package command.discounts;

import command.Command;
import decorator.CategoryDiscount;
import decorator.Component;

/**
 * Comando para aplicar un descuento por categoria a un producto.
 * Implementa la interfaz Command.
 * */
public class ApplyCategoryDiscountCommand implements Command {
    // Atributos
    private Component product;
    private final Component originalProduct;
    private final String category;
    private final double discount;

    /**
     * Constructor del comando.
     * @param product Producto al que se le aplicara el descuento.
     * @param category Categoria a la que se le aplicara el descuento.
     * @param discount Porcentaje de descuento a aplicar (0.0 - 1.0).
     * */
    public ApplyCategoryDiscountCommand(Component product, String category, double discount){
        this.originalProduct = product;
        this.product = product;
        this.category = category;
        this.discount = discount;
    }

    // Getters
    /**
     * Obtiene el producto con el descuento aplicado.
     * @return Producto con el descuento aplicado.
     * */
    public Component getProduct(){
        return product;
    }

    // Metodos de la interfaz Command
    @Override
    public void ejecutar() {
        // Aplicar el decorador de categoria
        product = new CategoryDiscount(originalProduct, category, discount);
        System.out.println("Descuento de categoria aplicado: " + product.getDescription());
    }

    @Override
    public void deshacer() {
        product = originalProduct;
        System.out.println("Descuento de categoria removido: " + product.getDescription());
    }

}
