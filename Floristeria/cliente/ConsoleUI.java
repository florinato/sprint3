package Floristeria.cliente;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import Floristeria.entity.Arbre;
import Floristeria.entity.Decoracio;
import Floristeria.entity.Flor;
import Floristeria.entity.Producto;
import Floristeria.entity.Ticket;
import Floristeria.herranienta.Floristeria;
import Floristeria.persistence.FloristeriaDaoTxt;

/**
 * Clase principal que proporciona la interfaz de usuario por consola para la gestión de una floristería.
 * Permite realizar operaciones como agregar, retirar y mostrar productos y tickets.
 */
public class ConsoleUI {
    private static Floristeria floristeria;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Método principal que ejecuta la interfaz de usuario de la floristería.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    
    public static void menu(){
        String nombre = Input.inputString("Ingrese el nombre de la floristería: ");
        floristeria = new Floristeria(nombre, new FloristeriaDaoTxt());
        
        boolean running = true;
        while (running) {
            showMenu();
            int option = Input.inputInt("");

            switch (option) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    retirarProducto();
                    break;
                case 3:
                    imprimirStock();
                    break;
                case 4:
                    crearTicket();
                    break;
                case 5:
                    mostrarTickets();
                    break;
                case 6:
                    running = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    /**
     * Muestra el menú principal con las opciones disponibles en la consola.
     */
    private static void showMenu() {
        System.out.println("\nMenú de la Floristería:");
        System.out.println("1. Crear Producto");
        System.out.println("2. Retirar Producto");
        System.out.println("3. Mostrar Stock y Valor Total");
        System.out.println("4. Crear Ticket de Compra");
        System.out.println("5. Mostrar Tickets Antiguos");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }
    /**
     * Muestra los tickets existentes y los detalles de los productos asociados a cada ticket.
     */
    private static void mostrarTickets() {
        Collection<Ticket> tickets;
        try {
            tickets = floristeria.getDao().getTickets();
        } catch (Exception e) {
            System.out.println("Error al obtener tickets: " + e.getMessage());
            return;
        }
    
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets guardados.");
        } else {
            System.out.println("Tickets guardados:");
            for (Ticket ticket : tickets) {
                System.out.printf("Ticket - Total: $%.2f\n", ticket.calcularTotal());
                for (Producto producto : ticket.getProductos()) {
                    System.out.println("  - " + producto);
                }
            }
        }
    }
    /**
     * Permite crear un ticket y añadir diferentes tipos de productos a este.
     */
    private static void crearTicket() {
        Ticket nuevoTicket = new Ticket();
        boolean addingProducts = true;
        System.out.println("Creando un nuevo ticket...");
    
        while (addingProducts) {
            System.out.println("\nSeleccione el tipo de producto para añadir al ticket:");
            System.out.println("1. Árbol");
            System.out.println("2. Flor");
            System.out.println("3. Decoración");
            System.out.println("4. Finalizar y guardar ticket");
            System.out.print("Elija una opción: ");
            int choice = Input.inputInt("");
    
            switch (choice) {
                case 1:
                    addArbolToTicket(nuevoTicket);
                    break;
                case 2:
                    addFlorToTicket(nuevoTicket);
                    break;
                case 3:
                    addDecoracionToTicket(nuevoTicket);
                    break;
                case 4:
                    addingProducts = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    
        if (!nuevoTicket.getProductos().isEmpty()) {
            floristeria.registrarTicket(nuevoTicket);
            System.out.println("Ticket guardado exitosamente con total: $" + nuevoTicket.calcularTotal());
        } else {
            System.out.println("No se guardó ningún ticket, no se añadieron productos.");
        }
    }
    private static void addArbolToTicket(Ticket nuevoTicket) {
        System.out.println("Árboles disponibles:");
        List<Arbre> arbres = floristeria.getArbres();
        if (arbres.isEmpty()) {
            System.out.println("No hay árboles disponibles.");
            return;
        }
        for (int i = 0; i < arbres.size(); i++) {
            System.out.println((i + 1) + ". " + arbres.get(i));
        }
        System.out.print("Seleccione el número del árbol para añadir al ticket: ");
        int index = Input.inputInt("");
        if (index > 0 && index <= arbres.size()) {
            nuevoTicket.afegirProducte(arbres.get(index - 1));
            floristeria.eliminarArbre(index - 1);
            System.out.println("Árbol añadido al ticket.");
        } else {
            System.out.println("Selección inválida.");
        }
    }
    private static void addFlorToTicket(Ticket nuevoTicket) {
        System.out.println("Flores disponibles:");
        List<Flor> flors = floristeria.getFlors();
        if (flors.isEmpty()) {
            System.out.println("No hay flores disponibles.");
            return;
        }
        for (int i = 0; i < flors.size(); i++) {
            System.out.println((i + 1) + ". " + flors.get(i));
        }
        System.out.print("Seleccione el número de la flor para añadir al ticket: ");
        int florIndex = Input.inputInt("");
        if (florIndex > 0 && florIndex <= flors.size()) {
            nuevoTicket.afegirProducte(flors.get(florIndex - 1));
            floristeria.eliminarFlor(florIndex - 1);
            System.out.println("Flor añadida al ticket.");
        } else {
            System.out.println("Selección inválida.");
        }
    }
    private static void addDecoracionToTicket(Ticket nuevoTicket) {
        System.out.println("Decoraciones disponibles:");
        List<Decoracio> decoracions = floristeria.getDecoracions();
        if (decoracions.isEmpty()) {
            System.out.println("No hay decoraciones disponibles.");
            return;
        }
        for (int i = 0; i < decoracions.size(); i++) {
            System.out.println((i + 1) + ". " + decoracions.get(i));
        }
        System.out.print("Seleccione el número de la decoración para añadir al ticket: ");
        int decorIndex = Input.inputInt("");
        if (decorIndex > 0 && decorIndex <= decoracions.size()) {
            nuevoTicket.afegirProducte(decoracions.get(decorIndex - 1));
            floristeria.eliminarDecoracio(decorIndex - 1);
            System.out.println("Decoración añadida al ticket.");
        } else {
            System.out.println("Selección inválida.");
        }
    }
    private static void retirarDecoracio() {
        System.out.println("Eliminar una decoración");
        List<Decoracio> decoracions = floristeria.getDecoracions();
        if (decoracions.isEmpty()) {
            System.out.println("No hay decoraciones disponibles para eliminar.");
            return;
        }
    
        for (int i = 0; i < decoracions.size(); i++) {
            System.out.println((i + 1) + ". " + decoracions.get(i));
        }
        
        System.out.print("Seleccione el número de la decoración para eliminar: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();  // Limpiar buffer de entrada
    
        if (index >= 0 && index < decoracions.size()) {
            floristeria.eliminarDecoracio(index);
            System.out.println("Decoración eliminada exitosamente.");
        } else {
            System.out.println("Selección inválida.");
        }
    }
    

    private static void retirarArbre() {
        System.out.println("Eliminar un árbol");
        List<Arbre> arbres = floristeria.getArbres();
        if (arbres.isEmpty()) {
            System.out.println("No hay árboles disponibles para eliminar.");
            return;
        }
    
        for (int i = 0; i < arbres.size(); i++) {
            System.out.println((i + 1) + ". " + arbres.get(i));
        }
        int index = Input.inputInt("Seleccione el número del árbol para eliminar: ") - 1;
        scanner.nextLine();  // Limpiar buffer de entrada
    
        if (index >= 0 && index < arbres.size()) {
            floristeria.eliminarArbre(index);
            System.out.println("Árbol eliminado exitosamente.");
        } else {
            System.out.println("Selección inválida.");
        }
    }
    private static void retirarFlor() {
        System.out.println("Eliminar una flor");
        List<Flor> flores = floristeria.getFlors();
        if (flores.isEmpty()) {
            System.out.println("No hay flores disponibles para eliminar.");
            return;
        }
    
        // Mostrar flores disponibles
        for (int i = 0; i < flores.size(); i++) {
            System.out.println((i + 1) + ". " + flores.get(i));
        }
        
        // Pedir al usuario que elija una flor para eliminar
        int index = Input.inputInt("Seleccione el número de la flor para eliminar: ") - 1;
        if (index >= 0 && index < flores.size()) {
            floristeria.eliminarFlor(index);
            System.out.println("Flor eliminada exitosamente.");
        } else {
            System.out.println("Selección inválida.");
        }
    }
    private static void crearProducto() {
        System.out.println("Añadir un nuevo producto:");
        System.out.println("1. Árbol");
        System.out.println("2. Flor");
        System.out.println("3. Decoración");
        System.out.print("Seleccione el tipo de producto para añadir: ");
        int tipo = Input.inputInt("");
        
        switch (tipo) {
            case 1:  // Árbol
                addArbre();
                break;
            case 2:  // Flor
                addFlor();
                break;
            case 3:  // Decoración
                addDecoracio();
                break;
            default:
                System.out.println("Selección inválida.");
                break;
        }
    }
    private static void retirarProducto() {
        System.out.println("Retirar un producto:");
        System.out.println("1. Árbol");
        System.out.println("2. Flor");
        System.out.println("3. Decoración");
        System.out.print("Seleccione el tipo de producto para retirar: ");
        int tipo = Input.inputInt("");
        switch (tipo) {
            case 1:  // Árbol
                retirarArbre();
                break;
            case 2:  // Flor
                retirarFlor();
                break;
            case 3:  // Decoración
                retirarDecoracio();
                break;
            default:
                System.out.println("Selección inválida.");
                break;
        }
    }
    

    private static void addDecoracio() {
        System.out.println("Añadir una nueva decoración");
        String tipoMaterial = Input.inputString("Ingrese el tipo de material (madera/plástico): ");;
    
        
        double precio = Input.inputDouble("Ingrese el precio de la decoración: ");
    
        // Crear instancia de la decoración
        Decoracio decoracio = new Decoracio(precio, tipoMaterial);
    
        // Añadir decoración a la floristería
        floristeria.afegirDecoracio(decoracio);
    
        System.out.println("Decoración añadida exitosamente con material: " + tipoMaterial + " y precio: $" + precio);
    }
    
    private static void addFlor() {
        System.out.println("Añadir una nueva flor");
    
        System.out.print("Ingrese el color de la flor: ");
        String color = Input.inputString("");
    
        System.out.print("Ingrese el precio de la flor: ");
        double precio = Input.inputDouble("");
    
        // Crear instancia de la flor
        Flor flor = new Flor(precio, color);
    
        // Añadir flor a la floristería
        floristeria.afegirFlor(flor);
    
        System.out.println("Flor añadida exitosamente con color: " + color + " y precio: $" + precio);
    }
    

    private static void addArbre() {
        System.out.println("Añadir un nuevo árbol");
        
        System.out.print("Ingrese la altura del árbol (en metros): ");
        double altura = Input.inputDouble(""); 
        
        System.out.print("Ingrese el precio del árbol: ");
        double precio = Input.inputDouble("");

        // Crear instancia del árbol
        Arbre arbre = new Arbre(precio, altura);

        // Añadir árbol a la floristería
        floristeria.afegirArbre(arbre);

        System.out.println("Árbol añadido exitosamente con altura: " + altura + " m y precio: $" + precio);
    }


    private static void imprimirStock() {
        System.out.println("Stock de Árboles:");
        for (Arbre arbre : floristeria.getArbres()) {
            System.out.println(arbre);
        }
        System.out.println("Stock de Flores:");
        for (Flor flor : floristeria.getFlors()) {
            System.out.println(flor);
        }
        System.out.println("Stock de Decoraciones:");
        for (Decoracio decoracio : floristeria.getDecoracions()) {
            System.out.println(decoracio);
        }
        System.out.println("Valor total del stock: " + floristeria.calcularValorTotalStock());
    }
}
