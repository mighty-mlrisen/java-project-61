package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import hexlet.code.games.Calc;
import java.util.Scanner;

public class Engine {

    public static void playGame() {
        int gameNumber = App.gameSelection();
        if (gameNumber == 0 || gameNumber == 1) {
            return;
        }
        else {
            launchGeneralStructure(gameNumber);
        }
    }
    private static void launchGeneralStructure(int gameNumber) {
        int countCorrectAnswer = 0;
        for (int i = 0; i < 3; i++) {
            String correctAnswer = Engine.getCorrectAnswer(gameNumber);
            String userAnswer = Engine.getUserAnswer();
            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
                countCorrectAnswer += 1;
                if (countCorrectAnswer == 3) {
                    System.out.println("Congratulations, " + Cli.name + "!");
                }
            } else {
                Engine.getWrongAnswer(userAnswer, correctAnswer);
                break;
            }
        }
    }

    private static String getCorrectAnswer(int gameNumber) {
        String question = Engine.questionSelection(gameNumber, 1, null);
        System.out.print("Question: " + question + "\n" + "Your answer: ");
        String correctAnswer = Engine.questionSelection(gameNumber, 2, question);
        return correctAnswer;
    }


    private static void getWrongAnswer(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' " + "is wrong answer ;(. Correct answer was " + "'" + correctAnswer + "'" + ".");
        System.out.println("Let's try again, " + Cli.name + "!");
    }

    private static String getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void launchGreeting() {
        Cli.greeting();
    }

    public static String questionSelection(int gameNumber, int index, String question2) {
        String question = "";
        String correctAnswer = "";
        if (gameNumber == 2) {
            if (index == 1) {
                question = Even.generateEvenQuestion();
            } else {
                correctAnswer = Even.getEvenCorrectAnswer(question2);
            }
        } else if (gameNumber == 3) {
            if (index == 1) {
                question = Calc.generateCalcQuestion();
            } else {
                correctAnswer = Calc.getCalcCorrectAnswer(question2);
            }
        } else if (gameNumber == 4) {
            if (index == 1) {
                question = GCD.generateGCDQuestion();
            } else {
                correctAnswer = GCD.getGCDCorrectAnswer(question2);
            }
        } else if (gameNumber == 5) {
            if (index == 1) {
                question = Progression.generateProgressionQuestion();
            } else {
                correctAnswer = Progression.getProgressionCorrectAnswer(question2);
            }
        } else if (gameNumber == 6) {
            if (index == 1) {
                question = Prime.generatePrimeQuestion();
            } else {
                correctAnswer = Prime.getPrimeCorrectAnswer(question2);
            }
        }
        return getSelectedContent(index, question, correctAnswer);
    }

    private static String getSelectedContent(int index, String question, String correctAnswer) {
        if (index == 1) {
            return question;
        } else {
            return correctAnswer;
        }
    }
}
