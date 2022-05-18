import Menu;
import MenuInfantil;

public class ProcesadorDeMenuInfantil extends ProcesadorDeMenus {

    protected Menu armar() {
        Menu menu = new MenuInfantil("Capitán América", 150, 350);
        return menu;
    }

    protected double calcularPrecioDeVenta(Menu menu) {
        return menu.getPrecioBase() + ((MenuInfantil) menu).getCostoSorpresa();
    }
}
