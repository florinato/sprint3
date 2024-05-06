package Floristeria.entity;

/**
 * La clase Decoracio representa un artículo de decoración en la floristería.
 * Extiende la clase Producto, heredando sus métodos y propiedades,
 * y añade la propiedad específica del tipo de material.
 */
public class Decoracio extends Producto {
    private static final long serialVersionUID = 1L;

    /**
     * Tipo de material del artículo de decoración, como "fusta" (madera) o "plàstic" (plástico).
     */
    protected String tipoMaterial;

    /**
     * Constructor por defecto.
     */
    public Decoracio() {
        // Este constructor deja el objeto sin inicializar aparte de la inicialización de la superclase
    }

    /**
     * Constructor para crear un nuevo artículo de decoración con precio y tipo de material especificados.
     *
     * @param precio El precio del artículo de decoración.
     * @param tipoMaterial El tipo de material del artículo de decoración.
     */
    public Decoracio(double precio, String tipoMaterial) {
        super(precio);  // Llama al constructor de la superclase Producto
        this.tipoMaterial = tipoMaterial;
    }

    /**
     * Obtiene el tipo de material del artículo de decoración.
     *
     * @return El tipo de material del artículo de decoración.
     */
    public String getTipoMaterial() {
        return tipoMaterial;
    }

    /**
     * Establece el tipo de material del artículo de decoración.
     *
     * @param tipoMaterial El nuevo tipo de material del artículo de decoración.
     */
    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    /**
     * Devuelve una representación en cadena del artículo de decoración, incluyendo su precio y tipo de material.
     *
     * @return Una cadena que representa el artículo de decoración, incluyendo precio y tipo de material.
     */
    @Override
    public String toString() {
        return "Decoracio [precio=" + precio + ", tipoMaterial=" + tipoMaterial + "]";
    }
}
