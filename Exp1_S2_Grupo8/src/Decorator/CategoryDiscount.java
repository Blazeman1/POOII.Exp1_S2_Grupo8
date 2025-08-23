
package Decorator;

public class CategoryDiscount extends Decorator {
    private String targetCategory;
    private double discountPercent;
    
    public CategoryDiscount(Component component, String targetCategory, double discountPercent){
        super(component);
        this.targetCategory = targetCategory;
        this.discountPercent = discountPercent;
    }
    
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
