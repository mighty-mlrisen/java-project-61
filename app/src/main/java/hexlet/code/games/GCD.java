package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {

    private static final int NUMBER_OF_QUESTIONS = 3;
    private static final int COUNT_OF_ROUNDS = 3;
    private static final int COUNT_OF_DATA = 2;

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
        String question = GCD.generateGCDQuestion();
        String correctAnswer = GCD.getGCDCorrectAnswer(question);
        String[] values = {question, correctAnswer};
        return values;
    }

    public static String generateGCDQuestion() {
        final int maxNumber = 101;
        int number1 = Utils.generateNumber(1, maxNumber);
        int number2 = Utils.generateNumber(1, maxNumber);
        String question = Integer.toString(number1) + " " + Integer.toString(number2);
        return question;
    }

    public static String getGCDCorrectAnswer(String question) {
        String[] values = question.split(" ");
        int number1 = Integer.parseInt(values[0]);
        int number2 = Integer.parseInt(values[1]);
        int temp = GCD.getMinOfNumbers(number1, number2);
        int nod = 1;
        for (int i = temp; i > 0; i -= 1) {
            if (number1 % i == 0 && number2 % i == 0) {
                nod = i;
                return Integer.toString(nod);
            }
        }
        return Integer.toString(nod);
    }

    private static int getMinOfNumbers(int number1, int number2) {
        int temp;
        if (number1 > number2) {
            temp = number2;
        } else {
            temp = number1;
        }
        return temp;
    }
}
