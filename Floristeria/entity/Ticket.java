package Floristeria.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Ticket representa un ticket de venta en la floristería.
 * Cada ticket puede contener varios productos y calcula el total de la venta.
 */
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Lista de productos incluidos en este ticket.
     */
    private ArrayList<Producto> productos = new ArrayList<>();

    /**
     * Añade un producto al ticket.
     *
     * @param producto El producto a añadir al ticket.
     */
    public void afegirProducte(Producto producto) {
        productos.add(producto);
    }

    /**
     * Calcula el total del precio de todos los productos en el ticket.
     *
     * @return El total del precio de todos los productos en este ticket.
     */
    public double calcularTotal() {
        return productos.stream()
                        .mapToDouble(Producto::getPrecio)
                        .sum();
    }

    /**
     * Genera una representación en cadena del ticket, listando todos los productos
     * y el total de la venta.
     *
     * @return Una cadena que representa el contenido del ticket y el total de la venta.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Ticket:\n");
        for (Producto p : productos) {
            builder.append(p).append("\n");  // Asegura que Producto tenga un método toString() adecuado
        }
        builder.append("Total: ").append(calcularTotal());
        return builder.toString();
    }

    /**
     * Devuelve una lista de todos los productos en este ticket.
     *
     * @return Una lista inmutable de productos.
     */
    public List<Producto> getProductos() {
        return new ArrayList<>(productos); // Devuelve una copia para evitar modificaciones externas
    }
}
