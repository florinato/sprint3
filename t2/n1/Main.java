package t2.n1;


public class Main {
    public static void main(String[] args) {
        AgenteDeBolsa agente = new AgenteDeBolsa();
        
        AgenciaDeBolsa agenciaA = new AgenciaA();
        AgenciaDeBolsa agenciaB = new AgenciaB();

        agente.agregarAgencia(agenciaA);
        agente.agregarAgencia(agenciaB);

        agente.cambiarEstadoBolsa("La bolsa sube!");
        agente.cambiarEstadoBolsa("La bolsa baja!");
    }
}



