package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final int MAX_INDEX = 3;
    private static final int END_OF_RANGE = 20;
    private static final int BEGINNING_OF_RANGE = 0;

    public static void playCalcGame() {
        String description0fGame = "What is the result of the expression?";
        String[][] values = new String[Engine.COUNT_OF_ROUNDS][];
        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            values[i] = Calc.generateRoundData();
        }
        Engine.launchGeneralStructure(values, description0fGame);
    }

    public static String[] generateRoundData() {
        int number1 = Utils.generateNumber(BEGINNING_OF_RANGE, END_OF_RANGE);
        int number2 = Utils.generateNumber(BEGINNING_OF_RANGE, END_OF_RANGE);
        int index = Utils.generateNumber(BEGINNING_OF_RANGE, MAX_INDEX);
        String[] operations = {"+", "*", "-"};
        String question = number1 + " " + operations[index] + " " + number2;
        String correctAnswer = getCalcResult(operations[index], number1, number2);
        String[] values = {question, correctAnswer};
        return values;
    }

    public static String getCalcResult(String operation, int number1, int number2) {
        int result;
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
