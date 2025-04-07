package atracciones;

public class Cultural extends Atraccion {
	public boolean esEvento;
	public int edadMinima;
	public boolean climaExtremo;
	
	public Cultural(int lugar, int capacidadMax, int minimoEmpleados,
			String tipoExclusividad, int tiempoDisponibleEnDias, String descripcion,
			boolean esEvento, int edadMinima, boolean climaExtremo) {
		super(lugar, capacidadMax, minimoEmpleados, tipoExclusividad, tiempoDisponibleEnDias,
				descripcion);
		this.esEvento = esEvento;
		this.edadMinima = edadMinima;
		this.climaExtremo = climaExtremo;
	}
	
	public boolean puedeIngresarCult(int edad, int cantidadDePersonas) {
		if (edad >= edadMinima && climaExtremo == false && cantidadDePersonas <= capacidadMax) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
