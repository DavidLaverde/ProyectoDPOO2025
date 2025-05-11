package scr.main;

import java.util.Scanner;
import scr.personas.Administrador;
import scr.personas.Usuario;
import scr.atracciones.logica.Autenticador;

public class MainAdministrador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Bienvenido al sistema del Administrador ===");

        // Autenticación
        Usuario admin = null;
        while (admin == null) {
            System.out.print("Usuario: ");
            String user = scanner.nextLine();
            System.out.print("Contraseña: ");
            String pass = scanner.nextLine();

            admin = Autenticador.autenticar(user, pass, "administrador");
            if (admin == null) {
                System.out.println("Credenciales incorrectas. Intente de nuevo.\n");
            }
        }

        System.out.println("¡Autenticación exitosa! Bienvenido, " + admin.getNombre());

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
                    System.out.println(">> Aquí se implementaría la gestión de empleados.");
                    break;
                case 2:
                    System.out.println(">> Aquí se implementaría la gestión de atracciones.");
                    break;
                case 3:
                    System.out.println(">> Aquí se implementaría la visualización de reportes.");
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
        System.out.println("\n--- Menú de Administrador ---");
        System.out.println("1. Gestionar empleados");
        System.out.println("2. Gestionar atracciones");
        System.out.println("3. Ver reportes");
        System.out.println("0. Salir");
    }
}
