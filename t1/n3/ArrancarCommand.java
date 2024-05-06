package t1.n3;

public class ArrancarCommand implements Command {
    private Vehiculo vehiculo;

    public ArrancarCommand(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void execute() {
        vehiculo.arrancar();
    }
}
