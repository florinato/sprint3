package t1.n3;

public class Bicicleta implements Vehiculo {

    @Override
    public void arrancar() {
        
        System.out.println("La bicicleta está arrancando. Empezando a pedalear.");
    }
    @Override
    public void acelerar() {
       
        System.out.println("La bicicleta está acelerando. Pedalear más rápido!");
    }
    @Override
    public void frenar() {
        
        System.out.println("La bicicleta está frenando. Aplicando los frenos.");
    }
}

