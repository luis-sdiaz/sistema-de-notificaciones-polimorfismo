package notificaciones.canales;

import notificaciones.dominio.Notificacion;

public interface CanalNotificacion {
    ResultadoEnvio enviar(Notificacion n);
    String getNombre();
}
