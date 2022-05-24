public class Main {

    public static void main(String[] args) {
        ComputadoraFactory computadoraFactory= new ComputadoraFactory();

        computadoraFactory.getComputadora(16,128);
        computadoraFactory.getComputadora(16,256);
        computadoraFactory.getComputadora(16,128);
        computadoraFactory.getComputadora(16,256);
        computadoraFactory.getComputadora(32,256);
    }
}
