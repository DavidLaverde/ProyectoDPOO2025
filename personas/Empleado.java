package personas;
import java.util.ArrayList;
import java.util.Date;

public class Empleado {
	public int idEmpleado;
	public int lugarDeTrabajo;
	public boolean cocinero;
	public ArrayList<String> cargo;
	public boolean manejoMec;
	public ArrayList<String> manejoMecAlto;
	public ArrayList<String> turno;
	
	public Empleado(int idEmpleado, int lugarDeTrabajo, boolean cocinero, ArrayList<String> cargo) {
        this.idEmpleado = idEmpleado;
        this.lugarDeTrabajo = lugarDeTrabajo;
        this.cocinero = cocinero;
        this.cargo = cargo;
        this.manejoAtracciones = new ArrayList<>();
        this.turnos = new ArrayList<>();
    }

}
