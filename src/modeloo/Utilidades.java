package src.modeloo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilidades {
    public Connection getConnection(String path){
        Connection conn = null;

        try{
            conn = DriverManager.getConnection(String.format("jdbc:sqlite:%s", path));
            System.out.println("La conexión ha sido establecida");
        }catch(SQLException err){
            System.out.println("Ha habido un error en la conexión");
            err.printStackTrace();
        }
        return conn;
    }
}
