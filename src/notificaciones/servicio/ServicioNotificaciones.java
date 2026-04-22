package notificaciones.servicio;

import notificaciones.canales.CanalNotificacion;
import notificaciones.canales.ResultadoEnvio;
import notificaciones.dominio.EstadoNotificacion;
import notificaciones.dominio.Notificacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicioNotificaciones<T extends Notificacion> {
    private List<CanalNotificacion> canalesConfigurados;

    public ServicioNotificaciones() {
        this.canalesConfigurados = new ArrayList<>();
    }

    public ServicioNotificaciones(List<CanalNotificacion> canalesConfigurados) {
        this.canalesConfigurados = canalesConfigurados;
    }

    public List<CanalNotificacion> getCanalesConfigurados() {
        return canalesConfigurados;
    }

    public void setCanalesConfigurados(List<CanalNotificacion> canalesConfigurados) {
        this.canalesConfigurados = canalesConfigurados;
    }

    public ResultadoEnvio procesarEnvio(T n, CanalNotificacion canal) {
        ResultadoEnvio resultado = canal.enviar(n);

        n.setFechaEnvio(LocalDateTime.now());
        n.setEstado(resultado.getExito() ? EstadoNotificacion.ENVIADA : EstadoNotificacion.FALLIDA);

        return resultado;
    }

    public List<ResultadoEnvio> procesarEnvio(T n, List<CanalNotificacion> canales) {
        List<ResultadoEnvio> resultados = new ArrayList<>();
        for (CanalNotificacion canal : canales) {
            resultados.add(procesarEnvio(n, canal));
        }
        return resultados;
    }

    @Override
    public String toString() {
        return "ServicioNotificaciones{" +
                "canalesConfigurados=" + canalesConfigurados +
                '}';
    }
}