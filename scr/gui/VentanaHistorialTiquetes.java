package scr.gui;

import scr.main.Venta.Ticket;
import scr.personas.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class VentanaHistorialTiquetes extends JFrame {

    public VentanaHistorialTiquetes(Usuario cliente) {
        setTitle("Historial de Tiquetes");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        List<Ticket> historial = cliente.getHistorialTiquetes();

        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Ticket t : historial) {
            String info = "Tipo: " + t.getTipoTicket() + " | ID: " + t.getIdt() + " | Estado: " + t.getEstado();
            modelo.addElement(info);
        }

        JList<String> lista = new JList<>(modelo);
        add(new JScrollPane(lista), BorderLayout.CENTER);

        setVisible(true);
    }
}
