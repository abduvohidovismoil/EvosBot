package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BeanUtil {
    private static Connection connection;

    private static String DB_NAME = "evos_bot";
    private static String DB_USERNAME = "postgres";
    private static String DB_PASSWORD = "1999";



    public static Connection connection(){
        if(connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/" + DB_NAME, DB_USERNAME, DB_PASSWORD
                );
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
