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
        App.launchSelection();
    }

    public static void launchSelection() {
        Scanner scanner = new Scanner(System.in);
        int gameNumber = scanner.nextInt();
        switch (gameNumber) {
            case 0:
                break;
            case 1:
                System.out.println("\n" + "Welcome to the Brain Games!");
                System.out.print("May I have your name? ");
                String userName = Cli.launchGreeting();
                System.out.println("Hello, " + userName + "!");
                break;
            case GAME_NUMBER_EVEN:
                Even.playEvenGame();
                break;
            case GAME_NUMBER_CALC:
                Calc.playCalcGame();
                break;
            case GAME_NUMBER_GCD:
                GCD.playGCDGame();
                break;
            case GAME_NUMBER_PROGRESSION:
                Progression.playProgressionGame();
                break;
            case GAME_NUMBER_PRIME:
                Prime.playPrimeGame();
                break;
            default:
                throw new Error("Unknown order of the game menu : " + gameNumber + " !");
        }
    }
}
