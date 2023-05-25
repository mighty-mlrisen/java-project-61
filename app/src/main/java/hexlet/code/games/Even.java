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
        String[][] values = new String[3][2];
        for (int i = 0; i < numberOfQuestions; i++) {
            String[] dataOfRound = Even.generateRoundData();
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values);
    }

    public static String[] generateRoundData() {
        String question = Even.generateEvenQuestion();
        String correctAnswer = Even.getEvenCorrectAnswer(question);
        String[] data = {question, correctAnswer};
        return data;
    }

    public static String generateEvenQuestion() {
        final int maxNumber = 1000;
        int number = RandomUtils.nextInt(0, maxNumber);
        return Integer.toString(number);
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
