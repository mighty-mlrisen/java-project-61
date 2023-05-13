package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n" + "2 - Even\n" + "3 - Calc\n" + "4 - GCD");
        System.out.println("5 - Progression\n" + "6 - Prime\n" + "0 - Exit");
        System.out.print("Your choice: ");
        Engine.playGame();
    }

    public static int gameSelection() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        final int gameNumberEven = 2, gameNumberCalc = 3, gameNumberGCD = 4, gameNumberProgression = 5;
        final int gameNumberPrime = 6;
        switch (number) {
            case 0:
                break;
            case 1:
                Cli.greeting();
                break;
            case gameNumberEven:
                Even.startingGame();
                break;
            case gameNumberCalc:
                Calc.startingGame();
                break;
            case gameNumberGCD:
                GCD.startingGame();
                break;
            case gameNumberProgression:
                Progression.startingGame();
                break;
            case gameNumberPrime:
                Prime.startingGame();
                break;
            default:
                return 0;
        }
        return number;
    }
}
