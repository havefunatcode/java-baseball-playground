package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class RandomNumberTest {

    @Test
    void createRandomThreeNumberWithMath() {
        HashSet<Integer> candidates = new HashSet<>();

        while (candidates.size() < 3) {
            int value = (int) (Math.random() * 9) + 1;
            candidates.add(value);
        }

        int randomNumber = 0;
        int multiplier = 100;
        for (int candidate : candidates) {
            randomNumber += multiplier * candidate;
            multiplier /= 10;
        }

        System.out.println("Random Three Digit Number : " + randomNumber);
    }

    @Test
    void createRandomThreeNumberWithCollections() {
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            digits.add(i);
        }

        Collections.shuffle(digits);

        int randomNumber = 100 * digits.get(0) + 10 * digits.get(1) + digits.get(2);

        System.out.println("Random Three Digit Number : " + randomNumber);
    }

}
