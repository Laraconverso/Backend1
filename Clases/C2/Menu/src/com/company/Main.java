package com.company;

public class Main {

    public static void main(String[] args) {
        MenuInfantil menu1 = new MenuInfantil( 3);
        MenuVeggie menu2 = new MenuVeggie(2,3);
        MenuClassic menu3 = new MenuClassic();

        System.out.println(menu1.calculcarCosto());

        System.out.println(menu2.calculcarCosto());

        System.out.println(menu3.calculcarCosto());

        ArmarPedido pedido1 = new ArmarPedido(menu1);

        pedido1.agregarMenu(menu2);
        pedido1.agregarMenu(menu3);

        System.out.println(pedido1.toString());


    }
}
