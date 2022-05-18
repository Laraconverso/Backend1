import procesadoresMenues.ProcesadorDeMenuAdulto;
import procesadoresMenues.ProcesadorDeMenuInfantil;
import procesadoresMenues.ProcesadorDeMenuVegetariano;
import procesadoresMenues.ProcesadorDeMenus;

public class Main {
    public static void main(String[] args) {
        ProcesadorDeMenus procesadorDeMenusAdulto = new ProcesadorDeMenuAdulto();
        ProcesadorDeMenus procesadorDeMenusInfantil = new ProcesadorDeMenuInfantil();
        ProcesadorDeMenus procesadorDeMenusVeggie = new ProcesadorDeMenuVegetariano();

        procesadorDeMenusAdulto.procesarMenu();
        procesadorDeMenusInfantil.procesarMenu();
        procesadorDeMenusVeggie.procesarMenu();
    }
}
