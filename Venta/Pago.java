package Venta;

public class Pago.java
    private int idTransaccion;
    private String tipoTicket;
    private String tipoDescuento;
    private String metodoPago;
    private double cantidadPagar;

    public Pago(int idTransaccion, String tipoTicket, String tipoDescuento, String metodoPago, double cantidadPagar) {
        this.idTransaccion = idTransaccion;
        this.tipoTicket = tipoTicket;
        this.tipoDescuento = tipoDescuento;
        this.metodoPago = metodoPago;
        this.cantidadPagar = cantidadPagar;
    }

    public double calcularDescuento() {
        double descuento = 0;
        switch (tipoDescuento.toLowerCase()) {
            case "ninguno":
                descuento = 0;
                break;
            case "estudiante":
                descuento = 0.15;
                break;
            case "discapacidad":
                descuento = 0.30;
                break;
            case "adulto_mayor":
                descuento = 0.20;
                break;
            case "empleado":
                descuento = 0.35;
                break;
            default:
                descuento = 0;
        }
        return cantidadPagar * descuento;
    }

    public boolean procesarPago() {
        System.out.println("Procesando pago por $" + (cantidadPagar - calcularDescuento()) + " usando " + metodoPago);
        return true;
    }

    public String generarFactura() {
        return "Factura\nID Transacción: " + idTransaccion +
               "\nTipo Ticket: " + tipoTicket +
               "\nMétodo de Pago: " + metodoPago +
               "\nTotal: $" + cantidadPagar +
               "\nDescuento: $" + calcularDescuento() +
               "\nTotal Final: $" + (cantidadPagar - calcularDescuento());
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public double getTotalConDescuento() {
        return cantidadPagar - calcularDescuento();
    }
}
 