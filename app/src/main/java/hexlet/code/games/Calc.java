package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Calc {
    public static void startingGame() {
        Engine.launchGreeting();
        System.out.println("What is the result of the expression?");
    }

    public static String generateCalcQuestion() {
        int maxNumber = 20, maxIndex = 3;
        int number1 = RandomUtils.nextInt(0, maxNumber);
        int number2 = RandomUtils.nextInt(0, maxNumber);
        int index = RandomUtils.nextInt(0, maxIndex);
        String[] operations = {"+", "*", "-"};
        String result = number1 + " " + operations[index] + " " + number2;
        return result;
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
