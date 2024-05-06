package t1.n3;

class ControlRemoto {
    private Command arrancar;
    private Command acelerar;
    private Command frenar;

    // Método para asignar el comando de arrancar
    public void setArrancarCommand(Command arrancar) {
        this.arrancar = arrancar;
    }

    // Método para asignar el comando de acelerar
    public void setAcelerarCommand(Command acelerar) {
        this.acelerar = acelerar;
    }

    // Método para asignar el comando de frenar
    public void setFrenarCommand(Command frenar) {
        this.frenar = frenar;
    }

    // Método para ejecutar el comando de arrancar
    public void arrancarVehiculo() {
        if (arrancar != null) {
            arrancar.execute();
        }
    }

    // Método para ejecutar el comando de acelerar
    public void acelerarVehiculo() {
        if (acelerar != null) {
            acelerar.execute();
        }
    }

    // Método para ejecutar el comando de frenar
    public void frenarVehiculo() {
        if (frenar != null) {
            frenar.execute();
        }
    }
}


