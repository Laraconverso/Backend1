package com.example.clinicadental.clinica.dao.impl;

import com.example.clinicadental.clinica.dao.IDao;
import com.example.clinicadental.clinica.dao.configuracion.ConfiguracionJDBC;
import com.example.clinicadental.clinica.model.Domicilio;
import com.example.clinicadental.clinica.model.Paciente;
import com.example.clinicadental.clinica.util.Util;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    private final static Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    private ConfiguracionJDBC configuracionJDBC = new ConfiguracionJDBC();
    private Connection connection = null;

    private DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();


    @Override
    public Paciente guardar(Paciente paciente) {

        PreparedStatement preparedStatement = null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("cargando un nuevo paciente");

            Domicilio domicilio = domicilioDaoH2.guardar(paciente.getDomicilio());
            Integer id_domicilio= domicilio.getId();

            preparedStatement = connection.prepareStatement("INSERT INTO pacientes(nombre,apellido,dni,fecha_ingreso,domicilio_id) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDni());
            preparedStatement.setDate(4, Util.utilDateToSqlDate(paciente.getFechaIngreso()));
            preparedStatement.setInt(5, id_domicilio);

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                paciente.setId(keys.getInt(1));

            logger.info("nuevo paciente ingresado " + paciente);
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
        return paciente;
    }

    @Override
    public void eliminar(Integer id) {

        PreparedStatement preparedStatement = null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("eliminando un paciente");

            preparedStatement = connection.prepareStatement("DELETE FROM pacientes where id = ?");
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            logger.info("se elimino el paciente con id: " +  id);
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
    }

    @Override
    public Paciente buscar(Integer id) {

        PreparedStatement preparedStatement = null;
        Paciente paciente = null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("buscando paciente con id: " + id);

            preparedStatement = connection.prepareStatement("SELECT id,nombre,apellido,dni,fecha_ingreso,domicilio_id  FROM pacientes where id = ?");
            preparedStatement.setInt(1,id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int idPaciente = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String dni = result.getString("dni");
                Date fechaIngreso = result.getDate("fecha_ingreso");
                int idDomicilio = result.getInt("domicilio_id");
                Domicilio domicilio = domicilioDaoH2.buscar(idDomicilio);
                paciente = new Paciente(idPaciente,nombre,apellido,dni,fechaIngreso,domicilio);
            }
            logger.info("paciente encontrado: " + paciente);
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {

        PreparedStatement preparedStatement = null;
        List<Paciente> pacientes = new ArrayList<>();

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("buscando todos los pacientes");

            preparedStatement = connection.prepareStatement("SELECT *  FROM pacientes");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int idPaciente = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String dni = result.getString("dni");
                Date fechaIngreso = result.getDate("fecha_ingreso");
                int idDomicilio = result.getInt("domicilio_id");
                Domicilio domicilio = domicilioDaoH2.buscar(idDomicilio);
                Paciente paciente = new Paciente(idPaciente,nombre,apellido,dni,fechaIngreso,domicilio);
                pacientes.add(paciente);
            }
            logger.info("encontramos todos los pacientes" + pacientes);
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
        return pacientes;
    }

    @Override
    public Paciente actualizar(Paciente paciente) {

        PreparedStatement preparedStatement = null;

        try {
            connection = configuracionJDBC.conectarConBaseDeDatos();
            logger.info("actualizando paciente");

            Domicilio domicilio = domicilioDaoH2.actualizar(paciente.getDomicilio());

            preparedStatement = connection.prepareStatement("UPDATE pacientes SET nombre=?, apellido=?, dni=?, fecha_ingreso=?, domicilio_id=?  WHERE id = ?");
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDni());
            preparedStatement.setDate(4, Util.utilDateToSqlDate(paciente.getFechaIngreso()));
            preparedStatement.setInt(5, paciente.getDomicilio().getId());
            preparedStatement.setInt(6, paciente.getId());

            preparedStatement.executeUpdate();
            logger.info("paciente actualizado " + paciente);
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
        return paciente;
    }


}