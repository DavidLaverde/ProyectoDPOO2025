package scr.personas;

import java.util.ArrayList;

public class Empleado extends Usuario {
    private int idEmpleado;
    private int lugarTrabajo;
    private double salario;
    private ArrayList<String> puesto;
    private boolean esCocinero;
    private boolean manejaMec;
    private ArrayList<String> manejaMecAlto;
    private ArrayList<String> turno;

    public Empleado(String nombre, String correo, String contraseña, int idEmpleado, int lugarTrabajo, double salario,
    		ArrayList<String> puesto, boolean esCocinero, boolean manejaMecanicos,
    		ArrayList<String> manejaMecAlto, ArrayList<String> turno) {
        super(nombre, correo, contraseña);
        this.idEmpleado = idEmpleado;
        this.lugarTrabajo = lugarTrabajo;
        this.salario = salario;
        this.puesto = puesto;
        this.esCocinero = esCocinero;
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

    public double getSalario() {
        return salario;
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

    public void setSalario(double salario) {
        this.salario = salario;
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
                ", salario=" + salario +
                ", puesto='" + puesto + '\'' +
                ", esCocinero=" + esCocinero +
                ", manejaMecanicos=" + manejaMec +
                ", manejaMecanicosAltoRiesgo=" + manejaMecAlto +
                ", turno='" + turno + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                '}';
    }
}
