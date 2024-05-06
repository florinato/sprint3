package Floristeria.entity;

import java.io.Serializable;

/**
 * Clase abstracta Producto que define la estructura y comportamiento básicos 
 * de los productos que pueden ser vendidos en la floristería.
 * Esta clase es serializable para permitir su almacenamiento y recuperación 
 * de forma persistente, como en archivos o bases de datos.
 */
public abstract class Producto implements Serializable {
    /**
     * El precio del producto.
     */
    protected double precio;

    /**
     * Constructor por defecto para Producto.
     * Crea un producto sin precio inicial, útil para inicialización via setters o serialización.
     */
    public Producto() {
        // Constructor intencionadamente vacío para permitir inicialización posterior y uso en serialización
    }

    /**
     * Constructor que inicializa un Producto con un precio dado.
     *
     * @param precio El precio del producto.
     */
    public Producto(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio actual del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Proporciona una representación en cadena del Producto, mostrando su precio.
     * Este método puede ser sobreescrito por subclases para incluir detalles adicionales específicos del producto.
     *
     * @return Una representación en cadena del producto que incluye su precio.
     */
    @Override
    public String toString() {
        return "Producto [precio=" + precio + "]";
    }
}
