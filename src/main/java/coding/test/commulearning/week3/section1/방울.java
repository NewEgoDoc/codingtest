package coding.test.commulearning.week3.section1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 방울 {
    public int solution(int[] bell) {
        int answer = 0;
        int[] sum = new int[bell.length + 1];
//        for (int i = 0; i < bell.length; i++) {
//            bell[i] = bell[i] == 1? -1:1;
//        }
        System.out.println(Arrays.toString(bell));
        for (int i = 1; i < bell.length + 1; i++) {
            sum[i] += sum[i-1] + bell[i-1];
        }

        System.out.println(Arrays.toString(sum));

        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{1,2,1,1,1,2,2,1}),6);
        Assertions.assertEquals(solution(new int[]{1,1,1,1,1,1}),0);
        Assertions.assertEquals(solution(new int[]{2,2,1,1,2,2,2,2,2,1}),4);
    }
}
