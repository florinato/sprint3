package t1.n3;

public class AcelerarCommand implements Command {
    private Vehiculo vehiculo;

    public AcelerarCommand(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void execute() {
        vehiculo.acelerar();
    }
}

