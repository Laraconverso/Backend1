package com.example.clinicadental.clinica.dao.configuracion;

import com.example.clinicadental.clinica.dao.impl.OdontologoDaoH2;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracionJDBC {

    private final static Logger logger = Logger.getLogger(ConfiguracionJDBC.class);

    private String jdbcDriver;
    private String dbUrl;
    private String nombreUsuario;
    private String contrasenaUsuario;


    public ConfiguracionJDBC(String jdbcDriver, String dbUrl, String nombreUsuario, String contrasenaUsuario) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public ConfiguracionJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/db_clinica1;INIT=RUNSCRIPT FROM 'create.sql'";
        this.nombreUsuario = "sa";
        this.contrasenaUsuario = "sa";
    }

    public Connection conectarConBaseDeDatos() {
        Connection connection = null;

        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(dbUrl, nombreUsuario, contrasenaUsuario);

        } catch (SQLException throwables) {
            logger.info("driver no cargado", throwables);
        } catch (ClassNotFoundException e) {
            logger.error("conexión no establecida o falla de inserción", e);
        }
        return connection;
    }


}
