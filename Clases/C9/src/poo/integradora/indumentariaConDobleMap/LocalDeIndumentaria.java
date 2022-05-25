package poo.integradora.indumentariaConDobleMap;

import java.util.*;

public class LocalDeIndumentaria {

    private Map<String, Prenda> prendas;
    private Map<String, Integer> cantidadPrendas;
    private PrendaFactory factory;

    public LocalDeIndumentaria() {
        this.prendas = new HashMap<>();
        this.cantidadPrendas = new HashMap<>();
        this.factory = new PrendaFactory();
    }

    public void agregarPrenda(String talle, String tipo, boolean esNuevo, boolean importada) {
        String clave = "Tipo: " + tipo + " Talle: " + talle + " - " + (esNuevo ? "Es nuevo" : "Es usado") + " - " + (importada ? "Es importado" : "Es nacional");
        if (prendas.get(clave) != null) {
            Integer cantidadActual = cantidadPrendas.get(clave);
            cantidadPrendas.put(clave, cantidadActual + 1);
        } else {
            prendas.put(clave, factory.crearPrenda(tipo));
            cantidadPrendas.put(clave, 1);
        }
    }

    public int cantidadPrendas() {
        return prendas.size();
    }

    public void mostrarPrendas() {
        Iterator itClaves = prendas.keySet().iterator();
        Iterator itCantidades = cantidadPrendas.values().iterator();
        while (itClaves.hasNext() && itCantidades.hasNext()) {
            System.out.println(itClaves.next());
            System.out.println("\tCantidad en stock: " + itCantidades.next());
        }
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory()-runtime.freeMemory()) / (1024 * 1024));
    }
}
