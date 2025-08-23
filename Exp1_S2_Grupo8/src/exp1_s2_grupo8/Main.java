
package exp1_s2_grupo8;

import command.ApplyCategoryDiscountCommand;
import command.ApplyGeneralDiscountCommand;
import command.Command;
import command.DiscountInvoker;
import decorator.Component;
import decorator.Product;
import singleton.DiscountManager;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n  --- Sistema de Descuentos en Tienda de Ropa ---\n");
        
        // Crear productos
        Component camisa = new Product("Camisa", 15000, "Camisas");
        Component pantalon = new Product("Pantalón Jeans", 80000, "Pantalones");
        Component vestido = new Product("Vestido Negro", 120000, "Vestidos");
        
        System.out.println("Productos originales:");
        System.out.println(camisa.getDescription());
        System.out.println(pantalon.getDescription());
        System.out.println(vestido.getDescription());
        System.out.println();
        
        // Usar Singleton DiscountManager
        DiscountManager discountManager = DiscountManager.getInstance();
        
        // Aplicar descuentos usando los métodos Singleton
        Component camisaConDescuento = discountManager.applyGeneralDiscount(camisa);
        Component pantalonConDescuento = discountManager.applyCategoryDiscount(pantalon, "Pantalones", 15.0);
        Component vestidoConDescuento = discountManager.applyGeneralDiscount(vestido);
        
        System.out.println("Productos con descuentos (Singleton): ");
        System.out.println(camisaConDescuento.getDescription());
        System.out.println(pantalonConDescuento.getDescription());
        System.out.println(vestidoConDescuento.getDescription());
        System.out.println();
        
        // Mostrar comparación de precios
        System.out.println("  --- Comparación de Precios ---");
        System.out.println("Camisa - Original: $" + camisa.getPrice()+ " | Con Descuento: $" + camisaConDescuento.getPrice());
        System.out.println("Pantalon - Original: $" + pantalon.getPrice() + " | Con Descuento: $" + pantalonConDescuento.getPrice());
        System.out.println("Vestido - Original: $" + vestido.getPrice() + " | Con Descuento: $" + vestidoConDescuento.getPrice());
        System.out.println();
        
        // Usar el patr�n Command
        System.out.println("Aplicando descuentos con Command Pattern: ");
        
        Command descuentoGeneral = new ApplyGeneralDiscountCommand(camisa);
        Command descuentoCategoria = new ApplyCategoryDiscountCommand(pantalon, "Pantalones", 20.0);
        Command descuentoVestido = new ApplyCategoryDiscountCommand(vestido, "Vestidos", 25.0);
        
        // Ejecutar comandos
        descuentoGeneral.ejecutar();
        descuentoCategoria.ejecutar();
        descuentoVestido.ejecutar();
        System.out.println();
        
        // Probar funcionalidad de deshacer
        System.out.println("  --- Probando Funcionalidad Deshacer ---");
        descuentoGeneral.deshacer();
        descuentoCategoria.deshacer();
        
        // Probando el Invoker
        System.out.println("\n  --- Usando Invoker: ");
        DiscountInvoker invoker = new DiscountInvoker();
        
        // Crear nuevos productos para el invoker
        Component chaqueta = new Product("Chaqueta de Cuero", 200000.0 , "Chaquetas");
        Component falda = new Product("Falda Larga", 70000.0 , "Faldas");
        
        // Agregar comandos al invoker
        invoker.addCommand(new ApplyGeneralDiscountCommand(chaqueta));
        invoker.addCommand(new ApplyCategoryDiscountCommand(falda, "Faldas", 25.0));
        
        // Ejecutar todos los comandos del invoker
        invoker.ejecutarComandos();
        System.out.println();
        
        // Mostrar resumen final
        System.out.println("  --- Resumen Final ---");
        System.out.println("Todos los descuentos aplicados correctamente!");;
        System.out.println("Sistema funcinando con: ");
        System.out.println(" - Singleton Pattern");
        System.out.println(" - Decorator Pattern");
        System.out.println(" - Command Pattern");
        System.out.println();
        
        
        
    }
    
}
