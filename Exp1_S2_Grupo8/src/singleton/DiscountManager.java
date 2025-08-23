
package singleton;

import decorator.CategoryDiscount;
import decorator.Component;
import decorator.TenPercentDiscount;

/**
 * Clase DiscountManager que implementa el patrón Singleton.
 * Esta clase gestiona la aplicación de descuentos a productos.
 *
 * */
public class DiscountManager {
    private static DiscountManager instance;

    /**
     * Constructor privado para evitar instanciación externa.
     * */
    private DiscountManager(){
        // Constructor privado para evitar instanciaci�n
    }

    /**
     * Método para obtener la instancia única de DiscountManager.
     * */
    public static DiscountManager getInstance(){
        if(instance == null){
            instance = new DiscountManager();
        }
        return instance;
    }
    
    // Métodos de instancia
    /**
     * Método de instancia para aplicar un descuento general del 10% a un producto.
     * @param product El producto al que se le aplicará el descuento.
     * @return El producto con el descuento aplicado.
     * */
    public Component applyGeneralDiscount(Component product){
        return new TenPercentDiscount(product);
    }

    /**
     * Método de instancia para aplicar un descuento específico a una categoría de productos.
     * @param product El producto al que se le aplicará el descuento.
     * @param category La categoría a la que pertenece el producto.
     * @param discount El porcentaje de descuento a aplicar.
     * @return El producto con el descuento aplicado.
     * */
    public Component applyCategoryDiscount(Component product, String category, double discount){
        return new CategoryDiscount(product, category, discount);
    }
}
