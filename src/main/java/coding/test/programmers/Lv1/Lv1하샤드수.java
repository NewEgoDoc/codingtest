package coding.test.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv1하샤드수 {
    public boolean solution(int x) {
        int sumNumber = sumDigit(x);
        return x % sumNumber == 0;
    }

    private int sumDigit(int x) {
        return Integer.toString(x).chars().map(Character::getNumericValue).sum();
    }


    private int sumDigit2(int x) {
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x/=10;
        }
        return 0;
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution(10),true);
        Assertions.assertEquals(solution(12),true);
        Assertions.assertEquals(solution(11),false);
        Assertions.assertEquals(solution(13),false);
    }
}
