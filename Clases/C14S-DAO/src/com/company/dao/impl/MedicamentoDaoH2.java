package com.company.dao.impl;

import com.company.dao.IDao;
import com.company.model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;

public class MedicamentoDaoH2 implements IDao<Medicamento> {

    private static final Logger logger = Logger.getLogger(MedicamentoDaoH2.class);

    private final static String DB_JDBC_DRIVER ="org.h2.Driver";
    private final static String DB_URL= "jdbc:h2:~/bd_farmacia";
    private final static String DB_USER= "sa";
    private final static String DB_PASSWORD= "sa";
    private final static String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS medicamentos; CREATE TABLE medicamentos(id INT PRIMARY KEY, codigo INT, nombre varchar(100), laboratorio varchar(100), cantidad INT, precio DOUBLE);";
    private final static String SQL_TABLE_INSERT = "INSERT INTO medicamentos (id, codigo, nombre, laboratorio, cantidad, precio) VALUES (?,?,?,?,?,?);";
    private final static String SQL_TABLE_SEARCH = "SELECT * FROM medicamentos WHERE id=?";
   // private final static String SQL_TABLE_UPDATE =" UPDATE medicamentos SET nombre=? WHERE id=?;";

    Connection connection = null;



    @Override
    public Medicamento guardar(Medicamento medicamento) {
        logger.info("Guardando el medicamento ...");
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            logger.info("Se establecio la conexion.");
            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);
            logger.info("Se creo la tabla exitosamente. :) ");

            PreparedStatement psInsert= connection.prepareStatement(SQL_TABLE_INSERT);
            psInsert.setInt(1, medicamento.getId());
            psInsert.setInt(2, medicamento.getCodigo());
            psInsert.setString(3, medicamento.getNombre());
            psInsert.setString(4, medicamento.getLaboratorio());
            psInsert.setInt(5, medicamento.getCantidad());
            psInsert.setDouble(6, medicamento.getPrecio());


            psInsert.execute();
            logger.info("Se guardo el medicamento. :) ");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("No se guardo el medicamento ;( ");
        }

        return medicamento;
    }

    @Override
    public Medicamento buscar(Integer id) {
        logger.info("Buscando medicamento");

        Medicamento medicamento = null;

        //crear la consulta
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            logger.info("Se establecio la conexion.");
            Statement statement = connection.createStatement();

            //ejecutar la consulta
            PreparedStatement psSearch= connection.prepareStatement(SQL_TABLE_SEARCH);
            psSearch.setInt(1, id);
            //obtener el resultado (Result Set)
            ResultSet rs1 = psSearch.executeQuery();
            logger.info("Realizando la busqueda...");


            //Armar un objeto con los datos obtenidos y retornarlo
            while(rs1.next()) {
                int id_ = rs1.getInt("id");
                int cod_ = rs1.getInt("codigo");
                String nombre_ = rs1.getString("nombre");
                String laboratorio_ = rs1.getString("laboratorio");
                int cant_ = rs1.getInt("cantidad");
                double precio_ = rs1.getDouble("precio");

                medicamento = new Medicamento(id_, cod_, nombre_, laboratorio_, cant_, precio_);

            }

            if(medicamento == null){
                logger.info("Se realizo la busqueda .... El medicamento no existe.");
            }else{
                logger.info("Se realizo la busqueda " + medicamento.getNombre());
            }


        } catch (Exception e) {
            e.printStackTrace();
            logger.error("No se pudo realizar la busqueda");
        }


        return medicamento;
    }
}
