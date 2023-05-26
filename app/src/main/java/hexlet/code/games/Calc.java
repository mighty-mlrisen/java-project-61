package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Set;
import hexlet.code.Utils;

public class Calc {

    private static final int NUMBER_OF_QUESTIONS = 3;
    private static final int COUNT_OF_ROUNDS = 3;
    private static final int COUNT_OF_DATA = 2;

    public static void startGame(int gameNumber) {
        String nameOfUser = Cli.launchGreeting();
        System.out.println("What is the result of the expression?");
        Calc.playCalcGame(gameNumber, nameOfUser);
    }

    public static void playCalcGame(int gameNumber, String nameOfUser) {
        String[][] values = new String[COUNT_OF_ROUNDS][COUNT_OF_DATA];
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            String[] dataOfRound = Calc.generateRoundData(gameNumber);
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values, nameOfUser);
    }

    public static String[] generateRoundData(int gameNumber) {
        return Set.checkGame(gameNumber);
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
        if (array[1].equals("+")) {
            result = number1 + number2;
        } else if (array[1].equals("*")) {
            result = number1 * number2;
        } else {
            result = number1 - number2;
        }
        return Integer.toString(result);
    }
}
