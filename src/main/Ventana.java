package src.main;
import src.vista.VentanaPrincipal;

import java.sql.SQLException;
import javax.swing.JFrame;

public class Ventana {
    public static void main(String[] args) throws SQLException{
        VentanaPrincipal ventana = new VentanaPrincipal("Catálogo de películas");
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

        ventana.pack(); 
    }
}
