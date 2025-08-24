package command;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase invocadora para el carrito de compras.
 * */
public class CartInvoker {
    /**
     * Lista de comandos a ejecutar o deshacer.
     * */
    private List<Command> commands = new ArrayList<>();

    /**
     * Agrega un comando a la lista de comandos.
     * @param command Comando a agregar.
     * */
    public void addCommand(Command command){
        commands.add(command);
    }

    /**
     * Ejecuta todos los comandos en el orden en que fueron agregados.
     * */
    public void ejecutarComandos(){
        for(Command command:commands){
            command.ejecutar();
        }
    }

    /**
     * Deshace todos los comandos en orden inverso al que fueron agregados.
     * */
    public void deshacerComandos(){
        for(int i = commands.size() - 1; i >= 0; i--){
            commands.get(i).deshacer();
        }
    }
}
