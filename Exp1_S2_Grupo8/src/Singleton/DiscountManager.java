
package Singleton;

import Decorator.CategoryDiscount;
import Decorator.Component;
import Decorator.TenPercentDiscount;

public class DiscountManager {
    private static DiscountManager instance;
    
    private DiscountManager(){
        // Constructor privado para evitar instanciaci�n
    }
    
    public static DiscountManager getInstance(){
        if(instance == null){
            instance = new DiscountManager();
        }
        return instance;
    }
    
    // M�todos de instancia
    public Component applyGeneralDiscount(Component product){
        return new TenPercentDiscount(product);
    }
    
    public Component applyCategoryDiscount(Component product, String category, double discount){
        return new CategoryDiscount(product, category, discount);
    }
}
