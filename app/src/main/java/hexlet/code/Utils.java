package hexlet.code;

import org.apache.commons.lang3.RandomUtils;

public class Utils {
    public static int generateNumber(int beginningOfRange, int endOfRange) {
        int number = RandomUtils.nextInt(beginningOfRange, endOfRange);
        return number;
    }
}
