public class Computadora {
    //Atributos
    private int ram;
    private int disco;


    //Constructor
    public Computadora(int ram, int disco) {
        this.ram = ram;
        this.disco = disco;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "ram=" + ram +
                ", disco=" + disco +
                '}';
    }
}
