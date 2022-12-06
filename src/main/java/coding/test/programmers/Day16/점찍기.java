package coding.test.programmers.Day16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 점찍기 {
    public long solution(int k, int d) {
        int answer = 0;
        long squareOfd = (long)d * (long)d;
        //문제에서는 원점과 찍은 점의 거리가 d 이하인 양의 정수인 점의 개수를 구하는 것
        for (long i = 0; i <= (long)d; i+=(long)k) {
            answer += (long)Math.sqrt(squareOfd - i*i) / k + 1;
        }
        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(2,4),6);
        Assertions.assertEquals(solution(1,5),26);
    }
}
