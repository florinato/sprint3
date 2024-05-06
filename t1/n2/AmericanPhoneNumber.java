package t1.n2;

public class AmericanPhoneNumber implements PhoneNumber {
    private String phoneNumber;

    // Constructor
    public AmericanPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Métodos para establecer y obtener el número
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        // Retorna el número en el formato estadounidense
        return this.phoneNumber;
    }
}
