package Persistence;

import java.sql.*;

public class DBConnector {
    private static String URL = "jdbc:mysql://localhost:3306/startcode_test?serverTimezone=Europe/Copenhagen";
    private static String USER = "dev";
    private static String PW = "ax2";

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USER, PW );
        }
        return singleton;
    }

}

