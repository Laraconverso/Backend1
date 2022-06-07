package com.company;

import com.company.dao.impl.OdontologoDaoH2;
import com.company.model.Odontologo;
import com.company.service.OdontologoService;

public class Main {

    public static void main(String[] args) {
	//Uso el main para probar funcionamiento durante el desarrollo del parcial
        //Creo un objeto odontologo
        Odontologo odontologo= new Odontologo(145,"Rene","Favaloro");
        Odontologo odontologo2= new Odontologo(208,"Pablo","Chaw");
        Odontologo odontologo3= new Odontologo(320,"Lihuen","Aprile");


        //Creo un service
        OdontologoService odontologoService= new OdontologoService(new OdontologoDaoH2());

        //Solicitar al service que persita el objeto en una BD
        odontologoService.guardar(odontologo);
        odontologoService.guardar(odontologo2);
        odontologoService.guardar(odontologo3);

        //Enlisto los odontologos creados
        odontologoService.listarTodos();
    }
}
