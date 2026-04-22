# Sistema de Notificaciones (Polimorfismo)

Descripción
-----------
Proyecto en Java que implementa un sistema de notificaciones para una universidad. El sistema soporta varios tipos de notificaciones (publicación de calificaciones, recordatorio de pago de matrícula, cancelación de clase, confirmación de inscripción a eventos) y múltiples canales de envío (correo electrónico, SMS, notificación en aplicación). El diseño está pensado para crecer sin rediseñar la base (Open/Closed Principle).

Contenido del repositorio
-------------------------
- `src/` — código fuente Java.
- `IMG_0952.jpeg` — fotografía/escaneo del diagrama de clases entregado a mano.
- `DiagramaClasesNotificaciones.heic` — fotografía/escaneo del diagrama de clases entregado a mano para descargar con mayor calidad.
- `README.md` — este documento.
Objetivo
--------
Entregar un diseño orientado a objetos que:
- Sea claro y mantenible.
- Permita añadir nuevos tipos de notificación y nuevos canales sin cambios en las clases existentes (extensible).
- Aplique polimorfismo para separar comportamiento por responsabilidades y facilitar pruebas.

Visión de alto nivel / Arquitectura
----------------------------------
- `Notificacion` (abstracta) — clase base que contiene los atributos comunes: `codigo`, `destinatario`, `mensaje`, `fechaEnvio`, `estado`.
- Subclases de `Notificacion` — `NotificacionCalificaciones`, `NotificacionPagoMatricula`, `NotificacionCancelacionClase`, `NotificacionInscripcionEvento`. Cada subclase construye su propio mensaje específico.
- `CanalNotificacion` (interfaz) — define `ResultadoEnvio enviar(Notificacion n)`. Implementaciones: `CanalEmail`, `CanalSMS`, `CanalPushApp`.
- `ServicioNotificaciones<T extends Notificacion>` — orquesta el envío. Mantiene una colección de `CanalNotificacion` (agregación) y ofrece métodos para procesar envíos (uno por canal, otro para múltiples canales).

Decisiones de diseño (resumen técnico)
--------------------------------------
- Principio Open/Closed: añadir nuevos canales o tipos de notificación no requiere modificar clases existentes.
- Single Responsibility: cada clase tiene responsabilidad única (modelo de notificación, canal, servicio).
- Dependency Inversion: `ServicioNotificaciones` depende de la interfaz `CanalNotificacion`, no de implementaciones concretas.
- Testabilidad: separación por interfaz permite mockear canales en pruebas unitarias.

Polimorfismo aplicado (qué, cómo y por qué)
-------------------------------------------
En este proyecto utilizamos varias formas de polimorfismo. Aquí las explicamos con ejemplos y el valor que aportan.

1) Polimorfismo de subtipo (básico y principal — runtime)
   - Qué es: un cliente trabaja con referencias a la superclase o a la interfaz, pero en tiempo de ejecución la implementación concreta decide el comportamiento.
   - Dónde:
     - `Notificacion` (abstracta) ← `NotificacionCalificaciones`, `NotificacionPagoMatricula`, ...
     - `CanalNotificacion` (interfaz) ← `CanalEmail`, `CanalSMS`, `CanalPushApp`
   - Ejemplo de uso:
     ```java
     Notificacion n = new NotificacionPagoMatricula(...);
     CanalNotificacion canal = new CanalEmail(...);
     ResultadoEnvio r = canal.enviar(n); // comportamiento concreto: CanalEmail.enviar
     ```
   - Beneficio: permite añadir nuevos canales o notificaciones sin tocar el código que los utiliza (Servicio, tests, etc.).

2) Polimorfismo paramétrico (genéricos — compile-time)
   - Qué es: el uso de parámetros de tipo para escribir código genérico y reutilizable.
   - Dónde:
     - `ServicioNotificaciones<T extends Notificacion>`
   - Ejemplo de uso:
     ```java
     ServicioNotificaciones<Notificacion> servicio = new ServicioNotificaciones<>(canales);
     servicio.procesarEnvio(n, canales);
     ```
   - Beneficio: seguridad de tipos en tiempo de compilación y flexibilidad para especializar servicios para subtipos concretos si se requiere.

3) Polimorfismo ad-hoc por sobrecarga (compile-time)
   - Qué es: varias firmas de método con el mismo nombre pero diferentes parámetros.
   - Dónde:
     - `procesarEnvio(n, canal)` y `procesarEnvio(n, canales)` en `ServicioNotificaciones`.
     - Sobrecarga de constructores en clases de dominio.
   - Ejemplo:
     ```java
     servicio.procesarEnvio(n, canal);
     servicio.procesarEnvio(n, List<CanalNotificacion> canales);
     ```
   - Beneficio: interfaz más expresiva y cómoda para el consumidor del servicio.

Resumen del beneficio global del polimorfismo
- Flexibilidad para extender comportamientos (añadir canales o notificaciones).
- Menor acoplamiento y mayor cohesión.
- Facilita la implementación de pruebas unitarias (mocks/stubs de `CanalNotificacion`).
- Mantiene claro el flujo de responsabilidad y la separación entre “qué” es una notificación y “cómo” se entrega.

Ejemplo mínimo de uso
---------------------
```java
List<CanalNotificacion> canales = List.of(new CanalEmail(...), new CanalSMS(...));
ServicioNotificaciones<Notificacion> servicio = new ServicioNotificaciones<>(canales);

Notificacion notif = new NotificacionPagoMatricula("N-001", usuario, "Recordatorio", "2026-Q1", new BigDecimal("200.00"), LocalDate.of(2026,3,1));
List<ResultadoEnvio> resultados = servicio.procesarEnvio(notif, canales);
