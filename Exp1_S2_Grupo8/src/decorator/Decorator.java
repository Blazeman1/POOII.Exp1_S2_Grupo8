
package decorator;

/**
 *
 * Clase abstracta Decorator que implementa la interfaz Component.
 * Esta clase sirve como base para todos los decoradores que añaden funcionalidades a los productos.
 *
 **/
public abstract class Decorator implements Component {
    protected Component component;

    /**
     * Constructor que recibe un componente(producto) para decorar(añadir funcionalidades).
     * @param component El componente a decorar.
     * */
    public Decorator(Component component){
        this.component = component;
    }

    // Métodos de la interfaz Component
    @Override
    public double getPrice(){
        return component.getPrice();
    }

    @Override
    public String getDescription(){
        return component.getDescription();
    }
}