package com.company.dao.impl;

import com.company.dao.IDao;
import com.company.model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;

public class MedicamentoDaoH2 implements IDao<Medicamento> {

    private static final Logger log= Logger.getLogger(MedicamentoDaoH2.class);

    //Se definen las variables necesarias para utilizar para utilizar H2
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    //private final static String DB_URL = "jdbc:h2:~/db_medicamentos;";
    private final static String DB_URL = "jdbc:h2:~/db_medicamentos3;";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "sa";
    //private final static String SQL_CREATE= "DROP TABLE IF EXISTS medicamentos; " +
    //        "CREATE TABLE medicamentos (id int auto_increment primary key,codigo int,nombre varchar(255),laboratorio varchar (255),cantidad int,precio double);";
    private final static String SQL_CREATE= "CREATE TABLE IF NOT EXISTS medicamentos (id int auto_increment primary key,codigo int,nombre varchar(255),laboratorio varchar (255),cantidad int,precio double);";


    @Override
    public Medicamento guardar(Medicamento medicamento) {
        log.info("Guardando el medicamento: "+medicamento);

        Connection connection= null;
        PreparedStatement preparedStatement= null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            log.info("Conexión establecida!!");

            //2-Se crea una sentencia, apartir de la conexión establecida
            Statement s= connection.createStatement();
            //Se ejecuta la sentencia para crear la tabla
            s.execute(SQL_CREATE);
            log.info("Tabla medicamentos creada!!");

            //3-Se crea un sentencia para INSERTAR un nuevo registro a partir del estudiante recibido
            //String SQL_INSERT= "insert into medicamentos (id,codigo, nombre, laboratorio, cantidad, precio) VALUES (?,?,?,?,?,?);";
            String SQL_INSERT= "insert into medicamentos (codigo, nombre, laboratorio, cantidad, precio) VALUES (?,?,?,?,?);";
            //Se prepara para INSERTAR un registro en la BD
            preparedStatement= connection.prepareStatement(SQL_INSERT);
            //Se setean los paramentros del INSERT
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,medicamento.getId());
            preparedStatement.setInt(1,medicamento.getCodigo());
            preparedStatement.setString(2,medicamento.getNombre());
            preparedStatement.setString(3,medicamento.getLaboratorio());
            preparedStatement.setInt(4,medicamento.getCantidad());
            preparedStatement.setDouble(5,medicamento.getPrecio());



            //Ejecutat el insert
            preparedStatement.execute();
            preparedStatement.close();
            log.info("Insertado nuevo registro en la Tabla medicamentos!!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            log.error("Error relacionado con la base de datos",e);
        }

        return medicamento;
    }



    @Override
    public Medicamento buscar(Integer id) {
        log.info("Buscando el medicamento con id: "+id);

        Connection connection=null;
        PreparedStatement preparedStatement= null;
        Medicamento medicamento= null;

        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);//Cargar el driver, en este caso de h2 (se debe agregar el .jar al proyecto)
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            log.info("Conexión establecida!!");

            //2- Crear setencia con un SELECT para obtener un registro de la BD
            String SQL_SELECT= "SELECT * FROM medicamentos WHERE id = ?";
            preparedStatement= connection.prepareStatement(SQL_SELECT);
            //Se setea el paramentro del select
            preparedStatement.setInt(1, id);

            //3- Ejecutar la sentencia SQL
            ResultSet result = preparedStatement.executeQuery();
            log.info("Sentencia SELECT ejecutada!!");

            //4- Obtener el resultado de la consulta (recorrer el resulset)
            while(result.next()){
                //Obtiene cada uno de los campos
                int idMedicamento= result.getInt("id");
                int codigo= result.getInt("codigo");
                String nombre= result.getString("nombre");
                String laboratorio= result.getString("laboratorio");
                int cantidad= result.getInt("cantidad");
                Double precio= result.getDouble("precio");

                //Crea un objeto apartir de los campos obtenidos
                medicamento= new Medicamento(idMedicamento,codigo,nombre,laboratorio,cantidad,precio);
                log.info("Obtenido el medicamento: "+medicamento);
            }

            preparedStatement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return medicamento;
    }



}
