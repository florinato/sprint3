package t2.n2;

class PasarelaPago {
    void procesarPago(MetodoPago metodoPago, double cantidad) {
        metodoPago.pagar(cantidad);
    }
}
