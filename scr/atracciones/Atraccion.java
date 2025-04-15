package scr.atracciones;

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
	
	//Getters publicos
	public int getlugar() {
		return lugar;
	}
	
	public int getcapacidadMax() {
		return capacidadMax;
	}
	
	public int getminimoEmpleados() {
		return minimoEmpleados;
	}    
	
	public String gettipoExclusividad() {
		return tipoExclusividad;
	}
	
	public int gettiempoDisponibleEnDias() {
		return tiempoDisponibleEnDias;
	}
	
	public String getdescripcion() {
		return descripcion;
	}
    
    //Seters Publicos
    public void setlugar(int lugar) {
    	if (lugar >= 0) {
    		this.lugar = lugar;
    	}
	}
    
    public void setcapacidadMax(int capacidadMax) {
    	if (capacidadMax > 0) {
    		this.capacidadMax = capacidadMax;
    	}
    }
    
    public void setminimoEmpleados(int minimoEmpleados) {
    	if (minimoEmpleados > 0) {
    		this.minimoEmpleados = minimoEmpleados;
    	}
    }
    
    public void settipoExclusividad(String tipoExclusividad) {
    	this.tipoExclusividad = tipoExclusividad;
    }
    
    public void settiempoDisponibleEnDias(int tiempoDisponibleEnDias) {
    	if (tiempoDisponibleEnDias > 0) {
    		this.tiempoDisponibleEnDias = tiempoDisponibleEnDias;
    	}
    }
    
    public void setdescripcion(String descripcion) { 
    	this.descripcion = descripcion; 
    }

}