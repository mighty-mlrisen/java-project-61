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
        } else {
            launchGeneralStructure(gameNumber);
        }
    }
    private static void launchGeneralStructure(int gameNumber) {
        int countCorrectAnswer = 0;
        int numberOfQuestions = 3;
        for (int i = 0; i < numberOfQuestions; i++) {
            String correctAnswer = Engine.getCorrectAnswer(gameNumber);
            String userAnswer = Engine.getUserAnswer();
            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
                countCorrectAnswer += 1;
                Engine.checkNumberOfCorrectAnswers(countCorrectAnswer);
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

    private  static void checkNumberOfCorrectAnswers(int countCorrectAnswer) {
        int maxNumberOfCorrectAnswers = 3;
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

    public static String questionSelection(int gameNumber, int index, String question2) {
        String question = "";
        String correctAnswer = "";
        if (index == 1) {
            question = Engine.generateQuestionByNumber(gameNumber);
        } else {
            correctAnswer = Engine.getCorrectAnswerByNumber(gameNumber, question2);
        }
        return getSelectedContent(index, question, correctAnswer);
    }

    private static String generateQuestionByNumber(int gameNumber) {
        String question = "";
        int gameNumberEven = 2;
        int gameNumberCalc = 3;
        int gameNumberGCD = 4;
        int gameNumberProgression = 5;
        if (gameNumber == gameNumberEven) {
            question = Even.generateEvenQuestion();
        } else if (gameNumber == gameNumberCalc) {
            question = Calc.generateCalcQuestion();
        } else if (gameNumber == gameNumberGCD) {
            question = GCD.generateGCDQuestion();
        } else if (gameNumber == gameNumberProgression) {
            question = Progression.generateProgressionQuestion();
        } else {
            question = Prime.generatePrimeQuestion();
        }
        return question;
    }

    private static String getCorrectAnswerByNumber(int gameNumber, String question2) {
        String correctAnswer = "";
        int gameNumberEven = 2;
        int gameNumberCalc = 3;
        int gameNumberGCD = 4;
        int gameNumberProgression = 5;
        if (gameNumber == gameNumberEven) {
            correctAnswer = Even.getEvenCorrectAnswer(question2);
        } else if (gameNumber == gameNumberCalc) {
            correctAnswer = Calc.getCalcCorrectAnswer(question2);
        } else if (gameNumber == gameNumberGCD) {
            correctAnswer = GCD.getGCDCorrectAnswer(question2);
        } else if (gameNumber == gameNumberProgression) {
            correctAnswer = Progression.getProgressionCorrectAnswer(question2);
        } else {
            correctAnswer = Prime.getPrimeCorrectAnswer(question2);
        }
        return correctAnswer;
    }

    private static String getSelectedContent(int index, String question, String correctAnswer) {
        if (index == 1) {
            return question;
        } else {
            return correctAnswer;
        }
    }
}
