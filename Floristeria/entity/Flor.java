package Floristeria.entity;

/**
 * La clase Flor representa una flor en la floristería.
 * Extiende la clase Producto, heredando sus propiedades y métodos,
 * y añade la propiedad específica del color de la flor.
 */
public class Flor extends Producto {
    private static final long serialVersionUID = 1L;

    /**
     * El color de la flor.
     */
    protected String color;

    /**
     * Constructor por defecto que crea una instancia de Flor sin inicializar el color.
     */
    public Flor() {
        // Este constructor está intencionalmente vacío, deja la inicialización a los setters.
    }

    /**
     * Constructor para crear una nueva flor con un precio específico y un color.
     * 
     * @param precio El precio de la flor.
     * @param color El color de la flor.
     */
    public Flor(double precio, String color) {
        super(precio);  // Llama al constructor de la superclase Producto
        this.color = color;
    }

    /**
     * Obtiene el color de la flor.
     *
     * @return El color actual de la flor.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color de la flor.
     *
     * @param color El nuevo color de la flor.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve una representación en cadena de la flor, incluyendo su precio y color.
     *
     * @return Una cadena que representa la flor con detalles de precio y color.
     */
    @Override
    public String toString() {
        return "Flor [precio=" + precio + ", color=" + color + "]";
    }
}
