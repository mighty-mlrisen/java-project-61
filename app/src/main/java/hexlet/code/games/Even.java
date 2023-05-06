package hexlet.code;

import org.apache.commons.lang3.RandomUtils;
import java.util.Scanner;

public class Even {
    public static String even(int number) {
        if (number % 2 == 0) return "yes";
        else return "no";
    }

    public static void startingGame() {
        String name = Cli.greeting();
        int countCorrectAnswer = 0;
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < 3; i++) {
            int number = RandomUtils.nextInt(0, 1000);
            String correctAnswer = Even.even(number);
            System.out.print("Question: " + number + "\n" + "Your answer: ");
            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.next();
            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
                countCorrectAnswer += 1;
                if (countCorrectAnswer == 3) {
                    System.out.println("Congratulations, " + name + "!");
                }
            }
            else {
                System.out.println("'" + userAnswer + "' " + "is wrong answer ;(. Correct answer was " + "'" + correctAnswer + "'" + ".");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

    }
}
