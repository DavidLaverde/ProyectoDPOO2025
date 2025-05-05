package scr.personas;

public class Cliente extends Usuario {
    private int edad;
    private String metodoPago;

    public Cliente(String nombre, String correo, String contraseña, int edad, String metodoPago) {
        super(nombre, correo, contraseña);
        this.edad = edad;
        this.metodoPago = metodoPago;
    }

    // Getters
    public int getEdad() {
        return edad;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    // Setters
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + getNombre() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", edad=" + edad +
                ", metodoPago='" + metodoPago + '\'' +
                '}';
    }
}

