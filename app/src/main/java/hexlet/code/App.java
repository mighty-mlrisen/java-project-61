package hexlet.code;

import hexlet.code.games.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n" + "2 - Even\n" + "3 - Calc\n" + "4 - GCD\n" + "5 - Progression\n" + "0 - Exit");
        System.out.print("Your choice: ");
        Engine.generalStructure();
    }

    public static int gameSelection() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        switch (number) {
            case 0:
                break;
            case 1:
                Cli.greeting();
                break;
            case 2:
                Even.startingGame();
                break;
            case 3:
                Calc.startingGame();
                break;
            case 4:
                GCD.startingGame();
            case 5:
                Progression.startingGame();
        }
        return number;
    }
}
