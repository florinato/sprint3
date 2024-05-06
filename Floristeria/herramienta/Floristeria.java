package Floristeria.herramienta;

import java.util.List;

import Floristeria.entity.Arbre;
import Floristeria.entity.Decoracio;
import Floristeria.entity.Flor;
import Floristeria.entity.Producto;
import Floristeria.entity.Ticket;
import Floristeria.persistence.FloristeriaDao;
import Floristeria.persistence.FloristeriaDaoTxt;

/**
 * Clase Floristeria que gestiona las operaciones de negocio relacionadas con el manejo de productos
 * y tickets en una floristería utilizando un objeto DAO para la persistencia de datos.
 */
public class Floristeria {
    private String nom;  // Nombre de la floristería
    private FloristeriaDao dao; // Referencia al DAO que maneja la persistencia

    /**
     * Constructor para crear una nueva floristería.
     * @param nom El nombre de la floristería.
     * @param dao La implementación del DAO que manejará la persistencia.
     */
    public Floristeria(String nom, FloristeriaDao dao) {
        this.nom = nom;
        this.dao = dao;
    }

    /**
     * Obtiene el nombre de la floristería.
     * @return El nombre de la floristería.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Establece el nombre de la floristería.
     * @param nom El nuevo nombre de la floristería.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Añade un árbol al inventario de la floristería.
     * @param arbre El árbol a añadir.
     */
    public void afegirArbre(Arbre arbre) {
        dao.afegirArbre(arbre);
    }

    /**
     * Añade una flor al inventario de la floristería.
     * @param flor La flor a añadir.
     */
    public void afegirFlor(Flor flor) {
        dao.afegirFlor(flor);
    }

    /**
     * Añade una decoración al inventario de la floristería.
     * @param decoracio La decoración a añadir.
     */
    public void afegirDecoracio(Decoracio decoracio) {
        dao.afegirDecoracio(decoracio);
    }

    /**
     * Elimina un árbol del inventario por su índice.
     * @param index El índice del árbol a eliminar.
     */
    public void eliminarArbre(int index) {
        dao.eliminarArbre(index);
    }

    /**
     * Elimina una flor del inventario por su índice.
     * @param index El índice de la flor a eliminar.
     */
    public void eliminarFlor(int index) {
        dao.eliminarFlor(index);
    }

    /**
     * Elimina una decoración del inventario por su índice.
     * @param index El índice de la decoración a eliminar.
     */
    public void eliminarDecoracio(int index) {
        dao.eliminarDecoracio(index);
    }

    /**
     * Obtiene la lista de todos los árboles en el inventario.
     * @return Una lista de árboles.
     */
    public List<Arbre> getArbres() {
        return dao.getArbres();
    }

    /**
     * Obtiene la lista de todas las flores en el inventario.
     * @return Una lista de flores.
     */
    public List<Flor> getFlors() {
        return dao.getFlors();
    }

    /**
     * Obtiene la lista de todas las decoraciones en el inventario.
     * @return Una lista de decoraciones.
     */
    public List<Decoracio> getDecoracions() {
        return dao.getDecoracions();
    }

    /**
     * Calcula el valor total del stock disponible en la floristería.
     * @return El valor total del stock.
     */
    public double calcularValorTotalStock() {
        double total = 0;
        for (Arbre arbre : getArbres()) {
            total += arbre.getPrecio();
        }
        for (Flor flor : getFlors()) {
            total += flor.getPrecio();
        }
        for (Decoracio decoracio : getDecoracions()) {
            total += decoracio.getPrecio();
        }
        return total;
    }

    /**
     * Crea un ticket de compra para los productos especificados, registra el ticket,
     * y actualiza el inventario.
     * @param productos Los productos a incluir en el ticket.
     * @return El ticket creado o null si no se puede crear.
     */
    public Ticket crearTicketDeCompra(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            System.out.println("No hay productos para crear el ticket.");
            return null;  // Retorna null si no hay productos.
        }

        Ticket nuevoTicket = new Ticket();
        for (Producto producto : productos) {
            nuevoTicket.afegirProducte(producto);  // Añadir productos al ticket
        }

        try {
            dao.registrarTicket(nuevoTicket);  // Intentar registrar el ticket
            // Eliminar productos del inventario solo si el ticket se registra exitosamente
            for (Producto producto : productos) {
                int index;
                if (producto instanceof Arbre) {
                    index = getArbres().indexOf(producto);
                    if (index != -1) eliminarArbre(index);
                } else if (producto instanceof Flor) {
                    index = getFlors().indexOf(producto);
                    if (index != -1) eliminarFlor(index);
                } else if (producto instanceof Decoracio) {
                    index = getDecoracions().indexOf(producto);
                    if (index != -1) eliminarDecoracio(index);
                }
            }
            return nuevoTicket;
        } catch (Exception e) {
            System.err.println("No se pudo registrar el ticket: " + e.getMessage());
            return null;  // Retorna null si ocurre un error.
        }
    }

    /**
     * Devuelve la implementación DAO utilizada por la floristería.
     * @return El DAO utilizado por la floristería.
     */
    public FloristeriaDaoTxt getDao() {
        dao.getTickets();
        return (FloristeriaDaoTxt) dao;
    }

    /**
     * Registra un ticket de venta en el sistema.
     * @param nuevoTicket El ticket a registrar.
     */
    public void registrarTicket(Ticket nuevoTicket) {
        dao.registrarTicket(nuevoTicket);
    }
}
