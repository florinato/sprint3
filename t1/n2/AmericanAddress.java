package t1.n2;

public class AmericanAddress implements Address {
    private String address;

    // Constructor
    public AmericanAddress(String address) {
        this.address = address;
    }

    // Métodos para establecer y obtener la dirección
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        // Retorna la dirección en el formato estadounidense
        return this.address;
    }
}
