package main;

import personas.Administrador;
import personas.Empleado;
import atracciones.Atraccion;
import atracciones.Mecanica;
import atracciones.Cultural;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
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
                	System.out.println("Ingrese ID del empleado que desea editar:");
                	int idEditar = scanner.nextInt();
                	scanner.nextLine(); // Limpiar el buffer

                	Empleado empEditar = null;
                	for (Empleado e : empleados) {
                	    if (e.getidEmpleado() == idEditar) {
                	        empEditar = e;
                	        break;
                	    }
                	}

                	if (empEditar == null) {
                	    System.out.println("Empleado no encontrado.");
                	    break;
                	}

                	// Editar lugar de trabajo
                	System.out.println("Lugar de trabajo actual: " + empEditar.getlugarDeTrabajo());
                	System.out.println("Nuevo lugar de trabajo:");
                	int nuevoLugar = scanner.nextInt();
                	scanner.nextLine();

                	// Editar si es cocinero
                	System.out.println("¿Es cocinero? (true/false). Actual: " + empEditar.getcocinero());
                	boolean nuevoCocinero = scanner.nextBoolean();
                	scanner.nextLine();

                	// Editar cargos
                	ArrayList<String> nuevosCargos = new ArrayList<>();
                	String nuevoCargo;
                	System.out.println("Ingrese nuevos cargos (escriba 'fin' para terminar). Actual: " + empEditar.getcargo());
                	do {
                	    nuevoCargo = scanner.nextLine();
                	    if (!nuevoCargo.equalsIgnoreCase("fin")) {
                	        nuevosCargos.add(nuevoCargo);
                	    }
                	} while (!nuevoCargo.equalsIgnoreCase("fin"));

                	// Editar manejo de mecánicas
                	System.out.println("¿Puede manejar mecánicas? (true/false)" );
                	boolean nuevoManejoMec = scanner.nextBoolean();
                	scanner.nextLine();

                	// Editar atracciones mecánicas complejas
                	ArrayList<String> nuevosMecanicosAltos = new ArrayList<>();
                	String nuevaMecanica;
                	System.out.println("Ingrese atracciones mecánicas complejas que pueda manejar (escriba 'fin' para terminar):");
                	do {
                	    nuevaMecanica = scanner.nextLine();
                	    if (!nuevaMecanica.equalsIgnoreCase("fin")) {
                	        nuevosMecanicosAltos.add(nuevaMecanica);
                	    }
                	} while (!nuevaMecanica.equalsIgnoreCase("fin"));

                	// Editar turnos
                	ArrayList<String> nuevosTurnos = new ArrayList<>();
                	String nuevoTurno;
                	System.out.println("Ingrese turnos disponibles (escriba 'fin' para terminar):");
                	do {
                	    nuevoTurno = scanner.nextLine();
                	    if (!nuevoTurno.equalsIgnoreCase("fin")) {
                	        nuevosTurnos.add(nuevoTurno);
                	    }
                	} while (!nuevoTurno.equalsIgnoreCase("fin"));

                	// Actualizar datos del empleado
                	empEditar.setlugarDeTrabajo(nuevoLugar);
                	empEditar.setcocinero(nuevoCocinero);
                	empEditar.setcargo(nuevosCargos);
                	empEditar.setmanejoMec(nuevoManejoMec);
                	empEditar.setmanejoMecAlto(nuevosMecanicosAltos);
                	empEditar.setturno(nuevosTurnos);

                	System.out.println("Empleado actualizado correctamente.");
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
                	System.out.println("--- Atracciones Registradas ---");
                	for (Atraccion a : atracciones) {
                	    String tipo = a instanceof Mecanica ? "Mecánica" :
                	                 a instanceof Cultural ? "Cultural" : "Desconocido";
                	    System.out.println("[" + tipo + "] Lugar: " + a.getlugar() + " | Descripción: " + a.getdescripcion());
                	}

                case 6:
                	System.out.println("Tipo de atracción (1. Mecánica | 2. Cultural):");
                	int tipo = scanner.nextInt();
                	scanner.nextLine();

                	if (tipo != 1 && tipo != 2) {
                	    System.out.println("❌ Tipo no válido. Debe ser 1 (Mecánica) o 2 (Cultural).");
                	    break;
                	}

                	System.out.println("Lugar:");
                	int lugarAtr = scanner.nextInt();

                	System.out.println("Capacidad máxima:");
                	int cap = scanner.nextInt();

                	System.out.println("Mínimo de empleados:");
                	int minEmp = scanner.nextInt();
                	scanner.nextLine();

                	System.out.println("Tipo de exclusividad (Familiar, Oro, Diamante):");
                	String tipoExclusividad = scanner.nextLine();

                	System.out.println("Tiempo disponible en días:");
                	int tiempo = scanner.nextInt();
                	scanner.nextLine();

                	System.out.println("Descripción de la atracción:");
                	String desc = scanner.nextLine();
                	
                	System.out.println("¿Es un evento de temporada? (true/false):");
                	boolean esEvento = scanner.nextBoolean();

                	System.out.println("Edad mínima para ingresar:");
                	int edadMinima = scanner.nextInt();

                	System.out.println("¿Se ve afectada por clima extremo? (true/false):");
                	boolean climaExtremo = scanner.nextBoolean();
                	scanner.nextLine();

                	if (tipo == 1) {
                	    // ATRACCIÓN MECÁNICA
                	    System.out.println("Altura mínima (m):");
                	    double alturaMin = scanner.nextDouble();

                	    System.out.println("Altura máxima (m):");
                	    double alturaMax = scanner.nextDouble();

                	    System.out.println("Peso mínimo (kg):");
                	    double pesoMin = scanner.nextDouble();

                	    System.out.println("Peso máximo (kg):");
                	    double pesoMax = scanner.nextDouble();
                	    scanner.nextLine();

                	    System.out.println("Nivel de riesgo (medio / alto):");
                	    String riesgo = scanner.nextLine();

                	    Mecanica nuevaMec = new Mecanica(
                	        lugarAtr, cap, minEmp, tipoExclusividad, tiempo, desc,
                	        alturaMax, alturaMin, pesoMax, pesoMin, riesgo
                	    );
                	    admin.añadirAtraccion(atracciones, nuevaMec);
                	    System.out.println("Atracción mecánica creada exitosamente.");

                	} else {
                	    // ATRACCIÓN CULTURAL
                	    Cultural nuevaCultural = new Cultural(lugarAtr, cap, minEmp,
                	        tipoExclusividad, tiempo, desc, esEvento, edadMinima, climaExtremo);
                	    admin.añadirAtraccion(atracciones, nuevaCultural);
                	    System.out.println("Atracción cultural creada exitosamente.");
                	}
                	break;

                case 7:
                	System.out.println("Ingrese el número de lugar de la atracción que desea editar:");
                	int lugarEditar = scanner.nextInt();
                	scanner.nextLine(); // Limpiar buffer

                	Atraccion atraccionEditar = null;
                	for (Atraccion a : atracciones) {
                	    if (a.getlugar() == lugarEditar) {
                	        atraccionEditar = a;
                	        break;
                	    }
                	}

                	if (atraccionEditar == null) {
                	    System.out.println("Atracción no encontrada.");
                	    break;
                	}

                	// Mostrar datos actuales
                	System.out.println("\n--- Datos actuales de la atracción ---");
                	System.out.println("Capacidad máxima: " + atraccionEditar.getcapacidadMax());
                	System.out.println("Mínimo de empleados: " + atraccionEditar.getminimoEmpleados());
                	System.out.println("Tipo de exclusividad: " + atraccionEditar.gettipoExclusividad());
                	System.out.println("Tiempo disponible en días: " + atraccionEditar.gettiempoDisponibleEnDias());
                	System.out.println("Descripción: " + atraccionEditar.getdescripcion());

                	// Editar datos
                	System.out.println("\n--- Ingrese los nuevos valores ---");

                	System.out.print("Nueva capacidad máxima: ");
                	int nuevaCapacidad = scanner.nextInt();
                	scanner.nextLine();
                	atraccionEditar.setcapacidadMax(nuevaCapacidad);

                	System.out.print("Nuevo mínimo de empleados: ");
                	int nuevoMinimo = scanner.nextInt();
                	scanner.nextLine();
                	atraccionEditar.setminimoEmpleados(nuevoMinimo);

                	System.out.print("Nuevo tipo de exclusividad: ");
                	String nuevaExclusividad = scanner.nextLine();
                	atraccionEditar.settipoExclusividad(nuevaExclusividad);

                	System.out.print("Nuevo tiempo disponible en días: ");
                	int nuevoTiempo = scanner.nextInt();
                	scanner.nextLine();
                	atraccionEditar.settiempoDisponibleEnDias(nuevoTiempo);

                	System.out.print("Nueva descripción: ");
                	String nuevaDescripcion = scanner.nextLine();
                	atraccionEditar.setdescripcion(nuevaDescripcion);

                	System.out.println("\n✅ Atracción actualizada exitosamente.");
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
                    System.out.println("Guardando atracciones en archivo...");

                    guardarAtracciones(atracciones, "atracciones.txt");

                    System.out.println("Saliendo del programa. 👋");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }

    // Métodos auxiliares
    public static Empleado buscarEmpleado(ArrayList<Empleado> empleados, int id) {
        for (Empleado e : empleados) {
            if (e.getidEmpleado() == id) return e;
        }
        return null;
    }

    public static Atraccion buscarAtraccion(ArrayList<Atraccion> atracciones, int lugar) {
        for (Atraccion a : atracciones) {
            if (a.getlugar() == lugar) return a;
        }
        return null;
    }
    
    public static void guardarAtracciones(ArrayList<Atraccion> atracciones, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
            for (Atraccion a : atracciones) {
                if (a instanceof Mecanica) {
                    Mecanica m = (Mecanica) a;
                    writer.println("M;" + m.getlugar() + ";" + m.getcapacidadMax() + ";" + m.getminimoEmpleados()
                            + ";" + m.gettipoExclusividad() + ";" + m.gettiempoDisponibleEnDias() + ";" + m.getdescripcion()
                            + ";" + m.getalturaMax() + ";" + m.getalturaMin() + ";" + m.getpesoMax() + ";" + m.getpesoMin()
                            + ";" + m.nivelRiesgo());
                } else if (a instanceof Cultural) {
                    Cultural c = (Cultural) a;
                    writer.println("C;" + c.getlugar() + ";" + c.getcapacidadMax() + ";" + c.getminimoEmpleados()
                            + ";" + c.gettipoExclusividad() + ";" + c.gettiempoDisponibleEnDias() + ";" + c.getdescripcion()
                            + ";" + c.getedadMinima());
                }
            }
            System.out.println("✅ Atracciones guardadas exitosamente en: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar las atracciones: " + e.getMessage());
        }
    }


}
