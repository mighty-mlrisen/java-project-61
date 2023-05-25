package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Set;
import org.apache.commons.lang3.RandomUtils;

public class Progression {
    private static final int MAX_NUMBER = 16;
    private static final int MAX_PROGRESSION_DIFFERENCES = 10;
    private static final int MAX_INDEX = 10;
    private static final int COUNT_NUMBERS = 10;
    private static final int MOVING_TO_PREV_PREV_INDEX = 2;
    private static final int PREV_INDEX = 1;
    private static final int PREV_PREV_INDEX = 2;
    private static final int NUMBER_OF_QUESTIONS = 3;
    private static final int COUNT_OF_ROUNDS = 3;
    private static final int COUNT_OF_DATA = 2;


    public static void startingGame(int gameNumber) {
        Engine.launchGreeting();
        System.out.println("What number is missing in the progression?");
        Progression.playProgressionGame(gameNumber);
    }

    public static void playProgressionGame(int gameNumber) {
        String[][] values = new String[COUNT_OF_ROUNDS][COUNT_OF_DATA];
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            String[] dataOfRound = Progression.generateRoundData(gameNumber);
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values);
    }

    public static String[] generateRoundData(int gameNumber) {
        return Set.checkGame(gameNumber);
    }

    public static String generateProgressionQuestion() {
        int number1 = RandomUtils.nextInt(1, MAX_NUMBER);
        int progressionDifferences = RandomUtils.nextInt(1, MAX_PROGRESSION_DIFFERENCES);
        String[] values = new String[COUNT_NUMBERS];
        values[0] = Integer.toString(number1);
        int number = number1;
        for (int i = 1; i < values.length; i++) {
            number += progressionDifferences;
            values[i] = Integer.toString(number);
        }
        int index = RandomUtils.nextInt(0, MAX_INDEX);
        values[index] = "..";
        String question = String.join(" ", values);
        return question;
    }

    public static String getProgressionCorrectAnswer(String question) {
        String[] values = question.split(" ");
        int index = 0;
        int missingNumber;
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals("..")) {
                index = i;
            }
        }
        if (index - MOVING_TO_PREV_PREV_INDEX >= 0) {
            missingNumber = calculateMissingNumber(values, index, -PREV_INDEX, -PREV_PREV_INDEX);
        } else {
            missingNumber = calculateMissingNumber(values, index, +1, +2);
        }
        return Integer.toString(missingNumber);
    }

    private static int calculateMissingNumber(String[] values, int index, int prevIndex, int prevPrevIndex) {
        int prevValue = Integer.parseInt(values[index + prevIndex]);
        int prevPrevValue = Integer.parseInt(values[index + prevPrevIndex]);
        return prevValue + (prevValue - prevPrevValue);
    }
}
