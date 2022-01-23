package coding.test.programmers.Lv4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class 도둑질 {
    public int solution(int[] money) {
        int answer = 0;

        int[] dpForGetFirst = new int[money.length];
        int[] dpForIgnoreFirst = new int[money.length];

        dpForGetFirst[0] = money[0];
        dpForGetFirst[1] = Math.max(money[0], money[1]);

        dpForIgnoreFirst[0] = 0;
        dpForIgnoreFirst[1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dpForIgnoreFirst[i] = Math.max(dpForIgnoreFirst[i-1], dpForIgnoreFirst[i-2]+money[i]);
            answer = Math.max(answer, dpForIgnoreFirst[i]);

            if(i == money.length - 1){
                dpForGetFirst[i] = Math.max(dpForGetFirst[i-1], dpForGetFirst[i-2]+money[i]);
                answer = Math.max(answer, dpForGetFirst[i]);
            }
        }

        return answer;
    }

    @Test
    public void test(){
        assertEquals(solution(new int[]{1, 2, 3, 1}),4);

    }
}
