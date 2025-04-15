package scr.personas;
import java.util.ArrayList;

public class Empleado {
	public int idEmpleado;
	public int lugarDeTrabajo;
	public boolean cocinero;
	public ArrayList<String> cargo;
	public boolean manejoMec;
	public ArrayList<String> manejoMecAlto;
	public ArrayList<String> turno;

	public Empleado(int idEmpleado, int lugarDeTrabajo, boolean cocinero, ArrayList<String> cargo,
			boolean manejoMec, ArrayList<String> manejoMecAlto, ArrayList<String> turno) {
		this.idEmpleado = idEmpleado;
		this.lugarDeTrabajo = lugarDeTrabajo;
		this.cocinero = cocinero;
		this.cargo = new ArrayList<>();
		this.manejoMec = manejoMec;
		this.manejoMecAlto = new ArrayList<>();
		this.turno = new ArrayList<>();
	}
	
	// Getters
	public int getidEmpleado() {
		return idEmpleado;
	}
	
	public int getlugarDeTrabajo() {
		return lugarDeTrabajo;
	}
	
	public boolean getcocinero() {
		return cocinero;
	}
	
	public ArrayList<String> getcargo () {
		return cargo;
	}
	
	public boolean getmanejoMec () {
		return manejoMec;
	}
	
	public ArrayList<String> getmanejoMecAlto() {
		return manejoMecAlto;
	}
	
	public ArrayList<String> getturno() {
		return turno;
	}
	
	//Setters publicos
	public void setidEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public void setlugarDeTrabajo(int lugarDeTrabajo) {
		this.lugarDeTrabajo = lugarDeTrabajo;
	}
	
	public void setcocinero(boolean cocinero) {
		this.cocinero = cocinero;
	}
	
	public void setcargo(ArrayList<String> cargo) {
		this.cargo = cargo;
	}
	
	public void setmanejoMec(boolean manejoMec) {
		this.manejoMec = manejoMec;
	}
	
	public void setmanejoMecAlto(ArrayList<String> manejoMecAlto) {
		this.manejoMecAlto = manejoMecAlto;
	}
	
	public void setturno(ArrayList<String> turno) {
		this.turno = turno;
	}
}
