package coding.test.programmers.Lv3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class Lv3정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        return answer;
    }

    @Test
    public void test(){
        assertEquals(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}),30);
    }
}
