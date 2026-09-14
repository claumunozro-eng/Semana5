SpeedFast - Semana 5

**Autor:** Claudia Muñoz  
**Asignatura:** Desarrollo Orientado a Objetos II

## Descripción

Este proyecto simula el despacho concurrente de pedidos de la empresa SpeedFast. Tres repartidores trabajan en paralelo retirando pedidos desde una zona de carga compartida.

La clase `ZonaDeCarga` utiliza métodos sincronizados para evitar que dos repartidores retiren el mismo pedido. Cada pedido pasa por los estados `PENDIENTE`, `EN_REPARTO` y `ENTREGADO`.

## Estructura del proyecto

```text
src/main/java/speedfast/
├── Main.java
├── Pedido.java
├── EstadoPedido.java
├── ZonaDeCarga.java
└── Repartidor.java
```

## Requisitos aplicados

- Uso de `Thread` y `Runnable`.
- Tres hilos de repartidores.
- Cinco pedidos iniciales.
- Recurso compartido protegido con `synchronized`.
- Estados de pedido mediante `enum`.
- Mensajes por consola que muestran el trabajo concurrente.

## Ejecución en IntelliJ IDEA

1. Abre la carpeta del proyecto en IntelliJ IDEA.
2. Verifica que `src/main/java` esté marcado como **Sources Root**.
3. Ejecuta la clase `Main` del package `speedfast`.
4. Revisa la consola para ver el retiro y la entrega de los pedidos.

Al finalizar se mostrará el mensaje:

```text
Todos los pedidos han sido entregados correctamente.
```
