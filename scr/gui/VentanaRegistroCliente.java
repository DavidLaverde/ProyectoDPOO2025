package scr.gui;

import scr.personas.Cliente;
import scr.atracciones.logica.Autenticador;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroCliente extends JFrame {

    private JTextField campoNombre;
    private JTextField campoCorreo;
    private JPasswordField campoPassword;

    public VentanaRegistroCliente() {
        setTitle("Registro de Cliente");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        campoNombre = new JTextField();
        campoCorreo = new JTextField();
        campoPassword = new JPasswordField();

        JButton btnRegistrar = new JButton("Registrarse");
        btnRegistrar.addActionListener(e -> registrarCliente());

        add(new JLabel("Nombre:"));
        add(campoNombre);
        add(new JLabel("Correo:"));
        add(campoCorreo);
        add(new JLabel("Contraseña:"));
        add(campoPassword);
        add(new JLabel()); // espacio
        add(btnRegistrar);
    }

    private void registrarCliente() {
        String nombre = campoNombre.getText();
        String correo = campoCorreo.getText();
        String pass = new String(campoPassword.getPassword());

        boolean exitoso = Autenticador.registrarCliente(nombre, correo, pass);

        if (exitoso) {
            JOptionPane.showMessageDialog(this, "✅ Registro exitoso. Ahora puedes iniciar sesión.");
            new VentanaInicio().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al registrar. ¿El correo ya existe?");
        }
    }
}
