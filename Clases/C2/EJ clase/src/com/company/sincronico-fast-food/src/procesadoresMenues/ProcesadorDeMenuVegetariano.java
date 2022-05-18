import Menu;
import MenuVegetariano;

public class ProcesadorDeMenuVegetariano extends ProcesadorDeMenus {

    protected Menu armar() {
        Menu menu = new MenuVegetariano("Extra queso", 500);
        return menu;
    }

    protected double calcularPrecioDeVenta(Menu menu) {
        return menu.getPrecioBase() * 1.1;
    }
}
