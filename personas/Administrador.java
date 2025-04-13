package personas;

import java.util.ArrayList;
import atracciones.Atraccion;
import atracciones.Cultural;
import atracciones.Evento;
import atracciones.LugarDeServicio;
import atracciones.Mecanica;

public class Administrador {
    private int id;
    private String nombre;

    public Administrador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    //METODOS PARA ATRACCIONES
    public void añadirAtraccion(ArrayList<Atraccion> atracciones, Atraccion nuevaAtraccion) {
        atracciones.add(nuevaAtraccion);
    }

    public void removerAtraccion(ArrayList<Atraccion> atracciones, Atraccion atraccion) {
        atracciones.remove(atraccion);
    }

    public void editarAtraccion(Atraccion atraccion, int capacidadMax, int minimoEmpleados, 
                                 int tiempoDisponibleEnDias, String descripcion) {
        atraccion.setCapacidadMax(capacidadMax);
        atraccion.setMinimoEmpleados(minimoEmpleados);
        atraccion.setTiempoDisponibleEnDias(tiempoDisponibleEnDias);
        atraccion.setDescripcion(descripcion);
    }

    //METODOS PARA EMPLEADOS

    public void añadirEmpleado(ArrayList<Empleado> empleados, Empleado nuevoEmpleado) {
        empleados.add(nuevoEmpleado);
    }

    public void removerEmpleado(ArrayList<Empleado> empleados, Empleado empleado) {
        empleados.remove(empleado);
    }

    public void editarEmpleado(Empleado empleado, int lugarTrabajo, String cargo, boolean esBilingue) {
        empleado.setLugarTrabajo(lugarTrabajo);
        empleado.setCargo(cargo);
        empleado.setEsBilingue(esBilingue);
    }
}
