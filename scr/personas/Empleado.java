package scr.personas;

import java.util.ArrayList;

public class Empleado extends Usuario {
    private int idEmpleado;
    private int lugarTrabajo;
    private boolean esCocinero;
    private ArrayList<String> puesto;
    private boolean manejaMec;
    private ArrayList<String> manejaMecAlto;
    private ArrayList<String> turno;

    public Empleado(String nombre, String correo, String contraseña, int idEmpleado, int lugarTrabajo,
    		ArrayList<String> puesto, boolean esCocinero, boolean manejaMecanicos,
    		ArrayList<String> manejaMecAlto, ArrayList<String> turno) {
        super(nombre, correo, contraseña);
        this.idEmpleado = idEmpleado;
        this.lugarTrabajo = lugarTrabajo;
        this.esCocinero = esCocinero;
        this.puesto = puesto;
        this.manejaMec = manejaMecanicos;
        this.manejaMecAlto = manejaMecAlto;
        this.turno = turno;
    }

    // Getters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public int getLugarTrabajo() {
        return lugarTrabajo;
    }

    public ArrayList<String> getPuesto() {
        return puesto;
    }

    public boolean getEsCocinero() {
        return esCocinero;
    }

    public boolean getManejaMec() {
        return manejaMec;
    }

    public ArrayList<String> getManejaMecAlto() {
        return manejaMecAlto;
    }

    public ArrayList<String> getTurno() {
        return turno;
    }

    // Setters    
    public void setLugarDeTrabajo(int lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public void setPuesto(ArrayList<String> puesto) {
        this.puesto = puesto;
    }

    public void setCocinero(boolean esCocinero) {
        this.esCocinero = esCocinero;
    }

    public void setManejaMec(boolean manejaMec) {
        this.manejaMec = manejaMec;
    }

    public void setManejaMecAlto(ArrayList<String> manejaMecAlto) {
        this.manejaMecAlto = manejaMecAlto;
    }

    public void setTurno(ArrayList<String> turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", lugarTrabajo='" + lugarTrabajo + '\'' +
                ", esCocinero=" + esCocinero +
                ", puesto='" + puesto + '\'' +
                ", manejaMecanicos=" + manejaMec +
                ", manejaMecanicosAltoRiesgo=" + manejaMecAlto +
                ", turno='" + turno + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                '}';
    }
}
