
package Singleton;

import Decorator.CategoryDiscount;
import Decorator.Component;
import Decorator.TenPercentDiscount;

public class DiscountManager {
    private static DiscountManager instance;
    
    private DiscountManager(){
        // Constructor privado para evitar instanciación
    }
    
    public static DiscountManager getInstance(){
        if(instance == null){
            instance = new DiscountManager();
        }
        return instance;
    }
    
    // Métodos de instancia
    public Component applyGeneralDiscount(Component product){
        return new TenPercentDiscount(product);
    }
    
    public Component applyCategoryDiscount(Component product, String category, double discount){
        return new CategoryDiscount(product, category, discount);
    }
}
