package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Set;
import org.apache.commons.lang3.RandomUtils;

public class Prime {
    public static void startingGame(int gameNumber) {
        Engine.launchGreeting();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Prime.playPrimeGame(gameNumber);
    }

    public static void playPrimeGame(int gameNumber) {
        final int numberOfQuestions = 3;
        final int countOfRounds = 3;
        final int countOfData = 2;
        String[][] values = new String[countOfRounds][countOfData];
        for (int i = 0; i < numberOfQuestions; i++) {
            String[] dataOfRound = Prime.generateRoundData(gameNumber);
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values);
    }

    public static String[] generateRoundData(int gameNumber) {
        return Set.checkGame(gameNumber);
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
