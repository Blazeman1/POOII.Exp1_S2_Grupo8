
package decorator;

/**
 * Clase CategoryDiscount que extiende de Decorator.
 * Esta clase aplica un descuento específico a una categoría de productos.
 * **/
public class CategoryDiscount extends Decorator {
    //Atributos
    private String targetCategory;
    private double discountPercent;

    /**
     * Constructor que recibe un componente(producto) para aplicar un porcentaje de descuento en base a una categoría concreta
     * @param component El componente a decorar.
     * @param targetCategory La categoría objetivo para el descuento.
     * @param discountPercent El porcentaje de descuento a aplicar.
     * */
    public CategoryDiscount(Component component, String targetCategory, double discountPercent){
        super(component);
        this.targetCategory = targetCategory;
        this.discountPercent = discountPercent;
    }

    // Métodos de la interfaz Component
    @Override
    public double getPrice(){
        double originalPrice = component.getPrice();
        if(component instanceof Product){
            Product product = (Product)component;
            if(product.getCategory().equalsIgnoreCase(targetCategory)){
                return originalPrice * (1 - discountPercent / 100);
            }
        }
        return originalPrice;
    }
    
    @Override
    public String getDescription(){
        if(component instanceof Product){
            Product product = (Product) component;
            if(product.getCategory().equalsIgnoreCase(targetCategory)){
                return component.getDescription() + " - " + discountPercent + "% descuento categoría";
            }
        }
        return component.getDescription();
    }
    
}
