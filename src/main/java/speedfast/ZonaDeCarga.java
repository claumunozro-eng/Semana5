/**
 * Recurso compartido por todos los repartidores
 * La sincronizaciÃ³n impide que dos hilos retiren el mismo pedido
 */
package speedfast;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author claum
 */

public class ZonaDeCarga {
    private final Queue<Pedido> pedidosPendientes = new LinkedList<>();

    public synchronized void agregarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        pedidosPendientes.offer(pedido);
        System.out.printf("[Zona de carga] IngresÃ³ pedido %d. Pendientes: %d%n",
                pedido.getId(), pedidosPendientes.size());
    }

    public synchronized Pedido retirarPedido() {
        return pedidosPendientes.poll();
    }

    public synchronized int cantidadPendientes() {
        return pedidosPendientes.size();
    }
}

