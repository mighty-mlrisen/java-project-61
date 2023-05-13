package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Prime {
    public static void startingGame() {
        Engine.launchGreeting();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public static String generatePrimeQuestion() {
        int maxNumber = 100;
        int number = RandomUtils.nextInt(1, maxNumber);
        return Integer.toString(number);
    }

    public static String getPrimeCorrectAnswer(String question) {
        int number = Integer.parseInt(question);
        if (number == 1) {
            return "no";
        }
        for (int d = 2; d * d <= number; d++) {
            if (number % d == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
