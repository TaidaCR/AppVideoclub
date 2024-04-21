package src.modeloo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DirectoresDAO{
    String path;
    //CONSTRUCTOR
    public DirectoresDAO(String path){
        this.path=path;
    }
    
    public ArrayList<Directores> dameTodos() throws SQLException{
        String sql = "SELECT id, nombre FROM directores ORDER BY nombre asc";

        ArrayList <Directores> listaDirectores = new ArrayList <>();

        Connection conn = new Utilidades().getConnection(path);
        Statement sentenciaSQL = conn.createStatement();
        ResultSet resultado = sentenciaSQL.executeQuery(sql);

        while (resultado.next()){
            Directores dir;
            dir = new Directores(resultado.getInt("id"), resultado.getString("nombre"));
            listaDirectores.add(dir);
        }
        return listaDirectores;
    }

    public Directores buscarPorId(int id) throws SQLException{
        String sql = "SELECT * FROM directores WHERE id=?;";
        
        Connection conn = new Utilidades().getConnection("./data/create_database.sqlite");
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, id);

        ResultSet resultado = sentenciaSQL.executeQuery();

        Directores dir = null;
        if (resultado.next()){
            dir = new Directores(resultado.getInt("id"), resultado.getString("nombre"));
        }else {
            return null;
        }

        resultado.close();
        sentenciaSQL.close();
        conn.close();

        return dir;
    }

    public Directores buscarPorNombre(String nombre) throws SQLException{
        String sql = "SELECT * FROM directores WHERE nombre=?;";
        
        Connection conn = new Utilidades().getConnection("./data/create_database.sqlite");
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setString(1, nombre);

        ResultSet resultado = sentenciaSQL.executeQuery();

        Directores dir = null;
        if (resultado.next()){
            dir = new Directores(resultado.getInt("id"), resultado.getString("nombre"));
        }else {
            throw new SQLException("No se encontró ningún director con el nombre proporcionado.");
        }

        resultado.close();
        sentenciaSQL.close();
        conn.close();

        return dir;
    }

    public void borraDirector(int id) throws SQLException{
        String sql = "DELETE FROM directores WHERE id=?";
    
        Connection conn = new Utilidades().getConnection("./data/create_database.sqlite");
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, id);

        int directorEliminado = sentenciaSQL.executeUpdate();

        if (directorEliminado == 0) {
            throw new SQLException("No se encontró ningún director con el Id proporcionado.");
        }

        sentenciaSQL.close();
        conn.close();
    }

    public void modificaDirectorEntero (Directores director) throws SQLException{
        String sql = "UPDATE directores set nombre = ?, url_foto = ?, url_web = ? WHERE id = ?";
       
        Connection conn = new Utilidades().getConnection("./data/create_database.sqlite");
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);

        sentenciaSQL.setString(1, director.getNombre());
        sentenciaSQL.setString(2, director.getUrlFoto());
        sentenciaSQL.setString(3, director.getUrlWeb());
        sentenciaSQL.setInt(4, director.getId());
        
        sentenciaSQL.executeUpdate();
        conn.close();
    }

    //METODO MIO
    public Directores devolverTodosDatosDirector(int id) throws SQLException{
        String sql = "SELECT * FROM directores WHERE id=?;";
        
        Connection conn = new Utilidades().getConnection("./data/create_database.sqlite");
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, id);

        ResultSet resultado = sentenciaSQL.executeQuery();

        Directores dir = null;
        if (resultado.next()){
            dir = new Directores(resultado.getInt("id"), 
                                resultado.getString("nombre"),
                                resultado.getString("url_foto"),
                                resultado.getString("url_web"));
        }else {
            return null;
        }

        resultado.close();
        sentenciaSQL.close();
        conn.close();

        return dir;
    }
}
