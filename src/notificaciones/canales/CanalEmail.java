package notificaciones.canales;

import notificaciones.dominio.Notificacion;

public class CanalEmail implements CanalNotificacion {
    private String smtpHost;
    private int smtpPort;
    private String asunto;

    public CanalEmail() {}

    public CanalEmail(String smtpHost, int smtpPort, String asunto) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.asunto = asunto;
    }

    public String getSmtpHost() { return smtpHost; }
    public void setSmtpHost(String smtpHost) { this.smtpHost = smtpHost; }

    public int getSmtpPort() { return smtpPort; }
    public void setSmtpPort(int smtpPort) { this.smtpPort = smtpPort; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    @Override
    public ResultadoEnvio enviar(Notificacion n) {
        return new ResultadoEnvio(true, "Email enviado a " + n.getDestinatario().getEmail());
    }

    @Override
    public String getNombre() {
        return "EMAIL";
    }

    @Override
    public String toString() {
        return "CanalEmail {\n" +
                "  smtpHost: " + smtpHost + "\n" +
                "  smtpPort: " + smtpPort + "\n" +
                "  asunto: " + asunto + "\n" +
                "}";
    }
}