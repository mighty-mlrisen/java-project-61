package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void launchGeneralStructure(String[][] values) {
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
                Engine.checkNumberOfCorrectAnswers(numberOfCorrectAnswers);
            } else {
                Engine.getWrongAnswer(userAnswer, correctAnswer);
                break;
            }
        }
    }

    private  static void checkNumberOfCorrectAnswers(int countCorrectAnswer) {
        final int maxNumberOfCorrectAnswers = 3;
        if (countCorrectAnswer == maxNumberOfCorrectAnswers) {
            System.out.println("Congratulations, " + Cli.getName() + "!");
        }
    }

    private static void getWrongAnswer(String userAnswer, String correctAnswer) {
        System.out.print("'" + userAnswer + "' " + "is wrong answer ;(. Correct answer was ");
        System.out.println("'" + correctAnswer + "'" + ".");
        System.out.println("Let's try again, " + Cli.getName() + "!");
    }

    private static String getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void launchGreeting() {
        Cli.greeting();
    }
}
