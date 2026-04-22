package notificaciones.dominio;

import java.time.LocalDate;

public class NotificacionCancelacionClase extends Notificacion {
    private String curso;
    private LocalDate fechaClase;
    private String motivo;

    public NotificacionCancelacionClase() {}

    public NotificacionCancelacionClase(String codigo, Usuario destinatario, String mensaje,
                                        String curso, LocalDate fechaClase, String motivo) {
        super(codigo, destinatario, mensaje);
        this.curso = curso;
        this.fechaClase = fechaClase;
        this.motivo = motivo;
    }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public LocalDate getFechaClase() { return fechaClase; }
    public void setFechaClase(LocalDate fechaClase) { this.fechaClase = fechaClase; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    @Override
    public String toString() {
        return "NotificacionCancelacionClase {\n" +
                "  codigo: " + getCodigo() + "\n" +
                "  destinatario: " + getDestinatario() + "\n" +
                "  mensaje: " + getMensaje() + "\n" +
                "  fechaEnvio: " + getFechaEnvio() + "\n" +
                "  estado: " + getEstado() + "\n" +
                "  curso: " + curso + "\n" +
                "  fechaClase: " + fechaClase + "\n" +
                "  motivo: " + motivo + "\n" +
                "}";
    }
}