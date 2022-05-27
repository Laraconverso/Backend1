package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            //Cargar el driver JDBC, en este caso H2 (debemos agregarlo el .jar al proyecto)
            Class.forName("org.h2.Driver");
            //Establecer una conexión con la BD
            String url="jdbc:h2:~/bd_animales";
            Connection c= DriverManager.getConnection(url,"sa","sa");

            //Sentencia para CREAR una nueva tabla en la DB
            String creacionTabla="DROP TABLE IF EXISTS animales; CREATE TABLE animales (id INT PRIMARY KEY, tipo VARCHAR2, nombre VARCHAR2);";
            Statement s= c.createStatement();
            //Se ejecuta la sentencia
            s.execute(creacionTabla);

            //Insertar registros en la tabla
            String insersion1="INSERT INTO animales (id, tipo, nombre) VALUES (1,'perro','Mosito')";
            String insersion2="INSERT INTO animales (id, tipo, nombre) VALUES (2,'perro','Toby')";
            String insersion3="INSERT INTO animales (id, tipo, nombre) VALUES (3,'perro','Mutante')";
            String insersion4="INSERT INTO animales (id, tipo, nombre) VALUES (4,'gato','Michi')";
            String insersion5="INSERT INTO animales (id, tipo, nombre) VALUES (5,'gato','Flora')";
            s.execute(insersion1);
            s.execute(insersion2);
            s.execute(insersion3);
            s.execute(insersion4);
            s.execute(insersion5);

            //Se consultan los datos insertados
            String consulta= "SELECT * FROM animales WHERE tipo='gato'";
            ResultSet rs= s.executeQuery(consulta);
            while(rs.next()){
                //Imprimir los items de acuerdo a su tipo y posición
                System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3));

            }
            

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
