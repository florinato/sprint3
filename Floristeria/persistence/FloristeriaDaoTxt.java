package Floristeria.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Floristeria.entity.Arbre;
import Floristeria.entity.Decoracio;
import Floristeria.entity.Flor;
import Floristeria.entity.Ticket;

/**
 * Implementación del DAO (Data Access Object) para manejar la persistencia de los datos
 * de la floristería en archivos utilizando serialización.
 */
public class FloristeriaDaoTxt implements FloristeriaDao {
    private static final String ARBRES_FILE = "src/main/java/Floristeria/dat/arbres.dat";
    private static final String FLORS_FILE = "src/main/java/Floristeria/dat/flors.dat";
    private static final String DECORACIONS_FILE = "src/main/java/Floristeria/dat/decoracions.dat";
    private static final String TICKETS_FILE = "src/main/java/Floristeria/dat/tickets.dat";
    /**
     * Añade un árbol al archivo persistente.
     * @param arbre El árbol a añadir.
     */
    public void afegirArbre(Arbre arbre) {
        List<Arbre> arbres = getArbres();
        arbres.add(arbre);
        try {
            SerializationUtil.serialize(arbres, ARBRES_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recupera la lista de árboles desde el archivo persistente.
     * @return Una lista de árboles, puede estar vacía si ocurre un error.
     */
    @SuppressWarnings("unchecked")
    public List<Arbre> getArbres() {
        try {
            return (List<Arbre>) SerializationUtil.deserialize(ARBRES_FILE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Elimina un árbol del archivo persistente usando un índice.
     * @param index El índice del árbol a eliminar.
     */
    public void eliminarArbre(int index) {
        List<Arbre> arbres = getArbres();
        if (index >= 0 && index < arbres.size()) {
            arbres.remove(index);
            try {
                SerializationUtil.serialize(arbres, ARBRES_FILE);
            } catch (IOException e) {
                System.err.println("Error al guardar la lista de árboles actualizada: " + e.getMessage());
            }
        }
    }

    /**
     * Añade una flor al archivo persistente.
     * @param flor La flor a añadir.
     */
    public void afegirFlor(Flor flor) {
        List<Flor> flors = getFlors();
        flors.add(flor);
        try {
            SerializationUtil.serialize(flors, FLORS_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recupera la lista de flores desde el archivo persistente.
     * @return Una lista de flores, puede estar vacía si ocurre un error.
     */
    @SuppressWarnings("unchecked")
    public List<Flor> getFlors() {
        try {
            return (List<Flor>) SerializationUtil.deserialize(FLORS_FILE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Elimina una flor del archivo persistente usando un índice.
     * @param index El índice de la flor a eliminar.
     */
    public void eliminarFlor(int index) {
        List<Flor> flors = getFlors();
        if (index >= 0 && index < flors.size()) {
            flors.remove(index);
            try {
                SerializationUtil.serialize(flors, FLORS_FILE);
            } catch (IOException e) {
                System.err.println("Error al guardar la lista de flores actualizada: " + e.getMessage());
            }
        } else {
            System.out.println("Índice fuera de rango: No se pudo eliminar la flor.");
        }
    }

    /**
     * Añade una decoración al archivo persistente.
     * @param decoracio La decoración a añadir.
     */
    public void afegirDecoracio(Decoracio decoracio) {
        List<Decoracio> decoracions = getDecoracions();
        decoracions.add(decoracio);
        try {
            SerializationUtil.serialize(decoracions, DECORACIONS_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recupera la lista de decoraciones desde el archivo persistente.
     * @return Una lista de decoraciones, puede estar vacía si ocurre un error.
     */
    @SuppressWarnings("unchecked")
    public List<Decoracio> getDecoracions() {
        try {
            return (List<Decoracio>) SerializationUtil.deserialize(DECORACIONS_FILE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Elimina una decoración del archivo persistente usando un índice.
     * @param index El índice de la decoración a eliminar.
     */
    public void eliminarDecoracio(int index) {
        List<Decoracio> decoracions = getDecoracions();
        if (index >= 0 && index < decoracions.size()) {
            decoracions.remove(index);
            try {
                SerializationUtil.serialize(decoracions, DECORACIONS_FILE);
            } catch (IOException e) {
                System.err.println("Error al guardar la lista de decoraciones actualizada: " + e.getMessage());
            }
        } else {
            System.out.println("Índice fuera de rango: No se pudo eliminar la decoración.");
        }
    }

    /**
     * Registra un nuevo ticket en el archivo persistente.
     * @param ticket El ticket a registrar.
     */
    public void registrarTicket(Ticket ticket) {
        List<Ticket> tickets = getTickets();
        tickets.add(ticket);
        try {
            SerializationUtil.serialize(tickets, TICKETS_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Recupera la lista de tickets desde el archivo persistente.
     * @return Una lista de tickets, puede estar vacía si ocurre un error.
     */
    @SuppressWarnings("unchecked")
    public List<Ticket> getTickets() {
        try {
            return (List<Ticket>) SerializationUtil.deserialize(TICKETS_FILE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
