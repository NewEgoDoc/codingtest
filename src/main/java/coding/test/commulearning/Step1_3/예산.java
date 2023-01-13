package coding.test.commulearning.Step1_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        System.out.println(Arrays.toString(d));

        for(int money: d){
            if(budget <= 0) break;
            budget -= money;
            answer++;
        }

        return budget < 0? answer - 1: answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{1,3,2,4,5},9), 3);
        Assertions.assertEquals(solution(new int[]{2,2,3,3},10), 4);
    }
}
