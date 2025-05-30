package scr.gui;

import scr.main.Venta.Ticket;
import scr.personas.Usuario;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class VentanaCompraTiquete extends JFrame {

    private JComboBox<String> tipoCombo;
    private JCheckBox esIndividualBox;
    private JSpinner diasSpinner;
    private Usuario cliente; // ✅

    public VentanaCompraTiquete(Usuario cliente) {
        this.cliente = cliente; // ✅

        setTitle("Compra de Tiquete");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        tipoCombo = new JComboBox<>(new String[]{"Básico", "Familiar", "Oro", "Diamante"});
        add(crearFila("Tipo de tiquete:", tipoCombo));

        esIndividualBox = new JCheckBox("¿Es individual?");
        add(esIndividualBox);

        diasSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        add(crearFila("Días válidos:", diasSpinner));

        JButton btnComprar = new JButton("Generar Tiquete");
        btnComprar.addActionListener(e -> generarTiquete());
        add(btnComprar);

        setVisible(true);
    }

    private JPanel crearFila(String etiqueta, JComponent componente) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(etiqueta));
        panel.add(componente);
        return panel;
    }

    private void generarTiquete() {
        String tipo = (String) tipoCombo.getSelectedItem();
        boolean esBasico = tipo.equalsIgnoreCase("Básico");
        String individual = esIndividualBox.isSelected() ? "sí" : "no";
        int dias = (Integer) diasSpinner.getValue();

        Ticket ticket = new Ticket(tipo, esBasico, LocalDateTime.now(), dias, individual, LocalDateTime.now().plusDays(1));

        cliente.agregarTiquete(ticket); // ✅ Guardar en historial

        new VentanaImpresionTicket(ticket); // Imprimir
        dispose();
    }
}
