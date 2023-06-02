package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {

    private static final int NUMBER_OF_QUESTIONS = 3;
    private static final int COUNT_OF_ROUNDS = 3;
    private static final int COUNT_OF_DATA = 2;
    private static final int MAX_NUMBER = 100;

    public static void playPrimeGame() {
        String description0fGame = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] values = new String[COUNT_OF_ROUNDS][COUNT_OF_DATA];
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            String[] dataOfRound = Prime.generateRoundData();
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values, description0fGame);
    }

    public static String[] generateRoundData() {
        int number = Utils.generateNumber(1, MAX_NUMBER);
        String question = Integer.toString(number);
        String correctAnswer;
        if (Prime.isPrime(number)) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        String[] values = {question, correctAnswer};
        return values;
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int d = 2; d * d <= number; d++) {
            if (number % d == 0) {
                return false;
            }
        }
        return true;
    }
}
