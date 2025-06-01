package scr.gui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class VentanaInicio extends JFrame {

    public VentanaInicio() {
        setTitle("Parque de Atracciones");
        setSize(400, 300); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Bienvenido al Parque");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnAdmin = new JButton("Administrador");
        JButton btnEmpleado = new JButton("Empleado");
        JButton btnCliente = new JButton("Cliente");
        JButton btnRegistro = new JButton("Registrarse como Cliente");

        btnRegistro.addActionListener(e -> {
        new VentanaRegistroCliente().setVisible(true);
        dispose();
    });

        btnAdmin.addActionListener(e -> {
            new VentanaLogin().setVisible(true);
            dispose();
        });

        btnEmpleado.addActionListener(e -> {
            new VentanaLogin().setVisible(true); 
            dispose(); 
        });

        btnCliente.addActionListener(e -> {
            new VentanaLogin().setVisible(true); 
            dispose(); 
        });

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(titulo);
        panel.add(btnAdmin);
        panel.add(btnEmpleado);
        panel.add(btnCliente);
        panel.add(btnRegistro);
        
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaInicio().setVisible(true));
    }
}