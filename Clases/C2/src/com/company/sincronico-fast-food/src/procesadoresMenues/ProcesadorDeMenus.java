import Menu;

public abstract class ProcesadorDeMenus {

    public void procesarMenu() {
        Menu menu = armar();
        double precio = calcularPrecioDeVenta(menu);
        menu.mostrarInformacion();
        System.out.println("\tPrecio final: $" + precio + "\n");
    }

    protected abstract Menu armar();
    protected abstract double calcularPrecioDeVenta(Menu menu);
}
