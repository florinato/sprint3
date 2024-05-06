package t2.n2;

class TiendaZapatos {
    private PasarelaPago pasarela;

    public TiendaZapatos(PasarelaPago pasarela) {
        this.pasarela = pasarela;
    }

    public void realizarVenta(double cantidad, MetodoPago metodoPago) {
        pasarela.procesarPago(metodoPago, cantidad);
        System.out.println("Venta realizada por " + cantidad);
    }

    public static void main(String[] args) {
        PasarelaPago pasarela = new PasarelaPago();
        TiendaZapatos tienda = new TiendaZapatos(pasarela);

        // Ejemplo de pago con tarjeta de crédito
        MetodoPago tarjeta = new TarjetaCredito();
        tienda.realizarVenta(100.0, tarjeta);

        // Ejemplo de pago con PayPal
        MetodoPago paypal = new PayPal();
        tienda.realizarVenta(200.0, paypal);

        // Ejemplo de pago con débito bancario
        MetodoPago debito = new DebitoBancario();
        tienda.realizarVenta(150.0, debito);
    }
}