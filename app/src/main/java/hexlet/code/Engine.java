package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class Engine {
    public static void generalStructure() {
        int gameNumber = App.gameSelection();
        if (gameNumber == 0 || gameNumber == 1 ) return;
        else {
            int countCorrectAnswer = 0;
            for (int i = 0; i < 3; i++) {
                String question = Engine.questionSelection(gameNumber, 1, null);
                System.out.print("Question: " + question + "\n" + "Your answer: ");
                Scanner scanner = new Scanner(System.in);
                String userAnswer = scanner.nextLine();
                String correctAnswer = Engine.questionSelection(gameNumber, 2, question);
                if (correctAnswer.equals(userAnswer)) {
                    System.out.println("Correct!");
                    countCorrectAnswer += 1;
                    if (countCorrectAnswer == 3) {
                        System.out.println("Congratulations, " + Cli.name + "!");
                    }
                }
                else {
                    System.out.println("'" + userAnswer + "' " + "is wrong answer ;(. Correct answer was " + "'" + correctAnswer + "'" + ".");
                    System.out.println("Let's try again, " + Cli.name + "!");
                    break;
                }
            }
        }
    }

    public static void launchGreeting() {
        Cli.greeting();
    }

    public static String questionSelection(int gameNumber, int index, String question2_0) {
        String question = "";
        String correctAnswer = "";
        switch (gameNumber) {
            case 2:
                if (index == 1) {
                    question = Even.generatingQuestion();
                }
                else {
                    correctAnswer = Even.correctAnswer(question2_0);
                }
                break;
            case 3:
                if (index == 1) {
                    question = Calc.generatingQuestion();
                }
                else {
                    correctAnswer = Calc.correctAnswer(question2_0);
                }
                break;
        }
        if (index == 1) return question;
        else return correctAnswer;
    }
}