package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Prime {
    public static void startingGame() {
        Engine.launchGreeting();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Prime.playPrimeGame();
    }

    public static void playPrimeGame() {
        final int numberOfQuestions = 3;
        for (int i = 1; i < numberOfQuestions + 1; i++) {
            String question = Prime.generatePrimeQuestion();
            String correctAnswer = Prime.getPrimeCorrectAnswer(question);
            String [] values = {question, correctAnswer};
            if (Engine.launchGeneralStructure(values, i) == false) {
                break;
            }
        }
    }

    public static String generatePrimeQuestion() {
        final int maxNumber = 100;
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
