package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    private static final int NUMBER_OF_QUESTIONS = 3;
    private static final int COUNT_OF_ROUNDS = 3;
    private static final int COUNT_OF_DATA = 2;

    public static void playEvenGame() {
        String description0fGame = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] values = new String[COUNT_OF_ROUNDS][COUNT_OF_DATA];
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            String[] dataOfRound = Even.generateRoundData();
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values, description0fGame);
    }

    public static String[] generateRoundData() {
        String question = Even.generateEvenQuestion();
        String correctAnswer;
        if (Even.isEven(question)) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        String[] values = {question, correctAnswer};
        return values;
    }

    public static String generateEvenQuestion() {
        final int maxNumber = 1000;
        int number = Utils.generateNumber(0, maxNumber);
        return Integer.toString(number);
    }

    public static boolean isEven(String question) {
        int number = Integer.parseInt(question);
        return number % 2 == 0;
    }
}
