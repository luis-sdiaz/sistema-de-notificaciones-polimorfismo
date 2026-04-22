package notificaciones.dominio;

import java.time.LocalDateTime;

public abstract class Notificacion {
    private String codigo;
    private Usuario destinatario;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private EstadoNotificacion estado;

    public Notificacion() {}

    public Notificacion(String codigo, Usuario destinatario, String mensaje) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.estado = EstadoNotificacion.PENDIENTE;
        this.fechaEnvio = null; // se asigna cuando se envía
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Usuario getDestinatario() { return destinatario; }
    public void setDestinatario(Usuario destinatario) { this.destinatario = destinatario; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    public EstadoNotificacion getEstado() { return estado; }
    public void setEstado(EstadoNotificacion estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Notificacion {\n" +
                "  codigo: " + codigo + "\n" +
                "  destinatario: " + destinatario + "\n" +
                "  mensaje: " + mensaje + "\n" +
                "  fechaEnvio: " + fechaEnvio + "\n" +
                "  estado: " + estado + "\n" +
                "}";
    }
}
