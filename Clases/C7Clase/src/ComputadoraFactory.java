import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    //Mapa donde se almacenas las computadoras creadas
    private Map<String,Computadora> computadoraMap= new HashMap<>();


    public Computadora getComputadora(int ram, int disco){
        //Establesco la clave
        String clave= "key: "+ram+":"+disco;

        //Busco la computadora en el Map, según la clave
        Computadora computadora= computadoraMap.get(clave);
        if (computadora == null){
            //Si entra significa que aún no hay un objeto con esa clave
            //Crear una nueva instancia
            computadora= new Computadora(ram,disco);
            System.out.println("Se crea un nueva computadora: "+computadora);
            //Agregar al Map
            computadoraMap.put(clave,computadora);
        }
        return computadora;
    }

}
