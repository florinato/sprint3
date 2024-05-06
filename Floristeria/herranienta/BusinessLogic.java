package Floristeria.herranienta;

import java.util.List;

import Floristeria.entity.Producto;
import Floristeria.entity.Ticket;

/**
 * La clase BusinessLogic encapsula las operaciones de negocio para una floristería,
 * específicamente manejando la creación y recuperación de tickets de venta.
 */
public class BusinessLogic {
    /**
     * Manejador de tickets que almacena y recupera tickets.
     */
    private TicketManager ticketManager = new TicketManager();

    /**
     * Procesa una venta agregando productos a un ticket y luego almacenando ese ticket
     * en el sistema a través del TicketManager.
     *
     * @param productos Lista de productos que serán añadidos al ticket.
     */
    public void processSale(List<Producto> productos) {
        Ticket newTicket = new Ticket();
        productos.forEach(newTicket::afegirProducte);  // Añade cada producto al nuevo ticket
        ticketManager.addTicket(newTicket);  // Guarda el ticket a través del manejador de tickets
    }

    /**
     * Recupera todos los tickets de venta almacenados en el TicketManager.
     *
     * @return Una lista de todos los tickets generados y almacenados hasta el momento.
     */
    public List<Ticket> getAllTickets() {
        return ticketManager.getTickets();
    }
}

