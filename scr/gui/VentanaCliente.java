package scr.gui;

import scr.personas.Usuario;
import scr.main.Venta.Ticket;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class VentanaCliente extends JFrame {
    private Usuario cliente;

    public VentanaCliente(Usuario cliente) {
        this.cliente = cliente;

        setTitle("Menú de Cliente - Bienvenido " + cliente.getNombre());
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnAtracciones = new JButton("Ver atracciones disponibles");
        JButton btnComprar = new JButton("Comprar tiquete");
        JButton btnHistorial = new JButton("Ver historial de compras");
        JButton btnSalir = new JButton("Cerrar sesión");

        btnAtracciones.addActionListener(e -> JOptionPane.showMessageDialog(this, "Aquí irían las atracciones."));
        
        btnHistorial.addActionListener(e -> {new VentanaHistorialTiquetes(cliente);
        });
        
        btnComprar.addActionListener(e -> {
            new VentanaCompraTiquete(cliente);
        });


        btnSalir.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Sesión cerrada.");
            dispose();
        });

        add(btnAtracciones);
        add(btnComprar);
        add(btnHistorial);
        add(btnSalir);

        setVisible(true);
    }
}
