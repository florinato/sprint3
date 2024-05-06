package t1.n2;

public class AmericanContactFactory implements ContactFactory {
    @Override
    public Address createAddress(String addressDetails) {
        // Crea una instancia de AmericanAddress con la dirección proporcionada
        return new AmericanAddress(addressDetails);
    }

    @Override
    public PhoneNumber createPhoneNumber(String phoneNumberDetails) {
        // Crea una instancia de AmericanPhoneNumber con el número de teléfono proporcionado
        return new AmericanPhoneNumber(phoneNumberDetails);
    }
}

