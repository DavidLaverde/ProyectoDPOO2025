package scr.gui;

import scr.personas.Empleado;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class VentanaEmpleado extends JFrame {

    private Empleado empleado;

    public VentanaEmpleado(Empleado empleado) {
        this.empleado = empleado;

        setTitle("Panel del Empleado");
        setSize(450, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de datos
        JTextArea datosArea = new JTextArea();
        datosArea.setEditable(false);
        datosArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        datosArea.setText(obtenerInfoEmpleado());

        JScrollPane scrollPane = new JScrollPane(datosArea);
        add(scrollPane, BorderLayout.CENTER);

        // Botón cerrar
        JButton btnCerrar = new JButton("Cerrar sesión");
        btnCerrar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Sesión cerrada.");
            dispose();
        });

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnCerrar);
        add(panelBoton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private String obtenerInfoEmpleado() {
        return """
                Nombre: %s
                ID: %d
                Correo: %s
                Lugar de trabajo: %d
                Puestos: %s
                ¿Es cocinero?: %s
                ¿Maneja mecánicos?: %s
                Atracciones de alto riesgo: %s
                Turnos: %s
                """.formatted(
                empleado.getNombre(),
                empleado.getIdEmpleado(),
                empleado.getCorreo(),
                empleado.getLugarTrabajo(),
                empleado.getPuesto(),
                empleado.getEsCocinero() ? "Sí" : "No",
                empleado.getManejaMec() ? "Sí" : "No",
                empleado.getManejaMecAlto(),
                empleado.getTurno()
        );
    }
}
