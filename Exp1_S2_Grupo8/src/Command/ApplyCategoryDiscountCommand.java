
package Command;

import Decorator.CategoryDiscount;
import Decorator.Component;

public class ApplyCategoryDiscountCommand implements Command{
    private Component product;
    private final Component originalProduct;
    private final String category;
    private final double discount;
    
    public ApplyCategoryDiscountCommand(Component product, String category, double discount){
        this.originalProduct = product;
        this.product = product;
        this.category = category;
        this.discount = discount;
    }

    @Override
    public void ejecutar() {
        // Aplicar el decorador de categoria
        product = new CategoryDiscount(originalProduct, category, discount);
        System.out.println("Descuento de categoria aplicado: " + product.getDescription());
    }

    @Override
    public void deshacer() {
        product = originalProduct;
        System.out.println("Descuento de categoría removido: " + product.getDescription());
    }
    
    public Component getProduct(){
        return product;
    }
}
