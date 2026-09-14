/**
 * Punto de entrada de la simulaciÃ³n concurrente de SpeedFast
 */

package speedfast;

/**
 *
 * @author claum
 */

public class Main {
    public static void main(String[] args) {
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();
        zonaDeCarga.agregarPedido(new Pedido(101, "Av. Apoquindo 4500, Las Condes"));
        zonaDeCarga.agregarPedido(new Pedido(102, "San Diego 850, Santiago"));
        zonaDeCarga.agregarPedido(new Pedido(103, "VicuÃ±a Mackenna 2200, Ã‘uÃ±oa"));
        zonaDeCarga.agregarPedido(new Pedido(104, "Av. Providencia 1300, Providencia"));
        zonaDeCarga.agregarPedido(new Pedido(105, "Gran Avenida 5200, San Miguel"));

        Thread hiloAna = new Thread(new Repartidor("Ana", zonaDeCarga), "Hilo-Ana");
        Thread hiloBruno = new Thread(new Repartidor("Bruno", zonaDeCarga), "Hilo-Bruno");
        Thread hiloCarla = new Thread(new Repartidor("Carla", zonaDeCarga), "Hilo-Carla");

        System.out.println("\n--- Inicio de despachos concurrentes ---");
        hiloAna.start();
        hiloBruno.start();
        hiloCarla.start();

        esperarFinalizacion(hiloAna);
        esperarFinalizacion(hiloBruno);
        esperarFinalizacion(hiloCarla);
        System.out.println("\nTodos los pedidos han sido entregados correctamente.");
    }

    private static void esperarFinalizacion(Thread hilo) {
        try {
            hilo.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("La simulaciÃ³n fue interrumpida antes de finalizar.");
        }
    }
}

