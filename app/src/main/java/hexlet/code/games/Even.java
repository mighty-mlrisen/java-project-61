package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    private static final int MAX_NUMBER = 1000;

    public static void playEvenGame() {
        String description0fGame = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] values = new String[Engine.COUNT_OF_ROUNDS][];
        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            values[i] = Even.generateRoundData();
        }
        Engine.launchGeneralStructure(values, description0fGame);
    }

    public static String[] generateRoundData() {
        int number = Utils.generateNumber(0, MAX_NUMBER);
        String correctAnswer;
        if (Even.isEven(number)) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        String question = Integer.toString(number);
        String[] values = {question, correctAnswer};
        return values;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
