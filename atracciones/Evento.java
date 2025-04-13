package atracciones;

import java.time.LocalDateTime;

public class Evento extends Cultural {
	public LocalDateTime fechaYhora;
	
	public Evento(int lugar, int capacidadMax, int minimoEmpleados, String tipoExclusividad, int tiempoDisponibleEnDias, String descripcion,
            boolean esEvento, int edadMinima, boolean climaExtremo, LocalDateTime fechaYhora) {
  super(lugar, capacidadMax, minimoEmpleados, tipoExclusividad, tiempoDisponibleEnDias, descripcion,
        esEvento, edadMinima, climaExtremo);
  this.fechaYhora = fechaYhora;
	}
	
	public void setFechaYhora(LocalDateTime fechaYhora) {
		this.fechaYhora = fechaYhora;
	}
}
