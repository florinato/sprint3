package t1.n1;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    // La única instancia de Undo
    private static Undo instance;
    // Lista para guardar los comandos
    private List<String> commands;

    // Constructor privado para evitar instanciación externa
    private Undo() {
        commands = new ArrayList<>();
    }

    // Método estático para obtener la instancia
    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    // Método para añadir comandos
    public void addCommand(String command) {
        commands.add(command);
    }

    // Método para eliminar el último comando
    public void removeLastCommand() {
        if (!commands.isEmpty()) {
            commands.remove(commands.size() - 1);
        }
    }

    // Método para listar comandos
    public void listCommands() {
        for (String command : commands) {
            System.out.println(command);
        }
    }
}
