package scr.main;

import java.util.Scanner;
import scr.personas.Empleado;
import scr.personas.Usuario;
import scr.atracciones.logica.Autenticador;

public class MainEmpleado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Bienvenido al sistema del Empleado ===");

        // Autenticación
        Usuario empleado = null;
        while (empleado == null) {
            System.out.print("Usuario: ");
            String user = scanner.nextLine();
            System.out.print("Contraseña: ");
            String pass = scanner.nextLine();

            empleado = Autenticador.autenticar(user, pass, "empleado");
            if (empleado == null) {
                System.out.println("Credenciales incorrectas. Intente de nuevo.\n");
            }
        }

        System.out.println("¡Autenticación exitosa! Bienvenido, " + empleado.getNombre());

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
                    System.out.println(">> Aquí podrías registrar la asistencia o tareas del día.");
                    break;
                case 2:
                    System.out.println(">> Aquí podrías revisar asignaciones o actividades.");
                    break;
                case 3:
                    System.out.println(">> Aquí podrías reportar problemas o incidencias.");
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
        System.out.println("\n--- Menú de Empleado ---");
        System.out.println("1. Registrar asistencia/tareas");
        System.out.println("2. Consultar asignaciones");
        System.out.println("3. Reportar problemas");
        System.out.println("0. Salir");
    }
}
