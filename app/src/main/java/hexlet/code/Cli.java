package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String launchGreeting() {
        Scanner scanner = new Scanner(System.in);
        String nameUser = scanner.next();
        return nameUser;
    }
}
