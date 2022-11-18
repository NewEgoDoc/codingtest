package coding.test.programmers.Day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;




        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[][]{
                {60, 50}, {30, 70}, {60, 30}, {80, 40}
        }), 4000);
        Assertions.assertEquals(solution(new int[][]{
                {10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}
        }), 120);
        Assertions.assertEquals(solution(new int[][]{
                {14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}
        }), 133);
    }
}
