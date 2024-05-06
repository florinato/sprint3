package t2.n3;

class MostradorPrecios {
    private ConvertidorMoneda convertidor;

    public MostradorPrecios(ConvertidorMoneda convertidor) {
        this.convertidor = convertidor;
    }

    public void mostrarPrecio(double precio, String monedaOrigen, String monedaDestino) {
        double precioConvertido = convertidor.convertir(precio, monedaOrigen, monedaDestino);
        System.out.println("Precio en " + monedaDestino + ": " + precioConvertido);
    }
}
