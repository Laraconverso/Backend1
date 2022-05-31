package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {

    private final static String DB_JDBC_DRIVER ="org.h2.Driver";
    private final static String DB_URL= "jdbc:h2:~/bd_odontologos";
    private final static String DB_USER= "sa";
    private final static String DB_PASSWORD= "sa";
    private final static String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE ODONTOLOGOS(ID LONG PRIMARY KEY, NOMBRE varchar(100) NOT NULL, APELLIDO varchar(100) NOT NULL, MATRICULA varchar(100) NOT NULL);";
    private final static String SQL_TABLE_INSERT = "INSERT INTO ODONTOLOGOS (ID, NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?,?);";
    private final static String SQL_TABLE_UPDATE =" UPDATE ODONTOLOGOS SET MATRICULA=? WHERE ID=?;";

    public static void main(String[] args) throws  Exception{
	// write your code here
        Odontologo odontologo = new Odontologo(1L, "Carlos", "Ramirez", "abc123");
        Connection connection = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);

            PreparedStatement psInsert= connection.prepareStatement(SQL_TABLE_INSERT);
            psInsert.setLong(1, odontologo.getId());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.setString(4, odontologo.getMatricula());

            psInsert.execute();

            connection.setAutoCommit(false);
            PreparedStatement psUpdate = connection.prepareStatement(SQL_TABLE_UPDATE);
            psUpdate.setString(1, "456def");
            psUpdate.setLong(2, odontologo.getId());
            psUpdate.execute();


            connection.commit();
            connection.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }

    }
}
