package scr.gui;

import javax.swing.*;
import java.awt.*;

public class VentanaAdmin extends JFrame {

    public VentanaAdmin() {
        setTitle("Panel Administrador");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Gestión de Parque");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnEmp = new JButton("Gestionar Empleados");
        JButton btnAtr = new JButton("Gestionar Atracciones");
        JButton btnVolver = new JButton("Volver");

        btnEmp.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Aquí iría la ventana de empleados.");
        });

        btnAtr.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Aquí iría la ventana de atracciones.");
        });

        btnVolver.addActionListener(e -> {
            new VentanaInicio().setVisible(true);
            dispose();
        });

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(titulo);
        panel.add(btnEmp);
        panel.add(btnAtr);
        panel.add(btnVolver);

        add(panel);
    }
}

