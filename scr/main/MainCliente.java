package scr.main;

import java.util.Scanner;

import javax.swing.SwingUtilities;

import scr.personas.Cliente;
import scr.personas.Usuario;
import scr.atracciones.logica.Autenticador;
import scr.gui.VentanaCliente;

public class MainCliente {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Bienvenido al sistema del Cliente ===");

        // Autenticación
        Usuario cliente = null;
        while (cliente == null) {
            System.out.print("Usuario: ");
            String user = scanner.nextLine();
            System.out.print("Correo: ");
            String correo = scanner.nextLine();
            System.out.print("Contraseña: ");
            String pass = scanner.nextLine();

            cliente = Autenticador.autenticarC(user, correo, pass);
            if (cliente == null) {
                System.out.println("Credenciales incorrectas. Intente de nuevo.\n");
            }
        }

        System.out.println("¡Autenticación exitosa! Bienvenido, " + cliente.getNombre());
        
        final Usuario clienteFinal = cliente;
        SwingUtilities.invokeLater(() -> new VentanaCliente(clienteFinal));
        scanner.close();
    }
}
