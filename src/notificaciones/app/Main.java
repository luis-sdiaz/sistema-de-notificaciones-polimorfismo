package notificaciones.app;

import notificaciones.canales.*;
import notificaciones.dominio.*;
import notificaciones.servicio.ServicioNotificaciones;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    private static void separador(String titulo) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println(titulo);
        System.out.println("==================================================");
    }

    public static void main(String[] args) {
        Usuario u = new Usuario("U1", "Luis Diaz", "luis@email.com", "5551234567", "TOKEN123");

        NotificacionPagoMatricula n1 = new NotificacionPagoMatricula(
                "N001",
                u,
                "Recuerda pagar tu matrícula del periodo 2026-1.",
                "2026-1",
                new BigDecimal("2500.00"),
                LocalDate.now().plusDays(5)
        );

        CanalNotificacion email = new CanalEmail("smtp.gmail.com", 587, "Aviso Universidad");
        CanalNotificacion sms = new CanalSMS("Twilio");
        CanalNotificacion push = new CanalPushApp("APP-UNI-01");

        ServicioNotificaciones<Notificacion> servicio = new ServicioNotificaciones<>();

        separador("1) ENVIO POR EMAIL");
        ResultadoEnvio r1 = servicio.procesarEnvio(n1, email);
        System.out.println("Canal: " + email.getNombre());
        System.out.println("Resultado: " + r1);
        System.out.println("Notificacion:\n" + n1);

        separador("2) ENVIO POR SMS Y PUSH (SOBRECARGA)");
        List<ResultadoEnvio> resultados = servicio.procesarEnvio(n1, List.of(sms, push));
        System.out.println("Resultados:");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println("  - " + resultados.get(i));
        }
        System.out.println("Notificacion final:\n" + n1);
    }
}