package coding.test.programmers.Day16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 점찍기 {
    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i+=k) {
            for (int j = 0; j <= d; j+=k) {
                if(Math.sqrt(Math.pow(i,2) + Math.pow(j,2)) <= d) {
                    answer++;
                    System.out.println(i + " / " + j);
                }
            }
        }

        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(2,4),6);
        Assertions.assertEquals(solution(1,5),26);
    }
}
