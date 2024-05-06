package t2.n2;

class DebitoBancario implements MetodoPago {
    @Override
    public void pagar(double cantidad) {
        System.out.println("Pagado " + cantidad + " mediante Débito Bancario");
    }
}