package notificaciones.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NotificacionPagoMatricula extends Notificacion {
    private String periodo;
    private BigDecimal monto;
    private LocalDate fechaLimite;

    public NotificacionPagoMatricula() {}

    public NotificacionPagoMatricula(String codigo, Usuario destinatario, String mensaje,
                                     String periodo, BigDecimal monto, LocalDate fechaLimite) {
        super(codigo, destinatario, mensaje);
        this.periodo = periodo;
        this.monto = monto;
        this.fechaLimite = fechaLimite;
    }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public LocalDate getFechaLimite() { return fechaLimite; }
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }

    @Override
    public String toString() {
        return "NotificacionPagoMatricula {\n" +
                "  codigo: " + getCodigo() + "\n" +
                "  destinatario: " + getDestinatario() + "\n" +
                "  mensaje: " + getMensaje() + "\n" +
                "  fechaEnvio: " + getFechaEnvio() + "\n" +
                "  estado: " + getEstado() + "\n" +
                "  periodo: " + periodo + "\n" +
                "  monto: " + monto + "\n" +
                "  fechaLimite: " + fechaLimite + "\n" +
                "}";
    }
}