
package command.discounts;

import command.Command;
import decorator.Component;
import decorator.TenPercentDiscount;

/**
 * Comando para aplicar un descuento general del 10% a un producto.
 * Implementa la interfaz Command.
 * */
public class ApplyGeneralDiscountCommand implements Command {
    // Atributos
    private Component product;
    private Component originalProduct;

    /**
     * Constructor que inicializa el comando con el producto al que se le aplicará el descuento.
     * @param product Producto al que se le aplicará el descuento.
     * */
    public ApplyGeneralDiscountCommand(Component product){
        this.product = product;
        this.originalProduct = product;
    }

    // Getters
    /**
     * Obtiene el producto actual con el descuento aplicado.
     * @return Producto con el descuento aplicado.
     * */
    public Component getProduct(){
        return product;
    }

    // Implementación de los métodos de la interfaz Command
    @Override
    public void ejecutar(){
        // aplicamos el decorador de 10%
        product = new TenPercentDiscount(originalProduct);
        System.out.println("Descuento general aplicado: " + product.getDescription());
    }

    @Override
    public void deshacer(){
        product = originalProduct;
        System.out.println("Descuento general removido");
    }

}
