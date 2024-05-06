package t1.n3;

public class FrenarCommand implements Command {
    private Vehiculo vehiculo;

    public FrenarCommand(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void execute() {
        vehiculo.frenar();
    }
}
