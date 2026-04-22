package notificaciones.canales;

public class ResultadoEnvio {
    private boolean exito;
    private String detalle;

    public ResultadoEnvio() {}

    public ResultadoEnvio(boolean exito, String detalle) {
        this.exito = exito;
        this.detalle = detalle;
    }

    public boolean isExito() { return exito; }
    public boolean getExito() { return exito; }
    public void setExito(boolean exito) { this.exito = exito; }

    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }

    @Override
    public String toString() {
        return "ResultadoEnvio {\n" +
                "  exito: " + exito + "\n" +
                "  detalle: " + detalle + "\n" +
                "}";
    }
}