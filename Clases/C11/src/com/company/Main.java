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
            String creacionTabla="DROP TABLE IF EXISTS figura; CREATE TABLE figura (id INT PRIMARY KEY, figura VARCHAR2, color VARCHAR2);";
            Statement s= c.createStatement();
            //Se ejecuta la sentencia
            s.execute(creacionTabla);

            //Insertar registros en la tabla
            String insersion1="INSERT INTO animales (id, figura, color) VALUES (1,'circulo','rojo')";
            String insersion2="INSERT INTO animales (id, figura, color) VALUES (2,'circulo','verde')";
            String insersion3="INSERT INTO animales (id, figura, color) VALUES (3,'cuadrado','morado')";
            String insersion4="INSERT INTO animales (id, figura, color) VALUES (4,'cuadrado','lila')";
            String insersion5="INSERT INTO animales (id, figura, color) VALUES (5,'cuadrado','violeta')";
            s.execute(insersion1);
            s.execute(insersion2);
            s.execute(insersion3);
            s.execute(insersion4);
            s.execute(insersion5);

            //Se consultan los datos insertados
            String consulta= "SELECT * FROM figura WHERE figura='circulo' and color='rojo'";
            String consulta2= "SELECT * FROM figura";
            ResultSet rs= s.executeQuery(consulta);

            ResultSet rs2= s.executeQuery(consulta2);
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
