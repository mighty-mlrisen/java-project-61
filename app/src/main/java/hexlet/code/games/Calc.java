package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final int COUNT_OF_ROUNDS = 3;
    private static final int COUNT_OF_DATA = 2;

    public static void playCalcGame() {
        String description0fGame = "What is the result of the expression?";
        String[][] values = new String[COUNT_OF_ROUNDS][COUNT_OF_DATA];
        for (int i = 0; i < COUNT_OF_ROUNDS; i++) {
            String[] dataOfRound = Calc.generateRoundData();
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values, description0fGame);
    }

    public static String[] generateRoundData() {
        String question = Calc.generateCalcQuestion();
        String correctAnswer = Calc.getCalcCorrectAnswer(question);
        String[] values = {question, correctAnswer};
        return values;
    }

    public static String generateCalcQuestion() {
        final int maxIndex = 3;
        final int endOfRange = 20;
        final int beginningOfRange = 0;

        int number1 = Utils.generateNumber(beginningOfRange, endOfRange);
        int number2 = Utils.generateNumber(beginningOfRange, endOfRange);
        int index = Utils.generateNumber(beginningOfRange, maxIndex);
        String[] operations = {"+", "*", "-"};
        String question = number1 + " " + operations[index] + " " + number2;
        return question;
    }

    public static String getCalcCorrectAnswer(String question) {
        String[] array = question.split(" ");
        int number1 = Integer.parseInt(array[0]);
        int number2 = Integer.parseInt(array[2]);
        int result;
        String operation = array[1];
        switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            default:
                result = number1 - number2;
        }
        return Integer.toString(result);
    }
}
