
package command;

/**
 * Interfaz Command para implementar el patrón Command.
 * Define los métodos ejecutar y deshacer que deben ser implementados por las clases concretas de comando.
 * */
public interface Command {
    /**
     * Ejecuta la acción del comando.
     * @void
     * */
    void ejecutar();
    /**
     * Deshace la acción del comando.
     * @void
     * */
    void deshacer();
}
