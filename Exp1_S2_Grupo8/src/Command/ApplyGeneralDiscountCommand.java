
package Command;

import Decorator.Component;
import Decorator.TenPercentDiscount;

public class ApplyGeneralDiscountCommand implements Command{
    private Component product;
    private Component originalProduct;
    
    public ApplyGeneralDiscountCommand(Component product){
        this.product = product;
        this.originalProduct = product;
    }
    
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
    
    public Component getProduct(){
        return product;
    }
}
