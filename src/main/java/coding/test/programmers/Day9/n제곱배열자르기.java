package coding.test.programmers.Day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class n제곱배열자르기 {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left) + 1;

        int[] answer = new int[len];

        int index = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[index++] = Math.max((int)row, (int)col) + 1;
        }

        return answer;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution(3,2,5), new int[]{3,2,2,3});
        Assertions.assertArrayEquals(solution(4, 7, 14), new int[]{4,3,3,3,4,4,4,4});
    }
}
