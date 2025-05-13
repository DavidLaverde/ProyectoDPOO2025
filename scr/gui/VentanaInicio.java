package scr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

        btnAdmin.addActionListener(e -> {
            new VentanaAdmin().setVisible(true);
            dispose();
        });

        btnEmpleado.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Interfaz de empleado aún no disponible.");
        });

        btnCliente.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Interfaz de cliente aún no disponible.");
        });

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(titulo);
        panel.add(btnAdmin);
        panel.add(btnEmpleado);
        panel.add(btnCliente);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaInicio().setVisible(true));
    }
}

