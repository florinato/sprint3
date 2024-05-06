package t1.n2;

// Número de teléfono en España
public class SpanishPhoneNumber implements PhoneNumber {
    private String phoneNumber;

    // Constructor que acepta un String como número de teléfono
    public SpanishPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Implementación de los métodos definidos en la interfaz PhoneNumber
    @Override
    public String getPhoneNumber() {
        
        return phoneNumber;
    }

    // Si necesitas un método para cambiar el número de teléfono
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

