package scr.main;

import java.util.Scanner;
import scr.personas.Cliente;
import scr.personas.Usuario;
import scr.atracciones.logica.Autenticador;

public class MainCliente {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Bienvenido al sistema del Cliente ===");

        // Autenticación
        Usuario cliente = null;
        while (cliente == null) {
            System.out.print("Usuario: ");
            String user = scanner.nextLine();
            System.out.print("Contraseña: ");
            String pass = scanner.nextLine();

            cliente = Autenticador.autenticar(user, pass, "cliente");
            if (cliente == null) {
                System.out.println("Credenciales incorrectas. Intente de nuevo.\n");
            }
        }

        System.out.println("¡Autenticación exitosa! Bienvenido, " + cliente.getNombre());

        // Menú principal
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            String entrada = scanner.nextLine();

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número.");
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.println(">> Aquí podrías mostrar atracciones disponibles.");
                    break;
                case 2:
                    System.out.println(">> Aquí podrías implementar compra de tiquetes.");
                    break;
                case 3:
                    System.out.println(">> Aquí podrías permitir revisar historial de compras.");
                    break;
                case 0:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Cliente ---");
        System.out.println("1. Ver atracciones disponibles");
        System.out.println("2. Comprar tiquete");
        System.out.println("3. Ver historial de compras");
        System.out.println("0. Salir");
    }
}
