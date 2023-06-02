package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {

    private static final int NUMBER_OF_QUESTIONS = 3;
    private static final int COUNT_OF_ROUNDS = 3;
    private static final int COUNT_OF_DATA = 2;
    private static final int MAX_NUMBER = 101;

    public static void playGCDGame() {
        String description0fGame = "Find the greatest common divisor of given numbers.";
        String[][] values = new String[COUNT_OF_ROUNDS][COUNT_OF_DATA];
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            String[] dataOfRound = GCD.generateRoundData();
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values, description0fGame);
    }

    public static String[] generateRoundData() {
        int number1 = Utils.generateNumber(1, MAX_NUMBER);
        int number2 = Utils.generateNumber(1, MAX_NUMBER);
        String question = Integer.toString(number1) + " " + Integer.toString(number2);
        int nod = GCD.getNod0fNumbers(number1, number2);
        String correctAnswer = Integer.toString(nod);
        String[] values = {question, correctAnswer};
        return values;
    }

    public static int getNod0fNumbers(int number1, int number2) {
        int temp = Math.min(number1, number2);
        int nod = 1;
        for (int i = temp; i > 0; i -= 1) {
            if (number1 % i == 0 && number2 % i == 0) {
                nod = i;
                return nod;
            }
        }
        return nod;
    }
}
