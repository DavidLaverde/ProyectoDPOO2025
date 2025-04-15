package scr.personas;

import java.util.ArrayList;
import scr.atracciones.Atraccion;
import scr.atracciones.Cultural;
import scr.atracciones.Evento;
import scr.atracciones.LugarDeServicio;
import scr.atracciones.Mecanica;

public class Administrador {
    private int idAdmin;
    private String nombre;

    public Administrador(int idAdmin, String nombre) {
        this.idAdmin = idAdmin;
        this.nombre = nombre;
    }

    public int getidAdmin() {
        return idAdmin;
    }

    public String getnombre() {
        return nombre;
    }

    //METODOS PARA ATRACCIONES
    public void añadirAtraccion(ArrayList<Atraccion> atracciones, Atraccion nuevaAtraccion) {
        atracciones.add(nuevaAtraccion);
    }

    public void removerAtraccion(ArrayList<Atraccion> atracciones, Atraccion atraccion) {
        atracciones.remove(atraccion);
    }
    
    public void editarAtraccion(
            Atraccion atraccion,
            int lugar,
            int capacidadMax,
            int minimoEmpleados,
            String tipoExclusividad,
            int tiempoDisponibleEnDias,
            String descripcion
        ) {
    		atraccion.setlugar(lugar);
            atraccion.setcapacidadMax(capacidadMax);
            atraccion.setminimoEmpleados(minimoEmpleados);
            atraccion.settipoExclusividad(tipoExclusividad);
            atraccion.settiempoDisponibleEnDias(tiempoDisponibleEnDias);
            atraccion.setdescripcion(descripcion);

            System.out.println("Atracción editada exitosamente.");
        }

    //METODOS PARA EMPLEADOS

    public void añadirEmpleado(ArrayList<Empleado> empleados, Empleado nuevoEmpleado) {
        empleados.add(nuevoEmpleado);
    }

    public void removerEmpleado(ArrayList<Empleado> empleados, Empleado empleado) {
        empleados.remove(empleado);
    }

    public void editarEmpleado(
            Empleado empleado,
        	int lugarDeTrabajo,
        	boolean cocinero,
        	ArrayList<String> cargo,
        	boolean manejoMec,
        	ArrayList<String> manejoMecAlto,
        	ArrayList<String> turno
        ) {
            empleado.setlugarDeTrabajo(lugarDeTrabajo);
            empleado.setcocinero(cocinero);
            empleado.setcargo(cargo);
            empleado.setmanejoMec(manejoMec);
            empleado.setmanejoMecAlto(manejoMecAlto);
            empleado.setturno(turno);

            System.out.println("Atracción editada exitosamente.");
        }
}
