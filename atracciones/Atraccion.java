package atracciones;

public class Atraccion {
	public int lugar;
	public int capacidadMax;
	public int minimoEmpleados;
	public String tipoExclusividad;
	public int tiempoDisponibleEnDias;
	public String descripcion;
	
	public Atraccion(int lugar, int capacidadMax, int minimoEmpleados, String tipoExclusividad, int tiempoDisponibleEnDias, String descripcion) {
		this.lugar = lugar;
        this.capacidadMax = capacidadMax;
        this.minimoEmpleados = minimoEmpleados;
        this.tipoExclusividad = tipoExclusividad;
        this.tiempoDisponibleEnDias = tiempoDisponibleEnDias;
        this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
        return descripcion;
    }

    public int getTiempoDisponible() {
        return tiempoDisponibleEnDias;
    }

    public int getLugar() {
        return lugar;
    }

    public String getExclusividad() {
        return tipoExclusividad;
    }
    
    public void setLugar(int lugar) {
		this.lugar = lugar;
	}
    
    public void setcapacidadMax(int capacidadMax) {
    	this.capacidadMax = capacidadMax;
    }
    
    public void setminimoEmpleados(int minimoEmpleados) {
    	this.minimoEmpleados = minimoEmpleados;
    }
    
    public void setExclusividad(String tipoExclusividad) {
    	this.tipoExclusividad = tipoExclusividad;
    }
    
    public void setTiempoDisponibleEnDias(int tiempoDisponibleEnDias) {
    	this.tiempoDisponibleEnDias = tiempoDisponibleEnDias;
    }
    
    public void setDescripcion(String descripcion) { 
    	this.descripcion = descripcion; 
    }

}