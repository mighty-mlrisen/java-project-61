package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void launchGeneralStructure(String[][] values, String description0fGame) {
        System.out.println("\n" + "Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = Cli.launchGreeting();
        System.out.println("Hello, " + userName + "!");
        System.out.println(description0fGame);
        final int numberOfRounds = 3;
        for (int i = 0; i < numberOfRounds; i++) {
            String question = values[i][0];
            String correctAnswer = values[i][1];
            System.out.print("Question: " + question + "\n" + "Your answer: ");
            String userAnswer = Engine.getUserAnswer();
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + userAnswer + "' " + "is wrong answer ;(. Correct answer was ");
                System.out.println("'" + correctAnswer + "'" + ".");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    private static String getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
