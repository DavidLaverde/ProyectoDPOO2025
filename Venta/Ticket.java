package Venta;

import java.time.LocalDateTime;

public class Ticket {
    private String tipoTicket; // Familiar, Oro, Diamante, Básico
    private boolean esBasico;
    private LocalDateTime inicioValidacion;
    private int tiempoDiasTicketValido;
    private String esIndividual; // sí/no
    private LocalDateTime diaFastpass;
    private String estado;

    public Ticket(String tipoTicket, boolean esBasico, LocalDateTime inicioValidacion, int tiempoDiasTicketValido, String esIndividual, LocalDateTime diaFastpass) {
        this.tipoTicket = tipoTicket;
        this.esBasico = esBasico;
        this.inicioValidacion = inicioValidacion;
        this.tiempoDiasTicketValido = tiempoDiasTicketValido;
        this.esIndividual = esIndividual;
        this.diaFastpass = diaFastpass;
        this.estado = "Activo";
    }

    public boolean validar() {
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime fechaExpiracion = inicioValidacion.plusDays(tiempoDiasTicketValido);
        if (ahora.isBefore(fechaExpiracion)) {
            this.estado = "Válido";
            return true;
        } else {
            this.estado = "Expirado";
            return false;
        }
    }

    public String getEstado() {
        return estado;
    }

    public String getTipoTicket() {
        return tipoTicket;
    }

    public String getEsIndividual() {
        return esIndividual;
    }

    public boolean isEsBasico() {
        return esBasico;
    }

    public LocalDateTime getDiaFastpass() {
        return diaFastpass;
    }

    public LocalDateTime getInicioValidacion() {
        return inicioValidacion;
    }

    public int getTiempoDiasTicketValido() {
        return tiempoDiasTicketValido;
    }
}
