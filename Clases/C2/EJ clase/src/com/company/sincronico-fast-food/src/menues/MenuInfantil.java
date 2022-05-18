public class MenuInfantil extends Menu {

    private String sorpresa;
    private double costoSorpresa;

    public MenuInfantil(String sorpresa, double costoSorpresa, double precioBase) {
        super(precioBase);
        this.sorpresa = sorpresa;
        this.costoSorpresa = costoSorpresa;
    }

    public String getSorpresa() {
        return sorpresa;
    }

    public double getCostoSorpresa() {
        return costoSorpresa;
    }

    public void setSorpresa(String sorpresa) {
        this.sorpresa = sorpresa;
    }

    public void setCostoSorpresa(double costoSorpresa) {
        this.costoSorpresa = costoSorpresa;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Menu Infantil:" +
                           "\n\tSorpresa: " + sorpresa +
                           "\n\tPrecio sorpresa: $" + costoSorpresa +
                           "\n\tPrecio base: $" + getPrecioBase() +
                           "\n\tPackaging normal"
        );
    }
}
