package coding.test.programmers.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 푸드파이터대회 {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < food.length; i++){
            int num = food[i] / 2;
            for (int j = 0; j < num; j++) {
                sb.append(i);
            }
        }

        String reverse = sb.reverse().toString();
        sb.reverse();
        sb.append(0);
        sb.append(reverse);
        return sb.toString();
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{1, 3, 4, 6}),"1223330333221");
        Assertions.assertEquals(solution(new int[]{1, 7, 1, 2}),"111303111");
    }
}
