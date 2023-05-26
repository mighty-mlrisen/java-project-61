package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class Set {

    private static final int GAME_NUMBER_EVEN = 2;
    private static final int GAME_NUMBER_CALC = 3;
    private static final int GAME_NUMBER_GCD = 4;
    private static final int GAME_NUMBER_PROGRESSION = 5;

    public static String[] checkGame(int gameNumber) {
        String[] result;
        switch (gameNumber) {
            case GAME_NUMBER_EVEN:
                result = Set.generateEvenSet();
                break;
            case GAME_NUMBER_CALC:
                result = Set.generateCalcSet();
                break;
            case GAME_NUMBER_GCD:
                result = Set.generateGCDSet();
                break;
            case GAME_NUMBER_PROGRESSION:
                result = Set.generateProgressionSet();
                break;
            default:
                result = Set.generatePrimeSet();
        }
        return result;
    }

    public static String[] generateEvenSet() {
        String question = Even.generateEvenQuestion();
        String[] values = {question, Even.getEvenCorrectAnswer(question)};
        return values;
    }

    public static String[] generateCalcSet() {
        String question = Calc.generateCalcQuestion();
        String[] values = {question, Calc.getCalcCorrectAnswer(question)};
        return values;
    }

    public static String[] generateGCDSet() {
        String question = GCD.generateGCDQuestion();
        String[] values = {question, GCD.getGCDCorrectAnswer(question)};
        return values;
    }

    public static String[] generateProgressionSet() {
        String question = Progression.generateProgressionQuestion();
        String[] values = {question, Progression.getProgressionCorrectAnswer(question)};
        return values;
    }

    public static String[] generatePrimeSet() {
        String question = Prime.generatePrimeQuestion();
        String[] values = {question, Prime.getPrimeCorrectAnswer(question)};
        return values;
    }
}
