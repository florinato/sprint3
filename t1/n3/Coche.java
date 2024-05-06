package t1.n3;
public class Coche implements Vehiculo {

    @Override
    public void arrancar() {
        
        System.out.println("El coche está arrancando. Motor encendido.");
    }

    @Override
    public void acelerar() {
        
        System.out.println("El coche está acelerando. Aumentando la velocidad.");
    }

    @Override
    public void frenar() {
        
        System.out.println("El coche está frenando. Pedal de freno presionado.");
    }
    
}

