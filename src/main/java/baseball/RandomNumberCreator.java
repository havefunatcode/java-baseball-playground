package baseball;

import java.util.ArrayList;
import java.util.Collections;

public class RandomNumberCreator {
    private final int randomNumber;

    public RandomNumberCreator() {
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        Collections.shuffle(digits);

        randomNumber = 100 * digits.get(0) + 10 * digits.get(1) + digits.get(2);
    }

    public String getRandomNumberToString() {
        return Integer.toString(randomNumber);
    }
}
