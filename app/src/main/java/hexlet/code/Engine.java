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
        int numberOfCorrectAnswers = 0;
        for (int i = 0; i < numberOfRounds; i++) {
            String question = values[i][0];
            String correctAnswer = values[i][1];
            System.out.print("Question: " + question + "\n" + "Your answer: ");
            String userAnswer = Engine.getUserAnswer();
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                numberOfCorrectAnswers += 1;
                Engine.checkNumberOfCorrectAnswers(numberOfCorrectAnswers, userName);
            } else {
                Engine.getWrongAnswer(userAnswer, correctAnswer, userName);
                break;
            }
        }
    }

    private  static void checkNumberOfCorrectAnswers(int countCorrectAnswer, String nameOfUser) {
        final int maxNumberOfCorrectAnswers = 3;
        if (countCorrectAnswer == maxNumberOfCorrectAnswers) {
            System.out.println("Congratulations, " + nameOfUser + "!");
        }
    }

    private static void getWrongAnswer(String userAnswer, String correctAnswer, String nameOfUser) {
        System.out.print("'" + userAnswer + "' " + "is wrong answer ;(. Correct answer was ");
        System.out.println("'" + correctAnswer + "'" + ".");
        System.out.println("Let's try again, " + nameOfUser + "!");
    }

    private static String getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
