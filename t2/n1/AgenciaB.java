package t2.n1;

public class AgenciaB implements AgenciaDeBolsa {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Agencia B: " + mensaje);
    }
}