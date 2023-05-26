package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Set;
import hexlet.code.Utils;

public class Prime {

    private static final int NUMBER_OF_QUESTIONS = 3;
    private static final int COUNT_OF_ROUNDS = 3;
    private static final int COUNT_OF_DATA = 2;
    public static void startGame(int gameNumber) {
        String nameOfUser = Cli.launchGreeting();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Prime.playPrimeGame(gameNumber, nameOfUser);
    }

    public static void playPrimeGame(int gameNumber, String nameOfUser) {
        String[][] values = new String[COUNT_OF_ROUNDS][COUNT_OF_DATA];
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            String[] dataOfRound = Prime.generateRoundData(gameNumber);
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values, nameOfUser);
    }

    public static String[] generateRoundData(int gameNumber) {
        return Set.checkGame(gameNumber);
    }

    public static String generatePrimeQuestion() {
        final int maxNumber = 100;
        int number = Utils.generateNumber(1, maxNumber);
        return Integer.toString(number);
    }

    public static String getPrimeCorrectAnswer(String question) {
        int number = Integer.parseInt(question);
        if (number == 1) {
            return "no";
        }
        for (int d = 2; d * d <= number; d++) {
            if (number % d == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
