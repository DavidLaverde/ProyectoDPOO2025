package scr.personas;

import java.util.ArrayList;
import scr.atracciones.Atraccion;

public class Administrador {
    private String nombre;
    private String correo;
    private String contraseña;
    private int idAdmin;

    public Administrador(String nombre, String correo, String contraseña, int idAdmin) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.idAdmin = idAdmin;
    }

    // Getters y Setters
    public int getIdAdmin() {
        return idAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    // MÉTODOS PARA ATRACCIONES
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

    // MÉTODOS PARA EMPLEADOS
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
        ArrayList<String> puesto,
        boolean manejaMec,
        ArrayList<String> manejaMecAlto,
        ArrayList<String> turno
    ) {
        empleado.setLugarDeTrabajo(lugarDeTrabajo);
        empleado.setCocinero(cocinero);
        empleado.setPuesto(puesto);
        empleado.setManejaMec(manejaMec);
        empleado.setManejaMecAlto(manejaMecAlto);
        empleado.setTurno(turno);


        System.out.println("Empleado editado exitosamente.");
    }
}

