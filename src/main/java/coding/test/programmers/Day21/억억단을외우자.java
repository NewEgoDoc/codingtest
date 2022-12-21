package coding.test.programmers.Day21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 억억단을외우자 {

    int[] countDivisors;
    int maximumIndex;

    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        countDivisors = new int[e + 1];
        maximumIndex = e;
        for (int i = 1; i <= e; i++) {
            getDivisorCount(i);
        }

        int[][] map = new int[e+1][1];

        findMinimumIndex(map);

        for (int i = 0; i < starts.length; i++) {
            answer[i] = map[starts[i]][0];
        }

        return answer;
    }

    // N의 소수의 개수
    void getDivisorCount(int N) {
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (i * i == N) count++;
            else if (N % i == 0) count += 2;
        }
        countDivisors[N] = count;
    }

    void findMinimumIndex(int[][] map){

        int index = 0;
        int max = 0;
        for (int i = maximumIndex; i >= 0; i--) {
            System.out.println("countDivisors = " + countDivisors[i]);
            System.out.println("index = " + index);
            if( countDivisors[i] >= max) {
                max = countDivisors[i];
                index = i;
            }
            map[i][0] = index;
        }
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution(8,new int[]{1,3,7}),new int[]{6,6,8});
    }
}
