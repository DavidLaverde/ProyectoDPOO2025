package atracciones;

public class LugarDeServicio extends Atraccion {
    private String tipo;

    public LugarDeServicio(int lugar, int capacidadMax, int minimoEmpleados,
			String tipoExclusividad, int tiempoDisponibleEnDias, String descripcion,
			boolean esEvento, int edadMinima, boolean climaExtremo) {
		super(lugar, capacidadMax, minimoEmpleados, tipoExclusividad, tiempoDisponibleEnDias,
				descripcion);
	}
    
    //Geters
    public String getTipo() {
        return tipo;
    }

    //Seters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}