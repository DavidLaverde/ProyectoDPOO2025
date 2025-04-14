package main;

import personas.Administrador;
import personas.Empleado;
import atracciones.Atraccion;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Atraccion> atracciones = new ArrayList<>();

        Administrador admin = new Administrador(1, "Admin Juan");

        int opcion;
        do {
            System.out.println("\n===== MENÚ ADMINISTRADOR DEL PARQUE =====");
            System.out.println("1. Ver empleados");
            System.out.println("2. Añadir empleado");
            System.out.println("3. Editar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Ver atracciones");
            System.out.println("6. Añadir atracción");
            System.out.println("7. Editar atracción");
            System.out.println("8. Eliminar atracción");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("--- Empleados ---");
                    for (Empleado e : empleados) {
                        System.out.println("ID: " + e.getidEmpleado() + " | Cargo: " + e.getcargo() + " | Lugar: " + e.getlugarDeTrabajo());
                    }
                    break;

                case 2:
                    System.out.println("Ingrese ID del empleado:");
                    int idEmp = scanner.nextInt();
                    System.out.println("Lugar de trabajo:");
                    int lugar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("¿Es cocinero? (true/false):");
                    boolean cocinero = scanner.nextBoolean();
                    ArrayList<String> cargos = new ArrayList<>();
                    String cargo;
                    do {
                        System.out.println("Ingrese un cargo (escriba 'fin' para terminar):");
                        cargo = scanner.nextLine();
                        if (!cargo.equalsIgnoreCase("fin")) {
                            cargos.add(cargo);
                        }
                    } while (!cargo.equalsIgnoreCase("fin"));
                    System.out.println("¿puede manejar mecanicas? (true/false):");
                    boolean manejoMec = scanner.nextBoolean();
                    ArrayList<String> manejoMecAltos = new ArrayList<>();
                    String manejoMecAlto;
                    do {
                        System.out.println("Ingrese una atraccion mecanica compleja que el empleado pueda usar (escriba 'fin' para terminar):");
                        manejoMecAlto = scanner.nextLine();
                        if (!manejoMecAlto.equalsIgnoreCase("fin")) {
                        	manejoMecAltos.add(manejoMecAlto);
                        }
                    } while (!manejoMecAlto.equalsIgnoreCase("fin"));
                    ArrayList<String> turnos = new ArrayList<>();
                    String turno;
                    do {
                        System.out.println("Ingrese una atraccion mecanica compleja que el empleado pueda usar (escriba 'fin' para terminar):");
                        turno = scanner.nextLine();
                        if (!turno.equalsIgnoreCase("fin")) {
                        	turnos.add(turno);
                        }
                    } while (!turno.equalsIgnoreCase("fin"));
                    Empleado nuevo = new Empleado(idEmp, lugar, cocinero, cargos, manejoMec, manejoMecAltos, turnos);
                    admin.añadirEmpleado(empleados, nuevo);
                    break;

                case 3:
                    System.out.println("ID del empleado a editar:");
                    int idEdit = scanner.nextInt();
                    Empleado empEdit = buscarEmpleado(empleados, idEdit);
                    if (empEdit != null) {
                        System.out.println("Nuevo lugar de trabajo:");
                        int nuevoLugar = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Nuevo cargo:");
                        String nuevoCargo = scanner.nextLine();
                        System.out.println("¿Es bilingüe? (true/false):");
                        boolean nuevoBilingue = scanner.nextBoolean();
                        admin.editarEmpleado(empEdit, nuevoLugar, nuevoCargo, nuevoBilingue);
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("ID del empleado a eliminar:");
                    int idDel = scanner.nextInt();
                    Empleado empDel = buscarEmpleado(empleados, idDel);
                    if (empDel != null) {
                        admin.removerEmpleado(empleados, empDel);
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("--- Atracciones ---");
                    for (Atraccion a : atracciones) {
                        System.out.println("Lugar: " + a.getLugar() + " | Descripción: " + a.getDescripcion());
                    }
                    break;

                case 6:
                    System.out.println("Lugar:");
                    int lugarAtr = scanner.nextInt();
                    System.out.println("Capacidad máx:");
                    int cap = scanner.nextInt();
                    System.out.println("Mín empleados:");
                    int minEmp = scanner.nextInt();
                    System.out.println("Tipo discapacidad:");
                    int tipoDis = scanner.nextInt();
                    System.out.println("Tiempo duración (minutos):");
                    int tiempo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Descripción:");
                    String desc = scanner.nextLine();
                    Atraccion nuevaAtr = new Atraccion(lugarAtr, cap, minEmp, tipoDis, tiempo, desc);
                    admin.añadirAtraccion(atracciones, nuevaAtr);
                    break;

                case 7:
                    System.out.println("Lugar de atracción a editar:");
                    int lugarEdit = scanner.nextInt();
                    Atraccion atrEdit = buscarAtraccion(atracciones, lugarEdit);
                    if (atrEdit != null) {
                        System.out.println("Nueva capacidad:");
                        int nuevaCap = scanner.nextInt();
                        System.out.println("Nuevo mínimo empleados:");
                        int nuevoMin = scanner.nextInt();
                        System.out.println("Nuevo tipo discapacidad:");
                        int nuevoDis = scanner.nextInt();
                        System.out.println("Nuevo tiempo duración:");
                        int nuevoTiempo = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Nueva descripción:");
                        String nuevaDesc = scanner.nextLine();
                        admin.editarAtraccion(atrEdit, nuevaCap, nuevoMin, nuevoDis, nuevoTiempo, nuevaDesc);
                    } else {
                        System.out.println("Atracción no encontrada.");
                    }
                    break;

                case 8:
                    System.out.println("Lugar de la atracción a eliminar:");
                    int lugarDel = scanner.nextInt();
                    Atraccion atrDel = buscarAtraccion(atracciones, lugarDel);
                    if (atrDel != null) {
                        admin.removerAtraccion(atracciones, atrDel);
                    } else {
                        System.out.println("Atracción no encontrada.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa. 👋");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // Métodos auxiliares
    public static Empleado buscarEmpleado(ArrayList<Empleado> empleados, int id) {
        for (Empleado e : empleados) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public static Atraccion buscarAtraccion(ArrayList<Atraccion> atracciones, int lugar) {
        for (Atraccion a : atracciones) {
            if (a.getLugar() == lugar) return a;
        }
        return null;
    }

}
