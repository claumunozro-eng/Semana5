/**
 * Tarea ejecutable por un hilo: retira pedidos y los entrega
 */

package speedfast;

/**
 *
 * @author claum
 */

public class Repartidor implements Runnable {
    private final String nombre;
    private final ZonaDeCarga zonaDeCarga;
    private final long tiempoEntregaMs;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this(nombre, zonaDeCarga, 800);
    }

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga, long tiempoEntregaMs) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
        this.tiempoEntregaMs = tiempoEntregaMs;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Pedido pedido = zonaDeCarga.retirarPedido();
            if (pedido == null) {
                System.out.printf("[%s] No quedan pedidos. Fin de turno.%n", nombre);
                return;
            }

            pedido.setEstado(EstadoPedido.EN_REPARTO);
            System.out.printf("[%s] RetirÃ³ pedido %d para %s. Estado: %s%n",
                    nombre, pedido.getId(), pedido.getDireccionEntrega(), pedido.getEstado());
            try {
                Thread.sleep(tiempoEntregaMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("[%s] Entrega del pedido %d interrumpida.%n", nombre, pedido.getId());
                return;
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.printf("[%s] EntregÃ³ pedido %d. Estado: %s%n",
                    nombre, pedido.getId(), pedido.getEstado());
        }
    }
}

