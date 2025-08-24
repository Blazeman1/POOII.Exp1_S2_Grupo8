package demo;

import command.Command;
import command.DiscountInvoker;
import command.discounts.ApplyCategoryDiscountCommand;
import command.discounts.ApplyGeneralDiscountCommand;
import decorator.Component;
import decorator.Product;
import singleton.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n  --- Sistema de Descuentos en Tienda de Ropa ---\n");

        // Crear productos
        Component camisa = new Product("Camisa", 15000, "Camisas");
        Component pantalon = new Product("Pantalón Jeans", 80000, "Pantalones");
        Component vestido = new Product("Vestido Negro", 120000, "Vestidos");
        Component zapatos = new Product("Zapatos Deportivos", 45000, "Calzado");

        DiscountManager discountManager = DiscountManager.getInstance();
        CarritoCompras carrito = CarritoCompras.getInstance();

        // Mostrar productos originales
        System.out.println("Productos originales:");
        System.out.println(camisa.getDescription());
        System.out.println(pantalon.getDescription());
        System.out.println(vestido.getDescription());
        System.out.println();

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
        System.out.println("Camisa - Original: $" + camisa.getPrice() + " | Con Descuento: $" + camisaConDescuento.getPrice());
        System.out.println("Pantalon - Original: $" + pantalon.getPrice() + " | Con Descuento: $" + pantalonConDescuento.getPrice());
        System.out.println("Vestido - Original: $" + vestido.getPrice() + " | Con Descuento: $" + vestidoConDescuento.getPrice());
        System.out.println();

        // Usar el patrón Command
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
        Component chaqueta = new Product("Chaqueta de Cuero", 200000.0, "Chaquetas");
        Component falda = new Product("Falda Larga", 70000.0, "Faldas");

        // Agregar comandos al invoker
        invoker.addCommand(new ApplyGeneralDiscountCommand(chaqueta));
        invoker.addCommand(new ApplyCategoryDiscountCommand(falda, "Faldas", 25.0));

        // Ejecutar todos los comandos del invoker
        invoker.ejecutarComandos();
        System.out.println();

        // --- Pruebas de funcionalidades del carrito ---
        System.out.println("  --- Pruebas de Carrito de Compras (Command Pattern) ---");

        // Agregar productos al carrito
        Command addCamisa = new command.cart.AddProductCommand(camisa);
        Command addPantalon = new command.cart.AddProductCommand(pantalon);
        Command addVestido = new command.cart.AddProductCommand(vestido);

        addCamisa.ejecutar();
        addPantalon.ejecutar();
        addVestido.ejecutar();

        // Eliminar un producto
        Command deletePantalon = new command.cart.DeteleProductCommand(pantalon);
        deletePantalon.ejecutar();

        // Deshacer eliminacion
        deletePantalon.deshacer();

        // Comprar el carrito
        Command buyCart = new command.cart.BuyCartCommand();
        buyCart.ejecutar();

        // Deshacer compra (restaurar productos)
        buyCart.deshacer();

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
