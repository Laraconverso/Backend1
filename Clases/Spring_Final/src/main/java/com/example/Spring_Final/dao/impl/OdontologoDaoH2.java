package com.example.Spring_Final.dao.impl;

import com.example.Spring_Final.dao.IDao;
import com.example.Spring_Final.dao.configuracion.ConfiguracionJDBC;
import com.example.Spring_Final.model.Odontologo;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final static Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    private ConfiguracionJDBC configuracionJDBC = new ConfiguracionJDBC();
    private Connection connection = null;


   @Override
    public Odontologo guardar(Odontologo odontologo) {

       PreparedStatement preparedStatement = null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("cargando un nuevo odontologo");

            preparedStatement= connection.prepareStatement("INSERT INTO odontologos (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,odontologo.getMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                odontologo.setId(keys.getInt(1));

            logger.info("nuevo odontologo ingresado: " + odontologo);
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public void eliminar(Integer id) {
        PreparedStatement preparedStatement = null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("eliminando un odontologo");

            preparedStatement = connection.prepareStatement("DELETE FROM odontologos where id = ?");
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            logger.info("se elimino el odontologo con id: " +  id);
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Odontologo buscar(Integer id) {
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("buscando un odontologo con id: " + id);

            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Integer idOdontologo = result.getInt(1);
                int matricula = result.getInt(2);
                String nombre = result.getString(3);
                String apellido = result.getString(4);

                odontologo = new Odontologo(idOdontologo, matricula, nombre, apellido);
            }
            logger.info("odontologo encontrado: " + odontologo);
            preparedStatement.close();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {

        PreparedStatement preparedStatement = null;
        List<Odontologo> odontologos = new ArrayList();

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("buscamos todos los odontologos");

            preparedStatement =connection.prepareStatement("SELECT * FROM odontologos");
            ResultSet rs= preparedStatement.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt(1);
                int matricula = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);
                odontologos.add(new Odontologo(id,matricula,nombre,apellido));
            }

            logger.info("lista de odontologos: " + odontologos);
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return odontologos;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {

       PreparedStatement preparedStatement= null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("actualizando odontologo");

            preparedStatement = connection.prepareStatement("UPDATE odontologos SET matricula = ?, nombre = ? ,apellido = ?  WHERE id = ?");

            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.setInt(4, odontologo.getId());

            preparedStatement.executeUpdate();
            logger.info("odontologo actualizado " + odontologo);
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return odontologo;
    }
}


