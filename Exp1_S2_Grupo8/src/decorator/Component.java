
package decorator;

/**
 * Interfaz Component que define los métodos para obtener el precio y la descripción de un producto.
 * */
public interface Component {
    /**
     * Método para obtener el precio del producto decorado.
     * @return El precio del producto decorado.
     * */
    double getPrice();

    /**
     * Método para obtener la descripción del producto decorado.
     * @return La descripción del producto decorado.
     * */
    String getDescription();
}
