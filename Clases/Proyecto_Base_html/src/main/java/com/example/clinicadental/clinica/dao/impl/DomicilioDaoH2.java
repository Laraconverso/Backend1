package com.example.clinicadental.clinica.dao.impl;

import com.example.clinicadental.clinica.dao.IDao;
import com.example.clinicadental.clinica.dao.configuracion.ConfiguracionJDBC;
import com.example.clinicadental.clinica.model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {

    private final static Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    private ConfiguracionJDBC configuracionJDBC = new ConfiguracionJDBC();
    private Connection connection = null;

    @Override
    public Domicilio guardar(Domicilio domicilio) {

        PreparedStatement preparedStatement = null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("guardando un nuevo domicilio");

            preparedStatement = connection.prepareStatement("INSERT INTO domicilios(calle,numero,localidad,provincia) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setString(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                domicilio.setId(keys.getInt(1));
            logger.info("nuevo domicilio ingresado: " + domicilio);
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
                try{
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
        }
        return domicilio;
    }

    @Override
    public void eliminar(Integer id) {

        PreparedStatement preparedStatement = null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("eliminando un domicilio");

            preparedStatement = connection.prepareStatement("DELETE FROM domicilios where id = ?");
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            logger.info("se elimino el domicilio con id: " +  id);
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
    public Domicilio buscar(Integer id) {

        PreparedStatement preparedStatement = null;
        Domicilio domicilio = null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("buscando un domicilio con id: " + id);

            preparedStatement = connection.prepareStatement("SELECT id,calle,numero,localidad,provincia FROM domicilios where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int idDomicilio = result.getInt("id");
                String calle = result.getString("calle");
                String numero = result.getString("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");

                domicilio = new Domicilio(idDomicilio, calle, numero, localidad, provincia);
            }
            logger.info("domicilio encontrado: " + domicilio);
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
        return domicilio;
    }

    @Override
    public List<Domicilio> buscarTodos() {

        PreparedStatement preparedStatement = null;
        List<Domicilio> domicilios = new ArrayList<>();

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("buscamos todos los domicilios");

            preparedStatement = connection.prepareStatement("SELECT *  FROM domicilios");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {

                int idDomicilio = result.getInt("id");
                String calle = result.getString("calle");
                String numero = result.getString("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");

                Domicilio domicilio = new Domicilio(idDomicilio,calle,numero,localidad,provincia);

                domicilios.add(domicilio);
            }
            logger.info("encontramos todos los domicilios" + domicilios);
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
        return domicilios;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {

        PreparedStatement preparedStatement = null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("actualizando domicilio");

            preparedStatement = connection.prepareStatement("UPDATE domicilios SET calle = ?, numero = ? ,localidad = ?, provincia = ?  WHERE id = ?");

            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setString(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.setInt(5, domicilio.getId());

            preparedStatement.executeUpdate();
            logger.info("domicilio actualizado " + domicilio);
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
        return domicilio;
    }
}

