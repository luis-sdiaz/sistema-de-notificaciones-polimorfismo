package notificaciones.canales;

import notificaciones.dominio.Notificacion;

public class CanalSMS implements CanalNotificacion {
    private String proveedor;

    public CanalSMS() {}

    public CanalSMS(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getProveedor() { return proveedor; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }

    @Override
    public ResultadoEnvio enviar(Notificacion n) {
        return new ResultadoEnvio(true, "SMS enviado a " + n.getDestinatario().getTelefono());
    }

    @Override
    public String getNombre() {
        return "SMS";
    }

    @Override
    public String toString() {
        return "CanalSMS {\n" +
                "  proveedor: " + proveedor + "\n" +
                "}";
    }
}