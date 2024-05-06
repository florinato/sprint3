package t1.n3;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de diferentes vehículos
        Vehiculo coche = new Coche();
        Vehiculo bicicleta = new Bicicleta();

        // Crear comandos para el coche
        Command arrancarCoche = new ArrancarCommand(coche);
        Command acelerarCoche = new AcelerarCommand(coche);
        Command frenarCoche = new FrenarCommand(coche);

        // Crear comandos para la bicicleta
        Command arrancarBicicleta = new ArrancarCommand(bicicleta);
        Command acelerarBicicleta = new AcelerarCommand(bicicleta);
        Command frenarBicicleta = new FrenarCommand(bicicleta);

        // Crear el invocador (ControlRemoto)
        ControlRemoto controlRemoto = new ControlRemoto();

        // Asignar y ejecutar comandos para el coche
        System.out.println("Controlando el coche:");
        controlRemoto.setArrancarCommand(arrancarCoche);
        controlRemoto.setAcelerarCommand(acelerarCoche);
        controlRemoto.setFrenarCommand(frenarCoche);
        
        controlRemoto.arrancarVehiculo();
        controlRemoto.acelerarVehiculo();
        controlRemoto.frenarVehiculo();

        // Asignar y ejecutar comandos para la bicicleta
        System.out.println("\nControlando la bicicleta:");
        controlRemoto.setArrancarCommand(arrancarBicicleta);
        controlRemoto.setAcelerarCommand(acelerarBicicleta);
        controlRemoto.setFrenarCommand(frenarBicicleta);

        controlRemoto.arrancarVehiculo();
        controlRemoto.acelerarVehiculo();
        controlRemoto.frenarVehiculo();
    }
}

