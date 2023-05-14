package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;

public class App {
    private static final int GAME_NUMBER_EVEN = 2;
    private static final int GAME_NUMBER_CALC = 3;
    private static final int GAME_NUMBER_GCD = 4;
    private static final int GAME_NUMBER_PROGRESSION = 5;
    private static final int GAME_NUMBER_PRIME = 6;

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
        switch (number) {
            case 0:
                break;
            case 1:
                Cli.greeting();
                break;
            case GAME_NUMBER_EVEN:
                Even.startingGame();
                break;
            case GAME_NUMBER_CALC:
                Calc.startingGame();
                break;
            case GAME_NUMBER_GCD:
                GCD.startingGame();
                break;
            case GAME_NUMBER_PROGRESSION:
                Progression.startingGame();
                break;
            case GAME_NUMBER_PRIME:
                Prime.startingGame();
                break;
            default:
                return 0;
        }
        return number;
    }
}
