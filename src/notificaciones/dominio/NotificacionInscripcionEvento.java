package notificaciones.dominio;

import java.time.LocalDate;

public class NotificacionInscripcionEvento extends Notificacion {
    private String evento;
    private LocalDate fechaEvento;
    private String lugar;

    public NotificacionInscripcionEvento() {}

    public NotificacionInscripcionEvento(String codigo, Usuario destinatario, String mensaje,
                                         String evento, LocalDate fechaEvento, String lugar) {
        super(codigo, destinatario, mensaje);
        this.evento = evento;
        this.fechaEvento = fechaEvento;
        this.lugar = lugar;
    }

    public String getEvento() { return evento; }
    public void setEvento(String evento) { this.evento = evento; }

    public LocalDate getFechaEvento() { return fechaEvento; }
    public void setFechaEvento(LocalDate fechaEvento) { this.fechaEvento = fechaEvento; }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    @Override
    public String toString() {
        return "NotificacionInscripcionEvento {\n" +
                "  codigo: " + getCodigo() + "\n" +
                "  destinatario: " + getDestinatario() + "\n" +
                "  mensaje: " + getMensaje() + "\n" +
                "  fechaEnvio: " + getFechaEnvio() + "\n" +
                "  estado: " + getEstado() + "\n" +
                "  evento: " + evento + "\n" +
                "  fechaEvento: " + fechaEvento + "\n" +
                "  lugar: " + lugar + "\n" +
                "}";
    }
}
