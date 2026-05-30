package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    Connection conectar = null;

    String usuario = "root";
    String password = "admin";
    String bd = "ejemplo1";
    String ip = "localhost";
    String puerto = "3306";

    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection getConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conectar = DriverManager.getConnection(
                    cadena, usuario, password);

            System.out.println("Conexión Exitosa");

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("Error: " + e.toString());
        }

        return conectar;
    }
}
