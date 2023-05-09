package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class GCD {

    public static void startingGame() {
        Engine.launchGreeting();
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public static String generatingQuestion() {
        int number1 = RandomUtils.nextInt(1,101);
        int number2 = RandomUtils.nextInt(1,101);
        return Integer.toString(number1) + " " + Integer.toString(number2);
    }

    public static String correctAnswer(String question) {
        String[] values = question.split(" ");
        int number1 = Integer.parseInt(values[0]);
        int number2 = Integer.parseInt(values[1]);
        int temp, nod = 1;
        if (number1 > number2) temp = number2;
        else temp = number1;
        for (int i = temp; i > 0; i-= 1) {
            if (number1 % i == 0 && number2 % i == 0) {
                nod = i;
                return Integer.toString(nod);
            }
        }
        return Integer.toString(nod);
    }
}
