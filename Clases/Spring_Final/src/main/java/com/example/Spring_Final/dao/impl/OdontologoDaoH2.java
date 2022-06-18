package com.example.Spring_Final.dao.impl;


import com.example.Spring_Final.dao.IDao;
import com.example.Spring_Final.dao.configuracion.ConfiguracionJDBC;
import com.example.Spring_Final.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger logger= Logger.getLogger(OdontologoDaoH2.class);

//    //Realizo conexion
//    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
//    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
//    private final static String DB_URL = "jdbc:h2:~/BD_clinica;INIT=RUNSCRIPT FROM 'create.sql'";
//    private final static String DB_USER ="sa";
//    private final static String DB_PASSWORD = "sa";

    private final static ConfiguracionJDBC configuracionJDBC = new ConfiguracionJDBC();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection= configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement = null;

        try {
            //1 Levantar el driver y Conectarnos
//            Class.forName(DB_JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//            logger.info("Conexion con la BD establecida.");

            //2 Crear una sentencia especificando que el ID lo auto incrementa la base de datos y que nos devuelva esa Key es decir ID
            preparedStatement = connection.prepareStatement("INSERT INTO odontologos(matricula,nombre,apellido) VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,domicilio.getId());
            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            //3 Ejecutar una sentencia SQL y obtener los ID que se autogeneraron en la base de datos
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                odontologo.setId(keys.getInt(1));

            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Error en la insercion de registro en la base de datos.");
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;
        try {
            //1 Levantar el driver y Conectarnos
//            Class.forName(DB_JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT id,matricula,nombre,apellido FROM odontologos where id = ?");
            preparedStatement.setInt(1,id);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (result.next()) {
                odontologo = crearOdontologo(result);
            }

            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return odontologo;
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
            preparedStatement = connection.prepareStatement("DELETE FROM odontologos where id = ?");
            preparedStatement.setInt(1,id);

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement = null;
        Odontologo odontologo;
        List<Odontologo> listaOdontologos = null;

        try {
//            Class.forName(DB_JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//            logger.info("Conexion con la BD establecida.");

            listaOdontologos = new ArrayList<>();
            String SQL_SELECT_ALL = "SELECT * FROM odontologos";
            preparedStatement= connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                odontologo = crearOdontologo(rs);
                listaOdontologos.add(odontologo);
            }

            String mensaje_logger = "Odontologos encontrados: " + listaOdontologos.size();

            for(Odontologo od : listaOdontologos){
                System.out.println(od);
                mensaje_logger += "\n   - " + od.toString();
            }

            logger.info(mensaje_logger);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            logger.error("Error al enlistar todos los odontologos.");
        }

        return listaOdontologos;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
       Connection connection = configuracionJDBC.conectarConBaseDeDatos();
        PreparedStatement preparedStatement = null;

        try {
            //1 Levantar el driver y Conectarnos
//            Class.forName(DB_JDBC_DRIVER);
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("UPDATE odontologos SET matricula = ?, nombre = ? ,apellido = ?");
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,domicilio.getId());
            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            //3 Ejecutar una sentencia SQL y obtener los ID que se autogeneraron en la base de datos
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologo;
    }

    private Odontologo crearOdontologo(ResultSet rs) throws SQLException {
        int idOdontologo= rs.getInt("id");
        int matricula = rs.getInt("matricula");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");

        Odontologo odontologo = new Odontologo(idOdontologo, matricula, nombre, apellido);
        return  odontologo;
    }
}
