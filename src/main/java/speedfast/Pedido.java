/**
 * Representa una encomienda que debe ser retirada y entregada
 */

package speedfast;

/**
 *
 * @author claum
 */

public class Pedido {
    private final int id;
    private final String direccionEntrega;
    private EstadoPedido estado;

    public Pedido(int id, String direccionEntrega) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public int getId() { return id; }
    public String getDireccionEntrega() { return direccionEntrega; }
    public EstadoPedido getEstado() { return estado; }

    public void setEstado(EstadoPedido nuevoEstado) {
        if (nuevoEstado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
        estado = nuevoEstado;
    }

    public void setEstado(String nuevoEstado) {
        setEstado(EstadoPedido.valueOf(nuevoEstado.trim().toUpperCase()));
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", direccionEntrega='" + direccionEntrega
                + '\'' + ", estado=" + estado + '}';
    }
}

