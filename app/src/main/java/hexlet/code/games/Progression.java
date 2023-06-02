package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

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

    public static void playProgressionGame() {
        String description0fGame = "What number is missing in the progression?";
        String[][] values = new String[COUNT_OF_ROUNDS][COUNT_OF_DATA];
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            String[] dataOfRound = Progression.generateRoundData();
            values[i][0] = dataOfRound[0];
            values[i][1] = dataOfRound[1];
        }
        Engine.launchGeneralStructure(values, description0fGame);
    }

    public static String[] generateRoundData() {
        int number1 = Utils.generateNumber(1, MAX_NUMBER);
        int progressionDifferences = Utils.generateNumber(1, MAX_PROGRESSION_DIFFERENCES);
        String[] progression = Progression.generateProgression(number1, progressionDifferences);
        int index = Utils.generateNumber(0, MAX_INDEX);
        String correctAnswer = progression[index];
        progression[index] = "..";
        String question = String.join(" ", progression);
        String[] values = {question, correctAnswer};
        return values;
    }

    public static String[] generateProgression(int  number1, int progressionDifferences) {
        String[] values = new String[COUNT_NUMBERS];
        values[0] = Integer.toString(number1);
        int number = number1;
        for (int i = 1; i < values.length; i++) {
            number += progressionDifferences;
            values[i] = Integer.toString(number);
        }
        return values;
    }
}
