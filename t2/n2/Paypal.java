package t2.n2;

class PayPal implements MetodoPago {
    @Override
    public void pagar(double cantidad) {
        System.out.println("Pagado " + cantidad + " con PayPal");
    }
}
