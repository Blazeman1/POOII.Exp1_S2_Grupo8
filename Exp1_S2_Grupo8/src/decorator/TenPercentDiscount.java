
package decorator;

/**
 * Clase TenPercentDiscount que extiende de Decorator.
 * Esta clase aplica un descuento general del 10% al precio de un producto.
 * */
public class TenPercentDiscount extends Decorator{
    /**
     * Constructor que recibe un componente(producto) para decorar(añadir funcionalidades).
     * @param component El componente a decorar.
     * */
    public TenPercentDiscount(Component component){
        super(component);
    }

    // Métodos de la interfaz Component
    @Override
    public double getPrice(){
        return component.getPrice() * 0.9;
    }
    
    @Override
    public String getDescription(){
        return component.getDescription() + " - 10% descuento general";
    }
}
