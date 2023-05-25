package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Set;
import org.apache.commons.lang3.RandomUtils;

public class Calc {
    public static void startingGame(int gameNumber) {
        Engine.launchGreeting();
        System.out.println("What is the result of the expression?");
        Calc.playCalcGame(gameNumber);
    }

    public static void playCalcGame(int gameNumber) {
        final int numberOfQuestions = 3;
        final int countOfRounds = 3;
        final int countOfData = 2;
        String[][] values = new String[countOfRounds][countOfData];
        for (int i = 0; i < numberOfQuestions; i++) {
            String[] dataOfRound = Calc.generateRoundData(gameNumber);
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values);
    }

    public static String[] generateRoundData(int gameNumber) {
        return Set.checkGame(gameNumber);
    }

    public static String generateCalcQuestion() {
        final int maxIndex = 3;
        final int endOfRange = 20;
        final int beginningOfRange = 0;

        int number1 = RandomUtils.nextInt(beginningOfRange, endOfRange);
        int number2 = RandomUtils.nextInt(beginningOfRange, endOfRange);
        int index = RandomUtils.nextInt(beginningOfRange, maxIndex);
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
