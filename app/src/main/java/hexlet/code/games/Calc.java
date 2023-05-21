package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Calc {
    public static void startingGame() {
        Engine.launchGreeting();
        System.out.println("What is the result of the expression?");
        Calc.playCalcGame();
    }

    public static void playCalcGame() {
        final int numberOfQuestions = 3;
        for (int i = 1; i < numberOfQuestions + 1; i++) {
            String question = Calc.generateCalcQuestion();
            String correctAnswer = Calc.getCalcCorrectAnswer(question);
            String[] values = {question, correctAnswer};
            if (!Engine.launchGeneralStructure(values, i)) {
                break;
            }
        }
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
