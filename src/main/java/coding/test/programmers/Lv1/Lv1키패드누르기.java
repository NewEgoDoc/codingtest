package coding.test.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv1키패드누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int left = 10;
        int right = 12;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                left = number;
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                right = number;
            } else {
                if (number == 0) number = 11;
                int leftDiff = Math.abs(number - left) / 3 + Math.abs(number - left) % 3;
                int rightDiff = Math.abs(number - right) / 3 + Math.abs(number - right) % 3;

                if (leftDiff < rightDiff) {
                    sb.append("L");
                    left = number;
                } else if (leftDiff > rightDiff) {
                    sb.append("R");
                    right = number;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = number;
                    } else {
                        sb.append("R");
                        right = number;
                    }
                }
            }
        }

        return sb.toString();
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"),
                "LRLLLRLLRRL");
        Assertions.assertEquals(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"),
                "LRLLRRLLLRR");
        Assertions.assertEquals(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"),
                "LLRLLRLLRL");
    }
}
