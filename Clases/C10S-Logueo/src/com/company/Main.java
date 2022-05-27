package com.company;

import org.apache.log4j.Logger;

public class Main {

    private final static Logger logger= Logger.getLogger(Main.class);


    public static void main(String[] args) {

        try{
            logger.info("Comienza la operación de división");
            int resultado= 4/0;
            logger.info("Finalizó la operación");
        }catch (Exception exception){
            logger.error("División por cero",exception);
        }
        logger.warn("Advertencia el metodo MAIN esta por finalizar");
        logger.debug("Esto va a mostrarse solo si el infoLogger esta en DEBUG");
        logger.info("Finalizamos el thread MAIN");

    }
}
