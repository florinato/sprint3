package t1.n3;

public class Barco implements Vehiculo {

    @Override
    public void arrancar() {
        System.out.println("El barco ha arrancado.");
    
    }

    @Override
    public void acelerar() {
        System.out.println("El barco está acelerando.");
    }

    @Override
    public void frenar() {
        System.out.println("El barco está frenando.");
    }
}
