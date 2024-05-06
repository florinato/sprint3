package t1.n1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Undo undo = Undo.getInstance();

        while (true) {
            System.out.println("Introduce un comando (add <comando>, remove, list, exit):");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            } else if (input.startsWith("add ")) {
                undo.addCommand(input.substring(4));
            } else if (input.equals("remove")) {
                undo.removeLastCommand();
            } else if (input.equals("list")) {
                undo.listCommands();
            }
        }
        scanner.close();
    }
}
