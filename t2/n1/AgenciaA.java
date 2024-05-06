package t2.n1;

public class AgenciaA implements AgenciaDeBolsa {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Agencia A: " + mensaje);
    }
}