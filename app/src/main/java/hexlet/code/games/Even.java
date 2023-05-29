package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    private static final int NUMBER_OF_QUESTIONS = 3;
    private static final int COUNT_OF_ROUNDS = 3;
    private static final int COUNT_OF_DATA = 2;
    public static void startGame(int gameNumber) {
        String nameOfUser = Cli.launchGreeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Even.playEvenGame(gameNumber, nameOfUser);
    }

    public static void playEvenGame(int gameNumber, String nameOfUser) {
        String[][] values = new String[COUNT_OF_ROUNDS][COUNT_OF_DATA];
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            String[] dataOfRound = Even.generateRoundData();
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values, nameOfUser);
    }

    public static String[] generateRoundData() {
        String question = Even.generateEvenQuestion();
        String correctAnswer = Even.getEvenCorrectAnswer(question);
        String[] values = {question, correctAnswer};
        return values;
    }

    public static String generateEvenQuestion() {
        final int maxNumber = 1000;
        int number = Utils.generateNumber(0, maxNumber);
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
