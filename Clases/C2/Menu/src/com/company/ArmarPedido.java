package com.company;

import java.util.ArrayList;

public class ArmarPedido {

    private ArrayList<Menu> pedido =new ArrayList<Menu>();

    public ArmarPedido(ArrayList<Menu> pedido) {
        this.pedido = pedido;
    }

    public ArmarPedido(Menu menu){
        pedido.add(menu);
    }

    public void agregarMenu(Menu menu){
        pedido.add(menu);


    }

    @Override
    public String toString() {
       return "ArmarPedido{" +
                "pedido=" + pedido+
                '}';
    }
}
