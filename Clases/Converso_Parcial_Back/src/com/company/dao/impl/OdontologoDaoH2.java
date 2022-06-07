package com.company.dao.impl;

import com.company.dao.IDao;
import com.company.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger logger= Logger.getLogger(OdontologoDaoH2.class);

    //Realizo conexion
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/DB_odontologos;";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "sa";
    private final static String SQL_CREATE= "CREATE TABLE IF NOT EXISTS odontologos (id INT AUTO_INCREMENT PRIMARY KEY, matricula INT, nombre VARCHAR(100), apellido VARCHAR(100));";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection= null;
        PreparedStatement preparedStatement = null;

        try {
            //Establezco conexion
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            logger.info("Conexion con la BD establecida.");

            //Creo la tabla
            Statement s= connection.createStatement();
            s.execute(SQL_CREATE);
            logger.info("Tabla de odontologos creada.");

            // Creo sentencia de insertar y guardo el registro recibido en la tabla.
            String SQL_INSERT = "INSERT INTO odontologos (matricula, nombre, apellido) VALUES (?,?,?)";
            preparedStatement= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            //Ejecutar el insert
            preparedStatement.execute();
            preparedStatement.close();
            logger.info("Se inserto el registro en la tabla de odontologos.");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error en la insercion de registro en la base de datos.");
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo;
        List<Odontologo> listaOdontologos = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            logger.info("Conexion con la BD establecida.");

            listaOdontologos = new ArrayList<>();
            String SQL_SELECT_ALL = "SELECT * FROM odontologos";
            preparedStatement= connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                odontologo = new Odontologo(rs.getInt("id"), rs.getInt("matricula"), rs.getString("nombre"), rs.getString("apellido"));
                listaOdontologos.add(odontologo);
            }

            String mensaje_logger = "Odontologos encontrados: " + listaOdontologos.size();

            for(Odontologo od : listaOdontologos){
                System.out.println(od);
                mensaje_logger += "\n   - " + od.toString();
            }

            logger.info(mensaje_logger);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error al enlistar todos los odontologos.");
        }

        return listaOdontologos;
    }
}
