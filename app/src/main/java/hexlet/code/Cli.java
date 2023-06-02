package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void launchGreeting() {
        System.out.println("\n" + "Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }
}
