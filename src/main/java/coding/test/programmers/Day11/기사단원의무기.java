package coding.test.programmers.Day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 기사단원의무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        List<Integer> powers = new ArrayList<>();
        powers.add(1);
        for (int i = 2; i <= number; i++) {
            powers.add(countDivisor(i));
        }

        for (int pw: powers) {
            if(pw > limit) {
                answer += power;
                continue;
            }
            answer+=pw;
        }

        return answer;
    }

    private int countDivisor(int number) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (i * i == number) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }


    @Test
    void test() {
        Assertions.assertEquals(solution(5, 3, 2), 10);
        Assertions.assertEquals(solution(10, 3, 2), 21);
    }
}
