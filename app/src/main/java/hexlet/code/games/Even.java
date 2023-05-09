package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Even {
    public static void startingGame() {
        Engine.launchGreeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public static String generatingQuestion() {
        int number = RandomUtils.nextInt(0,1000);
        return Integer.toString(number);
    }

    public static String correctAnswer(String question) {
        int number = Integer.parseInt(question);
        if (number % 2 == 0) return "yes";
        else return "no";
    }
}
