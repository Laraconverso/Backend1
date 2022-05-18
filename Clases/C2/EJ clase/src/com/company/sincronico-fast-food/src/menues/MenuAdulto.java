public class MenuAdulto extends Menu {

    private String oferta;

    public MenuAdulto(String oferta, double precioBase) {
        super(precioBase);
        this.oferta = oferta;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Menu Adulto:" +
                           "\n\tOferta: " + oferta +
                           "\n\tPrecio base: $" + getPrecioBase() +
                           "\n\tPackaging normal"
        );
    }
}
