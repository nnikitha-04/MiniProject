package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getDBConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tech_crt","root","ROOT");

        }catch (SQLException e){
            System.out.println("Un");
        }

        return conn;
    }

    public static void closeConnection(){
        try{
            getDBConnection().close();
        }catch (SQLException e){
            System.out.println("Unable to Close the Connection : "+e.getMessage());
        }
    }
}