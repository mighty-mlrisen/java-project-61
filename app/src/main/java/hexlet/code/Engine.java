package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static boolean launchGeneralStructure(String [] values, int index) {
        String question = values[0];
        String correctAnswer = values[1];
        System.out.print("Question: " + question + "\n" + "Your answer: ");
        String userAnswer = Engine.getUserAnswer();
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            Engine.checkNumberOfCorrectAnswers(index);
            return true;
        } else {
            Engine.getWrongAnswer(userAnswer, correctAnswer);
            return false;
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
