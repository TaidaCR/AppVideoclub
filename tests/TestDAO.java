package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import src.modeloo.Directores;
import src.modeloo.DirectoresDAO;
import src.modeloo.Generos;
import src.modeloo.Peliculas;
import src.modeloo.PeliculasDAO;

public class TestDAO{

    //TESTS DIRECTORES
    @Test
    public void testDameTodosDirectores() throws SQLException{

        DirectoresDAO dao = new DirectoresDAO("./data/create_database.sqlite");
        ArrayList <Directores> listaDirectores = dao.dameTodos();

        assertEquals(5, listaDirectores.size());      
    }

    @Test
    public void testBuscarPorId() throws SQLException{

        DirectoresDAO dao = new DirectoresDAO("./data/create_database.sqlite");
        Directores dir = dao.buscarPorId(2);

        assertNotNull(dir);
        assertEquals(2, dir.getId());  
        assertEquals("Quentin Tarantino", dir.getNombre());
    }

    @Test
    public void testBuscarPorNombre() throws SQLException{

        DirectoresDAO dao = new DirectoresDAO("./data/create_database.sqlite");
        Directores dir = dao.buscarPorNombre("Steven Spielberg");
        assertNotNull(dir);
        assertEquals(4, dir.getId());  

        Directores dir1 = dao.buscarPorNombre("Martin Scorsese");
        assertNotNull(dir1);
        assertEquals(3, dir1.getId());  
    }

    @Test
    public void testBorraDirectores() throws SQLException{

        DirectoresDAO dao = new DirectoresDAO("./data/create_database.sqlite");
        Directores preBorrado = dao.buscarPorId(6);

        assertNotNull(preBorrado);
        dao.borraDirector(6);
        assertNull(dao.buscarPorId(6));
    }

    @Test
    public void testModificaDirector() throws SQLException{
        Directores dir = new Directores(1,"Christopher Nolan", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Christopher_Nolan_by_Gage_Skidmore_3_%28cropped%29.jpg/440px-Christopher_Nolan_by_Gage_Skidmore_3_%28cropped%29.jpg", "https://en.wikipedia.org/wiki/Christopher_Nolan");
        DirectoresDAO dao = new DirectoresDAO("./data/create_database.sqlite");
        
        dao.modificaDirectorEntero(dir);

        Directores directorActualizado = dao.devolverTodosDatosDirector(1);

        assertEquals("Christopher Nolan", directorActualizado.getNombre());
       
    }

    /*
    @Test
    public void testModificaDirectorSegunAtributo() throws SQLException{
        
        DirectoresDAO dao = new DirectoresDAO("./data/create_database.sqlite");
        Directores dir = dao.buscarPorId(1); //Antoine
        
        dao.modificaDirectorPorAtributo(dir, "Christopher nolan", "N");

        assertEquals(dao.getNombreDirector(1), "Christopher nolan");
    }
     */
    

    //TESTS PELICULAS
    
    @Test
    public void testDameTodosPeliculas() throws SQLException{

        PeliculasDAO dao = new PeliculasDAO("./data/create_database.sqlite");
        ArrayList <Peliculas> listaPeliculas = dao.dameTodos();

        assertEquals(7, listaPeliculas.size());      
    }

    @Test
    public void testBuscarPorIdPeliculas() throws SQLException{
        
        PeliculasDAO dao = new PeliculasDAO("./data/create_database.sqlite");
        Peliculas peli = dao.buscarPorId(3);

        assertEquals(2008, peli.getanyo());
        assertEquals("The Dark Knight", peli.getTitulo());
        assertEquals("James Cameron", peli.getDirector());
        assertEquals(Generos.ACCION,peli.getGenero());
        
    }

    @Test
    public void testBuscarPorTituloPeliculas() throws SQLException{
        PeliculasDAO dao = new PeliculasDAO("./data/create_database.sqlite");
        Peliculas peli = dao.buscarPorTitulo("Inception");

        assertEquals(2010, peli.getanyo());
        assertEquals("Inception", peli.getTitulo());
        assertEquals(Generos.SCIFI, peli.getGenero());
        assertEquals("James Cameron", peli.getDirector());
    }

    @Test
    public void testBorraPelicula()throws SQLException{
        PeliculasDAO dao = new PeliculasDAO("./data/create_database.sqlite");
        Peliculas preBorrado = dao.buscarPorId(5);

        assertNotNull(preBorrado);
        dao.borraPelicula(5);
        assertNull(dao.buscarPorId(5));
    }

    @Test
    public void testModificaPeliculaEntera() throws SQLException{
        Peliculas peli = new Peliculas(1, "Inception", 3, 2011, 9, "https://upload.wikimedia.org/wikipedia/en/2/2e/Inception_%282010%29_theatrical_poster.jpg", 0);
        PeliculasDAO dao = new PeliculasDAO("./data/create_database.sqlite");
        
        dao.modificaPeliculaEntera(peli);

        Peliculas peliculaActualizada = dao.devolverDatosCompletos(peli.getId());

        assertEquals(2011, peliculaActualizada.getanyo());
        assertEquals(0, peliculaActualizada.getEsAnimacion());
        assertEquals("Inception", peliculaActualizada.getTitulo());
        assertEquals(3, peliculaActualizada.getId_director());
       
    }

}
