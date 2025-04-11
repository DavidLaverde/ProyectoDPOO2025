package atracciones;

public class LugarDeServicio extends Atraccion {
    private String tipo;

    public LugarDeServicio(int lugar, int capacidadMax, int minimoEmpleados,
			String tipoExclusividad, int tiempoDisponibleEnDias, String descripcion,
			boolean esEvento, int edadMinima, boolean climaExtremo) {
		super(lugar, capacidadMax, minimoEmpleados, tipoExclusividad, tiempoDisponibleEnDias,
				descripcion);
	}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return super.getDescripcion();
    }
}