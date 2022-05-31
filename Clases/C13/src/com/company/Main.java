package com.company;

import java.beans.ExceptionListener;
import java.sql.*;

public class Main {

    // se definene las variables necesarias para utilizar H2
    private final static String DB_JDBC_DRIVER= "org.h2.Driver";
    private final static String DB_URL= "jdbc:h2:~/accounts";
    private final static String DB_USER= "sa";
    private final static String DB_PASSWORD= "sa";

    //Se definen las sentencias SQL
    private static final String SQL_CREATE= "DROP TABLE IF EXISTS cuentas; CREATE TABLE cuentas (nro_cuenta INT PRIMARY KEY, nombre VARCHAR(100),saldo NUMERIC(15,2));";

    //SQL para insertar registros
    private static final String SQL_INSERT= "INSERT INTO cuentas(nro_cuenta, nombre, saldo) VALUES(?,?,?);";

    //SQL para actualizar registros
    private static final String SQL_UPDATE = "UPDATE cuentas SET saldo=? WHERE nro_cuenta=?";

    public static void main(String[] args) throws SQLException {
        
        Cuenta cuenta = new Cuenta(123, "Juan Perez", 0.00);
        
        Connection connection = null;

        //levantae el driver

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //ejecuto sentencia para crear la tabla
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);


            //Preparar para agregar un registro a la tabla de cuentas
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            //se setean los parametros del insert
            psInsert.setInt(1, cuenta.getNroCuenta());
            psInsert.setString(2,cuenta.getNombre());
            psInsert.setDouble(3, cuenta.getSaldo());
            psInsert.execute(); //se ejecuta el insert en la bd

            //Prepara para actualizar registro
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1,200.0);
            psUpdate.setInt(2, cuenta.getNroCuenta());
            psUpdate.execute();


            connection.setAutoCommit(false); //si esta en false debo realizar explicitament eun commit
            psUpdate.setDouble(1,500.0);
            psUpdate.setInt(2, cuenta.getNroCuenta());
            psUpdate.execute();

            //genero una excepticon
            int a = 4/0; //simulo que si da un error no se hace la ultima operacion

            connection.commit(); //se debe realizar un commit para que efectue las operaciones en la bbdd
            //restablecer el calor del autocommit
            connection.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();

            //si entro aca es pq algo fallo
            connection.rollback();

        }


    }
}
