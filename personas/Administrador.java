package personas;

import java.util.ArrayList;

public class Administrador {
    private int id;
    private String nombre;

    // Constructor
    public Administrador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos de acceso
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // ------------ MÉTODOS PARA ATRACCIONES ------------

    public void añadirAtraccion(ArrayList<Atraccion> atracciones, Atraccion nuevaAtraccion) {
        atracciones.add(nuevaAtraccion);
    }

    public void removerAtraccion(ArrayList<Atraccion> atracciones, Atraccion atraccion) {
        atracciones.remove(atraccion);
    }

    public void editarAtraccion(Atraccion atraccion, int capacidadMax, int minEmpleados, 
                                 int tipoDiscapacidad, int tiempoDuracion, String descripcion) {
        atraccion.setCapacidadMax(capacidadMax);
        atraccion.setMinEmpleados(minEmpleados);
        atraccion.setTipoDiscapacidad(tipoDiscapacidad);
        atraccion.setTiempoDuracion(tiempoDuracion);
        atraccion.setDescripcion(descripcion);
    }

    // ------------ MÉTODOS PARA EMPLEADOS ------------

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
