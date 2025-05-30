package scr.gui;

import scr.atracciones.logica.Autenticador;
import scr.personas.Administrador;
import scr.personas.Empleado;
import scr.personas.Usuario;
import scr.personas.Cliente;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {

    private JComboBox<String> rolBox;
    private JTextField campoUsuario;
    private JTextField campoCorreo;
    private JPasswordField campoPassword;
    private JTextField campoID;

    public VentanaLogin() {
        setTitle("Iniciar Sesión");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5));

        // Componentes
        rolBox = new JComboBox<>(new String[]{"Administrador", "Empleado", "Cliente"});
        campoUsuario = new JTextField();
        campoCorreo = new JTextField();
        campoPassword = new JPasswordField();
        campoID = new JTextField(); // solo para administrador
        campoID.setEnabled(true);

        rolBox.addActionListener(e -> {
            campoID.setEnabled(rolBox.getSelectedItem().equals("Administrador"));
        });

        JButton btnLogin = new JButton("Ingresar");
        btnLogin.addActionListener(e -> autenticar());

        // Añadir componentes
        add(new JLabel("Rol:"));
        add(rolBox);

        add(new JLabel("Usuario:"));
        add(campoUsuario);

        add(new JLabel("Correo:"));
        add(campoCorreo);

        add(new JLabel("Contraseña:"));
        add(campoPassword);

        add(new JLabel("ID (solo admin):"));
        add(campoID);

        add(new JLabel()); // espaciador
        add(btnLogin);
    }

    private void autenticar() {
        String usuario = campoUsuario.getText();
        String correo = campoCorreo.getText();
        String pass = new String(campoPassword.getPassword());
        String rol = (String) rolBox.getSelectedItem();

        switch (rol) {
            case "Administrador":
                String id = campoID.getText();
                Administrador admin = Autenticador.autenticarA(usuario, correo, pass, id);
                if (admin != null) {
                    JOptionPane.showMessageDialog(this, "✅ Bienvenido, administrador " + admin.getNombre());
                    new VentanaAdmin().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "❌ Datos incorrectos.");
                }
                break;

            case "Empleado":
                Usuario emp = Autenticador.autenticarE(usuario, correo, pass);
                if (emp != null) {
                    JOptionPane.showMessageDialog(this, "✅ Bienvenido, empleado " + emp.getNombre());
                    new VentanaEmpleado((Empleado) emp).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "❌ Datos incorrectos.");
                }
                break;

            case "Cliente":
                Usuario cli = Autenticador.autenticarC(usuario, correo, pass);
                if (cli != null) {
                    JOptionPane.showMessageDialog(this, "✅ Bienvenido, cliente " + cli.getNombre());
                    new VentanaCliente(cli).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "❌ Datos incorrectos.");
                }
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaLogin().setVisible(true));
    }
}
