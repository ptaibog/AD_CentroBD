package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConection {

    private static Connection connection;

    public static Connection getConnection(){

        if (connection == null){
            createNewConnection();
        }
        return connection;
    }

    private static void createNewConnection() {
        try {
            connection = DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASS"));
        } catch (SQLException e) {
            System.out.println("Error en la conexion con la base de datos");

        }
    }


}
