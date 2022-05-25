package poo.integradora.indumentariaConDobleMap;

import java.util.HashMap;
import java.util.Map;

public class PrendaFactory {

    private Map<String, Prenda> cache;

    public PrendaFactory() {
        cache = new HashMap<>();
    }

    public int tamanioCache() {
        return cache.size();
    }

    public Prenda crearPrenda(String tipo) {
        Prenda prenda = cache.get(tipo);
        if (prenda == null) {
            prenda = new Prenda(tipo);
            cache.put(tipo, prenda);
            System.out.println("Creando nueva prenda...");
        } else {
            System.out.println("Devolviendo prenda existente...");
        }
        return prenda;
    }
}
