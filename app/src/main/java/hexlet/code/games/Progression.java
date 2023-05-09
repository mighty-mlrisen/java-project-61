package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Progression {

    public static void startingGame() {
        Engine.launchGreeting();
        System.out.println("What number is missing in the progression?");
    }

    public static String generatingQuestion() {
        int number1 = RandomUtils.nextInt(1,16);
        int progressionDifferences = RandomUtils.nextInt(1,10);
        String[] values = new String[10];
        values[0] = Integer.toString(number1);
        int number = number1;
        for (int i = 1; i < values.length; i++) {
            number += progressionDifferences;
            values[i] = Integer.toString(number);
        }
        int index = RandomUtils.nextInt(0,10);
        values[index] = "..";
        String progression = String.join(" ",values);
        return progression;
    }

    public static String correctAnswer(String question) {
        String[] values = question.split(" ");
        int index = 0 , missingNumber;
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals("..")) {
                index = i;
            }
        }
        if (index - 2 >= 0) {
            missingNumber = Integer.parseInt(values[index - 1]) + (Integer.parseInt(values[index - 1]) - Integer.parseInt(values[index - 2]));
        } else {
            missingNumber = Integer.parseInt(values[index + 1]) - (Integer.parseInt(values[index + 2]) - Integer.parseInt(values[index + 1]));
        }
        return Integer.toString(missingNumber);
    }
}
