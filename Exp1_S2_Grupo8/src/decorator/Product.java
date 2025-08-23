
package decorator;

/**
 * Clase Product que implementa la interfaz Component.
 * Esta clase representa un producto con un nombre, precio base y categoría.
 * */
public class Product implements Component {
    //Atributos
    private String name;
    private double basePrice;
    private String category;

    /**
     * Constructor de la clase Product.
     * @param name El nombre del producto.
     * @param basePrice El precio base del producto.
     * @param category La categoría del producto.
     * */
    public Product(String name, double basePrice, String category){
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
    }

    public String getCategory(){
        // Getters
        return category;
    }

    // Métodos de la interfaz Component
    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String getDescription() {
        return name + " : $" + String.format("%.2f", basePrice) + " (" + category + ")";
    }
}
