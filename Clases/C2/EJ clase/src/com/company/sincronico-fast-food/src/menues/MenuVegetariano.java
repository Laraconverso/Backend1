public class MenuVegetariano extends Menu {

    private String condimento;

    public MenuVegetariano(String condimento, double precioBase) {
        super(precioBase);
        this.condimento = condimento;
    }

    public String getCondimento() {
        return condimento;
    }

    public void setCondimento(String condimento) {
        this.condimento = condimento;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Menu Vegetariano:" +
                           "\n\tCondimento: " + condimento +
                           "\n\tPrecio base: $" + getPrecioBase() +
                           "\n\tPackaging especial"
        );
    }
}
