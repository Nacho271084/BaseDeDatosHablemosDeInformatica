package com.mycompany.trabandoconbasededatos.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexionMySQL {
    
    public static Connection obtenerConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/tareasdb";
        String user = "root";
        String password = "1234"; // pon aquí tu contraseña si tienes

        return DriverManager.getConnection(url, user, password);
    }
    }

