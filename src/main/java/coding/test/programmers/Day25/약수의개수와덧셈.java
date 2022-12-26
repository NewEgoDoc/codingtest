package coding.test.programmers.Day25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int numberOfDivisor = getCountOfDivisorOfNumber(i);
            if(numberOfDivisor % 2 == 0) answer += i;
            else answer -= i;
        }
        
        return answer;
    }
    
    int getCountOfDivisorOfNumber(int number){
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        return count;
    }
    
    @Test
    void test(){
        Assertions.assertEquals(solution(13,17),43);
        Assertions.assertEquals(solution(24,27),52);
    }
}
