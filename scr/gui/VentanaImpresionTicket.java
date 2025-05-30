package scr.gui;

import scr.main.Venta.Ticket;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class VentanaImpresionTicket extends JFrame {
    
    public VentanaImpresionTicket(Ticket ticket) {
        setTitle("Impresión de Tiquete");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Verificar si ya fue impreso
        if (ticket.isYaImpreso()) {
            int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "Este tiquete ya fue impreso. ¿Desea volver a imprimirlo?",
                "Reimpresión",
                JOptionPane.YES_NO_OPTION
            );
            if (confirmacion != JOptionPane.YES_OPTION) {
                dispose();
                return;
            }
        }

        // Panel de información
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTipo = new JLabel("Tipo: " + ticket.getTipoTicket());
        JLabel lblID = new JLabel("ID: " + ticket.getIdt());
        JLabel lblFecha = new JLabel("Fecha: " + LocalDateTime.now());

        lblTipo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblID.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblFecha.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelInfo.add(lblTipo);
        panelInfo.add(lblID);
        panelInfo.add(lblFecha);

        add(panelInfo, BorderLayout.NORTH);

        // Generar QR
        try {
            String contenidoQR = "Tipo: " + ticket.getTipoTicket()
                    + "\nID: " + ticket.getIdt()
                    + "\nFecha: " + LocalDateTime.now();

            BitMatrix matrix = new MultiFormatWriter().encode(contenidoQR, BarcodeFormat.QR_CODE, 200, 200);
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(matrix);
            JLabel qrLabel = new JLabel(new ImageIcon(qrImage));
            qrLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(qrLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generando el código QR.");
        }

        // Botón para cerrar e "imprimir"
        JButton btnConfirmar = new JButton("Confirmar impresión");
        btnConfirmar.addActionListener(e -> {
            ticket.marcarComoImpreso();
            JOptionPane.showMessageDialog(this, "Tiquete marcado como impreso.");
            dispose();
        });

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnConfirmar);
        add(panelBoton, BorderLayout.SOUTH);

        setVisible(true);
    }
}

