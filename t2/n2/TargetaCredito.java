package t2.n2;

class TarjetaCredito implements MetodoPago {
    @Override
    public void pagar(double cantidad) {
        System.out.println("Pagado " + cantidad + " con Tarjeta de Crédito");
    }
}
