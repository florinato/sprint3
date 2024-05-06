package Floristeria.persistence;

import java.util.Collection;
import java.util.List;

import Floristeria.entity.Arbre;
import Floristeria.entity.Decoracio;
import Floristeria.entity.Flor;
import Floristeria.entity.Ticket;

/**
 * Interfaz que define las operaciones de acceso a datos para una floristería.
 * Incluye métodos para añadir, eliminar y recuperar árboles, flores y decoraciones,
 * así como para gestionar y recuperar tickets de ventas.
 */
public interface FloristeriaDao {
    
    void afegirArbre(Arbre arbre);

    void afegirFlor(Flor flor);

    void afegirDecoracio(Decoracio decoracio);

    void eliminarArbre(int index);

    void eliminarFlor(int index);

    void eliminarDecoracio(int index);

    List<Arbre> getArbres();

    List<Flor> getFlors();

    List<Decoracio> getDecoracions();

    void registrarTicket(Ticket nuevoTicket);

    Collection<Ticket> getTickets();
}






