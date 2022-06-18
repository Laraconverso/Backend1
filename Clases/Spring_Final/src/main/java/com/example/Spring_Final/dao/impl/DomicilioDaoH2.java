package com.example.Spring_Final.dao.impl;

import com.example.Spring_Final.dao.IDao;
import com.example.Spring_Final.model.Domicilio;
import com.example.Spring_Final.dao.configuracion.ConfiguracionJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {

//    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
//    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
//    private final static String DB_URL = "jdbc:h2:~/BD_clinica;INIT=RUNSCRIPT FROM 'create.sql'";
//    private final static String DB_USER ="sa";
//    private final static String DB_PASSWORD = "sa";

    private final static ConfiguracionJDBC configuracionJDBC = new ConfiguracionJDBC();

    @Override
    public Domicilio guardar(Domicilio domicilio) {

        //Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement = null;

        try {
            //1 Levantar el driver y Conectarnos
//            Class.forName(DB_JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            //2 Crear una sentencia especificando que el ID lo auto incrementa la base de datos y que nos devuelva esa Key es decir ID
            preparedStatement = configuracionJDBC.conectarConBaseDeDatos().prepareStatement("INSERT INTO domicilios(calle,numero,localidad,provincia) VALUES(?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,domicilio.getId());
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setString(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());

            //3 Ejecutar una sentencia SQL y obtener los ID que se autogeneraron en la base de datos
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                domicilio.setId(keys.getInt(1));

            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement = null;
        try {
            //1 Levantar el driver y Conectarnos
//            Class.forName(DB_JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM domicilios where id = ?");
            preparedStatement.setInt(1,id);

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public Domicilio buscar(Integer id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement = null;
        Domicilio domicilio = null;
        try {
            //1 Levantar el driver y Conectarnos
//            Class.forName(DB_JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT id,calle,numero,localidad,provincia FROM domicilios where id = ?");
            preparedStatement.setInt(1,id);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (result.next()) {
                domicilio = crearDomicilio(result);
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return domicilio;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement = null;
        List<Domicilio> domicilios = new ArrayList<>();
        try {
            //1 Levantar el driver y Conectarnos
//            Class.forName(DB_JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement =connection.prepareStatement("SELECT *  FROM domicilios");

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (result.next()) {
               Domicilio domicilio = crearDomicilio(result);
               domicilios.add(domicilio);
            }

            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return domicilios;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement = null;

        try {
            //1 Levantar el driver y Conectarnos
//            Class.forName(DB_JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

             preparedStatement = connection.prepareStatement("UPDATE domicilios SET calle = ?, numero = ? ,localidad = ?, provincia = ?  WHERE id = ?");
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,domicilio.getId());
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setString(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.setInt(5, domicilio.getId());

            //3 Ejecutar una sentencia SQL y obtener los ID que se autogeneraron en la base de datos
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return domicilio;
    }

    private Domicilio crearDomicilio(ResultSet rs) throws SQLException {
        int idDomicilio = rs.getInt("id");
        String calle = rs.getString("calle");
        String numero = rs.getString("numero");
        String localidad = rs.getString("localidad");
        String provincia = rs.getString("provincia");

        Domicilio domicilio = new Domicilio(idDomicilio,calle,numero,localidad,provincia);
        return domicilio;
    }
}

