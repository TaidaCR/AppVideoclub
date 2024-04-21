package src.vista;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.modeloo.Peliculas;
import src.modeloo.PeliculasDAO;

public class DetallesPeliculas extends JPanel{
    
    private JLabel lblTitulo;
    private JLabel lblAnyo;
    private JLabel lblGenero;
    private JLabel lblDirector;
    private JTextField txtTitulo;
    private JTextField txtAnyo;
    private JTextField txtGenero;
    private JTextField txtDirector;

    public DetallesPeliculas() throws SQLException{
        setSize(300,300);

        PeliculasDAO dao = new PeliculasDAO("./data/create_database.sqlite");
        ArrayList <Peliculas> listaPelis = dao.dameTodos();

        setLayout(new GridLayout(listaPelis.size()+1, 4));

        lblTitulo = new JLabel("<html><b>Titulo</b></html>");
        lblAnyo = new JLabel("<html><b>Anyo</b></html>");
        lblGenero = new JLabel("<html><b>Genero</b></html>");
        lblDirector = new JLabel("<html><b>Director</b></html>");

        add(lblTitulo);
        add(lblAnyo);
        add(lblDirector);
        add(lblGenero);

        for (Peliculas pelicula: listaPelis){
            txtTitulo = new JTextField(pelicula.getTitulo());
            txtAnyo = new JTextField(String.valueOf(pelicula.getanyo()));
            txtGenero = new JTextField(pelicula.getGenero().toString());
            txtDirector = new JTextField(pelicula.getDirector());
            add(txtTitulo);
            add(txtAnyo);
            add(txtDirector);
            add(txtGenero);
            txtTitulo.setEditable(false);
            txtAnyo.setEditable(false);
            txtGenero.setEditable(false);
            txtDirector.setEditable(false);
        }
    }
}
