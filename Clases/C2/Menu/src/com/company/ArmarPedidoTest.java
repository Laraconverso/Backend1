package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArmarPedidoTest {

    @Test
    public void controlarPedido(){
        //DADO
        String resultado = "ArmarPedido{pedido=[MenuInfantil{cantidad Juguetes= 3 precio Total= 1009.0 tipo menu= menu infantil}, MenuVeggie{cantidadEspecias=2, cantidad Salsas= 3 precio Total= 1026.0 tipo menu= menu veggie}, Menu{precioTotal= 1000.0 tipo menu= menu classic}]}";
        MenuInfantil menu1 = new MenuInfantil( 3);
        MenuVeggie menu2 = new MenuVeggie(2,3);
        MenuClassic menu3 = new MenuClassic();

        //CUANDO
        ArmarPedido pedido1 = new ArmarPedido(menu1);

        pedido1.agregarMenu(menu2);
        pedido1.agregarMenu(menu3);
        String resultadoPedido = pedido1.toString();

        //ENTONCES
        Assertions.assertEquals(resultado, resultadoPedido);

    }

    @Test
    public void controlarCosto(){
        double resultado = 1009.0;
        MenuInfantil menu1 = new MenuInfantil( 3);
        MenuVeggie menu2 = new MenuVeggie(2,3);
        MenuClassic menu3 = new MenuClassic();

        double precioMenu= menu1.calculcarCosto();

        Assertions.assertEquals(resultado, precioMenu);
    }





}
