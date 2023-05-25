package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Set;
import org.apache.commons.lang3.RandomUtils;

public class Even {
    public static void startingGame(int gameNumber) {
        Engine.launchGreeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Even.playEvenGame(gameNumber);
    }

    public static void playEvenGame(int gameNumber) {
        final int numberOfQuestions = 3;
        final int countOfRounds = 3;
        final int countOfData = 2;
        String[][] values = new String[countOfRounds][countOfData];
        for (int i = 0; i < numberOfQuestions; i++) {
            String[] dataOfRound = Even.generateRoundData(gameNumber);
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values);
    }

    public static String[] generateRoundData(int gameNumber) {
        return Set.checkGame(gameNumber);
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
