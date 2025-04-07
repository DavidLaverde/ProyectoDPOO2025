package atracciones;

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
}

