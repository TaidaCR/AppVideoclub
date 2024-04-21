package src.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.sql.SQLException;

public class VentanaPrincipal extends JFrame{
    private DetallesPeliculas panelPeliculas;
    private JButton actualizar;

    public VentanaPrincipal(String titulo)throws SQLException{

        super(titulo);
        panelPeliculas = new DetallesPeliculas();
        actualizar = new JButton("Actualizar");

        JPanel panelBoton = new JPanel();
        panelBoton.add(actualizar);

        setLayout(new BorderLayout());
        add(panelPeliculas, BorderLayout.CENTER);
        
        add(panelBoton, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
