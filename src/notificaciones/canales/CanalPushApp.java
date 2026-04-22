package notificaciones.canales;

import notificaciones.dominio.Notificacion;

public class CanalPushApp implements CanalNotificacion {
    private String appId;

    public CanalPushApp() {}

    public CanalPushApp(String appId) {
        this.appId = appId;
    }

    public String getAppId() { return appId; }
    public void setAppId(String appId) { this.appId = appId; }

    @Override
    public ResultadoEnvio enviar(Notificacion n) {
        return new ResultadoEnvio(true, "Push enviado a token " + n.getDestinatario().getTokenApp());
    }

    @Override
    public String getNombre() {
        return "PUSH_APP";
    }

    @Override
    public String toString() {
        return "CanalPushApp {\n" +
                "  appId: " + appId + "\n" +
                "}";
    }
}
