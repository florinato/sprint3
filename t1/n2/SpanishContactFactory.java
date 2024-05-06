package t1.n2;

// Fábrica para España
public class SpanishContactFactory implements ContactFactory {
    @Override
    public Address createAddress(String Address) {
         // Crea una instancia de SpanishAddress con la dirección proporcionada
        return new SpanishAddress(Address);
    }

    @Override
    public PhoneNumber createPhoneNumber(String PhoneNumber) {
        // Crea una instancia de SpanishPhoneNumber con el número de teléfono proporcionado
        return new SpanishPhoneNumber(PhoneNumber);
    }
    
}

