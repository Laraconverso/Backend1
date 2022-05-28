package com.company;

import org.apache.log4j.Logger;

import java.sql.*;

public class Main {

    //Atributo para logear
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            // cargar el driver
            Class.forName("org.h2.Driver");
            logger.info("h2 cargado :)");

            //Establecer la conecxion a la BBDD
            String url = "jdbc:h2:~/test";
            Connection connection = DriverManager.getConnection(url, "sa", "");
            logger.info("Conexion extablecida :)");

            //Sentencia para crear una tabla
            String creacionTabla = "DROP TABLE IF EXISTS test; CREATE TABLE test(id INT PRIMARY KEY, nombre VARCHAR, apellido VARCHAR, edad INT, pais VARCHAR)";
            Statement st = connection.createStatement();
            st.execute(creacionTabla);
            logger.info("Se creo la tabla correctamente");

            //Se insertan registros en la bd
            String incercion1= "INSERT INTO test VALUES (1, 'Juan', 'Perez', 30, 'Peru'); ";
            String incercion2= "INSERT INTO test VALUES (2, 'Harry', 'Styles', 26, 'Peru'); ";
            String incercion3= "INSERT INTO test VALUES (3, 'Melanie', 'Martinez', 22, 'Peru'); ";
            st.execute(incercion1);
            st.execute(incercion2);
            st.execute(incercion3);
            logger.info("Registros insertados :)");

            //consultar registros
            String consulta = "SELECT * FROM test";
            ResultSet rs = st.executeQuery(consulta);
            logger.info("Se consulta correctamente la tabla");
                //recorrer registros obtenidos en el resultSet
            while(rs.next()){
                System.out.println(rs.getInt(1)+ "-" + rs.getString(2));
            }

             //sentencia para actualizar un registro
            String update = "UPDATE test SET nombre='Roque' WHERE id= 1";
            st.execute(update);
            logger.info("Se actualizo la tabla");
            String consultaEmpleado = "SELECT * FROM test WHERE id=1";
            ResultSet rs1 = st.executeQuery(consultaEmpleado);
            while(rs1.next()) {
                logger.debug(rs1.getInt(1) + "-" + rs1.getString(2) + "- " + rs1.getString(3) + "- "
                        + "- " + rs1.getInt(4) + "- " + rs1.getString(5));
            }
//            while (rs1.next()) {
//                logger.debug(rs1.getRow());
//            }

            rs = st.executeQuery(consulta);
            System.out.println("----Despues del update-----");
            //recorrer los registros obtenidos en el resultset
            while(rs.next()){
                System.out.println(rs.getInt(1)+ "-" + rs.getString(2));
            }

//
            //eliminar registros
            String borrar = "DELETE FROM test WHERE id=1";
            String consultaEmpleadoEliminado = "SELECT * FROM test WHERE id=1";
            ResultSet rs2 = st.executeQuery(consultaEmpleadoEliminado);
            while(rs2.next()) {
                logger.info("Eliminamos a "+ rs2.getInt(1) + "-" + rs2.getString(2) + "- " + rs2.getString(3) + "- "
                        + "- " + rs2.getInt(4) + "- " + rs2.getString(5));
            }
            st.execute(borrar);
            logger.info("Se elimino el registro con id=1");

            //consultar los datos
            rs = st.executeQuery(consulta);
            System.out.println("----Despues del borrado-----");

            //recorrer los registros obtenidos en el resultset
            while(rs.next()){
                System.out.println(rs.getInt(1)+ "-" + rs.getString(2));
            }


            //eliminar registros
            String borrar2 = "DELETE FROM test WHERE edad=22";
            String consultaEmpleadoEliminado2 = "SELECT * FROM test WHERE edad=22";
            ResultSet rs3 = st.executeQuery(consultaEmpleadoEliminado2);
            while(rs3.next()) {
                logger.info("Eliminamos a "+ rs3.getInt(1) + "-" + rs3.getString(2) + "- " + rs3.getString(3) + "- " + rs3.getInt(4) + "- " + rs3.getString(5));
            }
            st.execute(borrar2);
            logger.info("Se elimino el registro con edad=22");

            //consultar los datos
            rs = st.executeQuery(consulta);
            System.out.println("----Despues del segundo borrado-----");
            //recorrer los registros obtenidos en el resultset
            while(rs.next()){
                System.out.println(rs.getInt(1)+ "-" + rs.getString(2));
            }


        } catch (ClassNotFoundException e) {
            logger.error("Driver no encontrado", e);

        } catch (SQLException throwables) {
            logger.error("Error de conexion :(", throwables);
        }


    }
}
