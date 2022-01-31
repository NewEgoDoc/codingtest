package coding.test.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class Lv1소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;

        // 세 수의 합 구하기
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) answer++;
                }
            }
        }

        return answer;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    @Test
    public void test(){
        assertEquals(solution(new int[]{1,2,3,4}),1);
        assertEquals(solution(new int[]{1,2,7,6,4}),4);
    }
}
