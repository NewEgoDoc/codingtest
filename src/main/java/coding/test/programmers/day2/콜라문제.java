package coding.test.programmers.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 콜라문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int remain;

        while(n >= a){
            remain = n % a;
            answer += n/a * b;

            n = (n/a) * b + remain;
        }
        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(2, 1, 20), 19);
        Assertions.assertEquals(solution(3, 1, 20), 9);
    }
}
