package src.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import src.modeloo.Directores;
import src.modeloo.DirectoresDAO;
import src.modeloo.Peliculas;
import src.modeloo.PeliculasDAO;

public class MainPruebas {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner (System.in);

        try{
            Class.forName("org.sqlite.JDBC");
            System.out.println("Esto funciona");
        } catch (ClassNotFoundException e){
            System.out.println("SQLite JDBC no encontrado");
            e.printStackTrace(); 
        }

        //INTRODUCIR ID PELICULA
        PeliculasDAO dao1 = new PeliculasDAO("./data/create_database.sqlite");
        System.out.print ("Introduce el id de la película: ");
        int id_pelicula = scanner.nextInt();
        scanner.nextLine();

        Peliculas peliUnica = dao1.buscarPorId(id_pelicula);

        System.out.println(String.format("%s - %s - %s - %s", peliUnica.getTitulo(), peliUnica.getAnyo(), peliUnica.getDirector(), peliUnica.getGenero()));
        System.out.println("-----------------");
        
        //DEVOLVER TODAS LAS PELIS DE LA LISTA
        System.out.println("LISTADO DE PELICULAS");
        ArrayList <Peliculas> listaPelis = new ArrayList<>();
        
        listaPelis = dao1.dameTodos();

        for (Peliculas peli:listaPelis){
            System.out.println(String.format("%s - %s - %s - %s", peli.getTitulo(), peli.getAnyo(), peli.getDirector(), peli.getGenero())); 
        }
        System.out.println("-----------------");

        //MODIFICAR DIRECTOR
        System.out.println("DESEA MODIFICAR UN DIRECTOR?: -S- Si, -N- No");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("S")){
            DirectoresDAO dao3 = new DirectoresDAO ("./data/create_database.sqlite");
            System.out.println("Introduce el id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Directores dir = dao3.devolverTodosDatosDirector(id);

            System.out.println(String.format("Director a modificar: NOMBRE - %s, URLFOTO - %s, URLWEB - %s", dir.getNombre(), dir.getUrlFoto(), dir.getUrlWeb()));

            System.out.println("Introduce el nombre: ");
            String nombre=scanner.nextLine();

            System.out.println("Introduce la URL de la Foto: ");
            String urlFoto=scanner.nextLine();

            System.out.println("Introduce la URL de la web: ");
            String urlWeb=scanner.nextLine();

            Directores dirModificado = new Directores (id,nombre,urlFoto,urlWeb);

            dao3.modificaDirectorEntero(dirModificado);
        } else if (respuesta.equalsIgnoreCase("N")){
            System.out.println("Finalizado");
        }

        System.out.println("-----------------");
    
        //MODIFICAR PELICULA ENTERA
        System.out.println("DESEA MODIFICAR UNA PELICULA?: -S- Si, -N- No");
        respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("S")){
            PeliculasDAO dao4 = new PeliculasDAO ("./data/create_database.sqlite");
            System.out.println("Introduce el id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Peliculas peli = dao4.devolverDatosCompletos(id);

            System.out.println(String.format("Peli a modificar: ID - %s, TITULO - %s, ID_DIRECTOR - %s, AÑO - %s, URL CARATULA - %s, ANIMACION - %s, ID_GENERO - %s", id, peli.getTitulo(), peli.getId_director(), peli.getAnyo(), peli.getUrlCaratula(), peli.getEsAnimacion(), peli.getId_genero()));

            System.out.println("Introduce el título: ");
            String nombre=scanner.nextLine();

            System.out.println("Introduce el ID del Director: ");
            int id_director=scanner.nextInt();

            System.out.println("Introduce el anyo: ");
            int anyo=scanner.nextInt();
            scanner.nextLine();

            System.out.println("Introduce la url de la caratula: ");
            String url_caratula=scanner.nextLine();

            System.out.println("Introduce si es animacion: ");
            int es_animacion=scanner.nextInt();

            System.out.println("Introduce el genero: ");
            int id_genero=scanner.nextInt();

            Peliculas peliModificada = new Peliculas (id, nombre,id_director,anyo,id_genero,url_caratula,es_animacion);

            dao4.modificarPelicula(peliModificada);
        } else if (respuesta.equalsIgnoreCase("N")){
            System.out.println("Finalizado");
        }

        System.out.println("-----------------");
        scanner.close();
    }
}
