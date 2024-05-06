package t1.n2;

public class SpanishAddress implements Address {
    private String address;

    // Constructor para inicializar la dirección
    public SpanishAddress(String address) {
        this.address = address;
    }

    // Implementación del método getAddress de la interfaz Address
    @Override
    public String getAddress() {
        return address; // Devuelve la dirección almacenada
    }

    // Si necesitas cambiar la dirección, puedes añadir un método setter aquí
    public void setAddress(String address) {
        this.address = address;
    }
}
    

    


