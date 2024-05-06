package t1.n2;

public class Main {
    public static void main(String[] args) {
        // Crear una fábrica española y usarla para crear una dirección y un número de teléfono españoles
        ContactFactory spanishFactory = new SpanishContactFactory();
        Address spanishAddress = spanishFactory.createAddress("Calle Falsa 123, Barcelona, España");
        PhoneNumber spanishPhoneNumber = spanishFactory.createPhoneNumber("900123456");

        // Crear una fábrica estadounidense y usarla para crear una dirección y un número de teléfono estadounidenses
        ContactFactory americanFactory = new AmericanContactFactory();
        Address americanAddress = americanFactory.createAddress("123 Fake Street, New York, NY");
        PhoneNumber americanPhoneNumber = americanFactory.createPhoneNumber("1234567890");

        // Imprimir los resultados
        System.out.println("Dirección Española: " + spanishAddress.getAddress());
        System.out.println("Teléfono Español: " + spanishPhoneNumber.getPhoneNumber());
        System.out.println("Dirección Americana: " + americanAddress.getAddress());
        System.out.println("Teléfono Americano: " + americanPhoneNumber.getPhoneNumber());
    }
}

