package coding.test.programmers.Day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 과일장수 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        if(score.length < m) return 0;

        int countBox = score.length / m;

        int[] scoreSorted = Arrays.stream(score).toArray();
        Arrays.sort(scoreSorted);

        int count = 0;
        while(count != countBox){
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= m; i++) {
                int sc = scoreSorted[scoreSorted.length - (i + count * m)];
                if(min > sc) min = sc;
            }
            answer += min * m;
            count++;
        }

        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(3,4,new int[]{1, 2, 3, 1, 2, 3, 1}),8);
        Assertions.assertEquals(solution(4,3,new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}),33);
    }
}
