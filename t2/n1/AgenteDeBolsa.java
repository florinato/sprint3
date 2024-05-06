package t2.n1;
import java.util.ArrayList;
import java.util.List;

public class AgenteDeBolsa {
    private List<AgenciaDeBolsa> agencias;
    private String estadoBolsa;

    public AgenteDeBolsa() {
        this.agencias = new ArrayList<>();
    }

    public void agregarAgencia(AgenciaDeBolsa agencia) {
        this.agencias.add(agencia);
    }

    public void notificarObservadores() {
        for (AgenciaDeBolsa agencia : agencias) {
            agencia.actualizar(estadoBolsa);
        }
    }

    public void cambiarEstadoBolsa(String nuevoEstado) {
        this.estadoBolsa = nuevoEstado;
        notificarObservadores();
    }
}

