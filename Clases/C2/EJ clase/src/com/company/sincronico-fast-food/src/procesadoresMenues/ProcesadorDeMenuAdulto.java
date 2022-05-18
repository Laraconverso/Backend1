import Menu;
import MenuAdulto;

public class ProcesadorDeMenuAdulto extends ProcesadorDeMenus {

    protected Menu armar() {
        Menu menu = new MenuAdulto("Hamburguesa con papas", 550);
        return menu;
    }

    protected double calcularPrecioDeVenta(Menu menu) {
        return menu.getPrecioBase();
    }
}
