package calculator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class StringCalculatorTest {

    private final String inputStr = "2 + 3 * 4 / 2";

    @Test
    void scanTest() {
        // given

        // when
        String scannedStr = scanParameters(inputStr);

        // then
        assertThat(inputStr).isEqualTo(scannedStr);
    }

    @Test
    void splitTest() {
        // given
        String[] result = {"2", "+", "3", "*", "4", "/", "2"};

        // when
        String[] splitStr = splitInputStr(inputStr);

        // then
        assertThat(splitStr).isEqualTo(result);
    }

    @Test
    void scanAndSplitTest() {
        // given
        String input = "21 + 33 * 45 / 20";
        String[] result = {"21", "+", "33", "*", "45", "/", "20"};

        // when
        String scannedStr = scanParameters(input);
        String[] splitInputStr = splitInputStr(scannedStr);

        // then
        assertThat(splitInputStr).isEqualTo(result);
    }

    @Test
    void convertingStringArrToQueue() {
        // given
        String[] splitInputStr = splitInputStr(inputStr);

        // when
        Queue<String> result = convertStringArrayToQueue(splitInputStr);

        // then
        for (int idx = 0; idx <= result.size(); idx++) {
            assertThat(result.poll()).isEqualTo(splitInputStr[idx]);
        }
        assertThat(result).isInstanceOf(Queue.class);
    }

    @Test
    void calculateTest() {
        // given
        Long num1 = 10L;
        Long num2 = 2L;

        // when
        Long addResult = calculate("+", num1, num2);
        Long subtractResult = calculate("-", num1, num2);
        Long multiplyResult = calculate("*", num1, num2);
        Long divideResult = calculate("/", num1, num2);

        // then
        assertThat(addResult).isEqualTo(12L);
        assertThat(subtractResult).isEqualTo(8L);
        assertThat(multiplyResult).isEqualTo(20L);
        assertThat(divideResult).isEqualTo(5L);
    }

    @Test
    void calculateStringArray() {

    }

    Queue<String> convertStringArrayToQueue(String[] inputStringArray) {
        LinkedList<String> queue = new LinkedList<>();

        for (String element : inputStringArray) {
            queue.offer(element);
        }

        return queue;
    }

    Long calculate(String operand, Long num1, Long num2) {
        Long result = 0L;
        switch (operand) {
            case "+":
                result = add(num1, num2);
                break;
            case "-":
                result = subtract(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                result = divide(num1, num2);
                break;
            default:
                break;
        }
        return result;
    }

    Long add(Long num1, Long num2) {
        return num1 + num2;
    }

    Long subtract(Long num1, Long num2) {
        return num1 - num2;
    }

    Long multiply(Long num1, Long num2) {
        return num1 * num2;
    }

    Long divide(Long num1, Long num2) {
        try {
            return num1 / num2;
        } catch (Exception e) {
            System.out.println("num1을 num2로 나눌 수 없습니다.");
        }
        return 0L;
    }

    String[] splitInputStr(String input) {
        return input.split(" ");
    }

    String scanParameters(String input) {
        ByteArrayInputStream inputByteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputByteArrayInputStream);
        Scanner scanner = new Scanner(System.in);

        String result = scanner.nextLine();
        scanner.close();
        return result;
    }

}