package Floristeria.herranienta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Floristeria.entity.Ticket;

public class TicketManager {
    // Define la ruta del archivo donde se guardarán los tickets.
    private static final String TICKETS_FILE = "src/main/java/Floristeria/dat/tickets.dat";

    /**
     * Añade un nuevo ticket a la lista existente de tickets y guarda la lista actualizada en el archivo.
     * @param ticket El ticket a añadir.
     */
    public void addTicket(Ticket ticket) {
        System.out.println("Añadiendo un nuevo ticket.");
        List<Ticket> tickets = getTickets();  // Recupera todos los tickets existentes
        tickets.add(ticket);                  // Añade el nuevo ticket
        saveTickets(tickets);                 // Guarda la lista actualizada
    }

    /**
     * Recupera todos los tickets del archivo.
     * @return Una lista de tickets.
     */
    @SuppressWarnings("unchecked")
    public List<Ticket> getTickets() {
        File file = new File(TICKETS_FILE);
        if (!file.exists() || file.length() == 0) {
            System.out.println("Archivo no existe o está vacío, retornando lista vacía.");
            return new ArrayList<>();  // Retorna una lista vacía si el archivo no existe o está vacío
        }
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (List<Ticket>) ois.readObject();  // Deserializa y retorna la lista de tickets
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al recuperar tickets: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();  // Retorna una lista vacía en caso de error
        }
    }

    /**
     * Guarda la lista completa de tickets en el archivo, sobrescribiendo cualquier contenido anterior.
     * @param tickets La lista de tickets a guardar.
     */
    private void saveTickets(List<Ticket> tickets) {
        System.out.println("Guardando " + tickets.size() + " tickets.");
        try (FileOutputStream fos = new FileOutputStream(TICKETS_FILE, false);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(tickets);  // Serializa y guarda la lista completa de tickets
            System.out.println("Tickets guardados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar tickets: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


