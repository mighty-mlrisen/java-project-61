package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Even {
    public static void startingGame() {
        Engine.launchGreeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Even.playEvenGame();
    }

    public static void playEvenGame() {
        final int numberOfQuestions = 3;
        for (int i = 1; i < numberOfQuestions + 1; i++) {
            String[] values = Even.generateEvenQuestion();
            if (!Engine.launchGeneralStructure(values, i)) {
                break;
            }
        }
    }

    public static String[] generateEvenQuestion() {
        final int maxNumber = 1000;
        int number = RandomUtils.nextInt(0, maxNumber);
        String question = Integer.toString(number);
        String correctAnswer = Even.getEvenCorrectAnswer(question);
        String[] set = {question, correctAnswer};
        return set;
    }

    public static String getEvenCorrectAnswer(String question) {
        int number = Integer.parseInt(question);
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}
