package Floristeria.entity;

/**
 * La clase Arbre representa un árbol en la floristería.
 * Extiende la clase Producto, heredando sus métodos y propiedades,
 * y añade la propiedad específica de altura.
 */
public class Arbre extends Producto {
    private static final long serialVersionUID = 1L;

    /**
     * La altura del árbol en metros.
     */
    protected double altura;

    /**
     * Constructor por defecto.
     */
    public Arbre() {
        // Llama al constructor de la superclase Producto
    }

    /**
     * Constructor para crear un nuevo árbol con precio y altura especificados.
     *
     * @param precio El precio del árbol.
     * @param altura La altura del árbol en metros.
     */
    public Arbre(double precio, double altura) {
        super(precio);  // Llama al constructor de la superclase Producto
        this.altura = altura;
    }

    /**
     * Obtiene la altura del árbol.
     *
     * @return La altura del árbol en metros.
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Establece la altura del árbol.
     *
     * @param altura La nueva altura del árbol en metros.
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Devuelve una representación en cadena del árbol, incluyendo su precio y altura.
     *
     * @return Una cadena que representa el árbol, incluyendo precio y altura.
     */
    @Override
    public String toString() {
        return "Arbre [precio=" + precio + ", altura=" + altura + "]";
    }
}

