package t2.n3;

class ConvertidorMonedaSimple implements ConvertidorMoneda {
    @Override
    public double convertir(double cantidad, String monedaOrigen, String monedaDestino) {
        double tasaCambio = 1.0; // Tasa por defecto si no hay cambio de moneda

        // Definimos algunas tasas de cambio aproximadas
        if (monedaOrigen.equals("EUR") && monedaDestino.equals("USD")) {
            tasaCambio = 1.1; // Ejemplo: 1 EUR = 1.1 USD
        } else if (monedaOrigen.equals("USD") && monedaDestino.equals("EUR")) {
            tasaCambio = 0.9; // Ejemplo: 1 USD = 0.9 EUR
        }
        return cantidad * tasaCambio;
    }

}