package t2.n3;

public class Main {
    public static void main(String[] args) {
        ConvertidorMoneda convertidor = new ConvertidorMonedaSimple();
        MostradorPrecios mostrador = new MostradorPrecios(convertidor);
        // Ejemplo de conversión
        mostrador.mostrarPrecio(100, "EUR", "USD");
        mostrador.mostrarPrecio(100, "USD", "EUR");
    }
}
