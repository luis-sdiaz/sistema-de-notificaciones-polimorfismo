package notificaciones.dominio;

public class NotificacionCalificaciones extends Notificacion {
    private String curso;
    private double nota;

    public NotificacionCalificaciones() {}

    public NotificacionCalificaciones(String codigo, Usuario destinatario, String mensaje, String curso, double nota) {
        super(codigo, destinatario, mensaje);
        this.curso = curso;
        this.nota = nota;
    }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    @Override
    public String toString() {
        return "NotificacionCalificaciones {\n" +
                "  codigo: " + getCodigo() + "\n" +
                "  destinatario: " + getDestinatario() + "\n" +
                "  mensaje: " + getMensaje() + "\n" +
                "  fechaEnvio: " + getFechaEnvio() + "\n" +
                "  estado: " + getEstado() + "\n" +
                "  curso: " + curso + "\n" +
                "  nota: " + nota + "\n" +
                "}";
    }
}