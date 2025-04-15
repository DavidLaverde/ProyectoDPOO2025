package scr.atracciones;

public class Mecanica extends Atraccion {
    public double alturaMax;
    public double alturaMin;
    public double pesoMax;
    public double pesoMin;
    public String nivelRiesgo;

    public Mecanica(int lugar, int capacidadMax, int minimoEmpleados, String tipoExclusividad, int tiempoDisponibleEnDias, String descripcion,
                    double alturaMax, double alturaMin, double pesoMax, double pesoMin, String nivelRiesgo) {
        super(lugar, capacidadMax, minimoEmpleados, tipoExclusividad, tiempoDisponibleEnDias, descripcion);
        this.alturaMax = alturaMax;
        this.alturaMin = alturaMin;
        this.pesoMax = pesoMax;
        this.pesoMin = pesoMin;
        this.nivelRiesgo = nivelRiesgo;
    }

    public boolean puedeIngresarMec(boolean discapacidad, double altura, double peso) {
        if (discapacidad == false && altura >= alturaMin && 
        		altura <= alturaMax && peso >= pesoMin && peso <= pesoMax) {
        	return true;
        }
        else {
        	return false;
        }
   }
    
    //Geters
    public double getalturaMax() {
    	return alturaMax;
    }
    
    public double getalturaMin() {
    	return alturaMin;
    }
    
    public double getpesoMax() {
    	return pesoMax;
    }
    
    public double getpesoMin() {
    	return pesoMin;
    }
    
    public String nivelRiesgo() {
    	return nivelRiesgo;
    }
    
    //Seters Publicos
    public void setalturaMax(double alturaMax) {
    	if (alturaMax > 0) {
    		this.alturaMax = alturaMax;
    	}
    }
    
    public void setalturaMin(double alturaMin) {
    	if (alturaMin > 0) {
    		this.alturaMin = alturaMin;
    	}
    }
    
    public void setpesoMax(double pesoMax) {
    	if (pesoMax > 0) {
    		this.pesoMax = pesoMax;
    	}
    }
    
    public void setpesoMin(double pesoMin) {
    	if (pesoMin > 0) {
    		this.pesoMin = pesoMin;
    	}
    }
    
    public void setnivelRiesgo(String nivelRiesgo) {
    	this.nivelRiesgo = nivelRiesgo;
    }
}

