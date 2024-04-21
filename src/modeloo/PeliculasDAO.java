package src.modeloo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class PeliculasDAO {
    private String path;

    //CONSTRUCTOR
    public PeliculasDAO(String path){
        this.path = path;
    }

    //DEVOLVER TODAS LAS PELICULAS
    public ArrayList<Peliculas> dameTodos() throws SQLException{
        String sql = "SELECT p.titulo, d.nombre AS nombre_director, p.anyo, g.descripcion AS descripcion FROM peliculas p JOIN directores d ON p.id_director = d.id JOIN generos g ON p.id_genero = g.id ORDER BY anyo desc;";
    
        ArrayList <Peliculas> listaPeliculas = new ArrayList <>();

        Connection conn = new Utilidades().getConnection(path);
        Statement sentenciaSQL = conn.createStatement();
        ResultSet resultado = sentenciaSQL.executeQuery(sql);

        while (resultado.next()) {
            Peliculas pelicula = new Peliculas(
                    resultado.getString("titulo"),
                    resultado.getString("nombre_director"),
                    resultado.getInt("anyo"),
                    Generos.valueOf(resultado.getString("descripcion").toUpperCase()));
            
            listaPeliculas.add(pelicula);
        }
        return listaPeliculas;
    }

    public String getNombreDirector(int directorId, Connection conn) throws SQLException {
        String sql = "SELECT nombre FROM directores WHERE id=?";

        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, directorId);
        ResultSet resultado = sentenciaSQL.executeQuery();
        
        String nombreDirector = "";

        if (resultado.next()) {
            nombreDirector = resultado.getString("nombre");
        }
        
        resultado.close();
        sentenciaSQL.close();
        return nombreDirector;
    }

    //BUSCAR POR ID
    public Peliculas buscarPorId(int id) throws SQLException{
        String sql = "SELECT * FROM peliculas WHERE id=?;";
        
        Connection conn = new Utilidades().getConnection("./data/create_database.sqlite");
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, id);

        ResultSet resultado = sentenciaSQL.executeQuery();
        Peliculas peli = null;

        if (resultado.next()){

            //Nombre Director
            int dire = resultado.getInt("id_director"); 
            String direString = getNombreDirector(dire, conn);

            //Nombre Genero
            int generoId = resultado.getInt("id_genero");
            String generoString = Generos.getNombreGenero(generoId);

            peli = new Peliculas(
                        resultado.getString("titulo"),
                        direString,
                        resultado.getInt("anyo"),
                        Generos.valueOf(generoString));
        }else {
            return null;
        }

        resultado.close();
        sentenciaSQL.close();
        conn.close();

        return peli;
    }

    //BUSCAR POR TITULO
    public Peliculas buscarPorTitulo(String titulo) throws SQLException{
        String sql = "SELECT * FROM peliculas WHERE titulo=?;";
        
        Connection conn = new Utilidades().getConnection("./data/create_database.sqlite");
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setString(1, titulo);

        ResultSet resultado = sentenciaSQL.executeQuery();
        Peliculas peli = null;

        if (resultado.next()){

            //Nombre Director
            int dire = resultado.getInt("id_director");
            String direString = getNombreDirector(dire, conn);

            //Nombre Genero
            int generoId = resultado.getInt("id_genero"); // Obtener el ID del género
            String generoString = Generos.getNombreGenero(generoId);

            peli = new Peliculas (resultado.getString("titulo"),
                                    direString,
                                    resultado.getInt("anyo"),
                                    Generos.valueOf(generoString));
        }else {
            return null;
        }

        resultado.close();
        sentenciaSQL.close();
        conn.close();

        return peli;
    }

    //BORRAR UNA PELICULA
    public void borraPelicula(int id) throws SQLException{
        String sql = "DELETE FROM peliculas WHERE id=?";
    
        Connection conn = new Utilidades().getConnection("./data/create_database.sqlite");
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, id);

        int peliEliminada = sentenciaSQL.executeUpdate();

        if (peliEliminada == 0) {
            throw new SQLException("No se encontró ningún director con el Id proporcionado.");
        }

        sentenciaSQL.close();
        conn.close();
    }

    //MODIFICAR PELICULA
    public void modificarPelicula (Peliculas pelicula) throws SQLException{
        String sql = "UPDATE peliculas SET titulo=?, id_director = ?, anyo = ?, url_caratula = ?, id_genero = ?, es_animacion = ? WHERE id=?";

        Connection conn = new Utilidades().getConnection("./data/create_database.sqlite");
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setString(1, pelicula.getTitulo());
        sentenciaSQL.setInt(2, pelicula.getId_director());
        sentenciaSQL.setInt(3, pelicula.getAnyo());
        sentenciaSQL.setString(4, pelicula.getUrlCaratula());
        sentenciaSQL.setInt(5, pelicula.getId_genero());
        sentenciaSQL.setInt(6, pelicula.getEsAnimacion());
        sentenciaSQL.setInt(7, pelicula.getId());
       
        
        sentenciaSQL.executeUpdate();
        sentenciaSQL.close();
        conn.close();
    }

    //METODO MIO ADICIONAL DEVOLVER TODOS LOS DATOS COMO EN DB
    public Peliculas devolverDatosCompletos(int id) throws SQLException{
        String sql = "SELECT * FROM peliculas WHERE id=?;";
        
        Connection conn = new Utilidades().getConnection("./data/create_database.sqlite");
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, id);

        ResultSet resultado = sentenciaSQL.executeQuery();
        Peliculas peli = null;

        if (resultado.next()){

            peli = new Peliculas(
                        resultado.getInt("id"),
                        resultado.getString("titulo"),
                        resultado.getInt("id_director"),
                        resultado.getInt("anyo"),
                        resultado.getInt("id_genero"),
                        resultado.getString("url_caratula"),
                        resultado.getInt("es_animacion"));
        }else {
            return null;
        }

        resultado.close();
        sentenciaSQL.close();
        conn.close();

        return peli;
    }
}
