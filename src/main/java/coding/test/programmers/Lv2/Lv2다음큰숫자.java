package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv2다음큰숫자 {
    public int solution(int n) {
        int answer = 0;

        int oneCount = countBinary(n);

        for (int i = n+1; i > n; i++){
            if(oneCount == countBinary(i)){
                return i;
            }
        }

        return 0;
    }

    private int countBinary(int n) {
        int count = 0;
        String binaryNumber = Integer.toBinaryString(n);
        for(char num: binaryNumber.toCharArray()){
            if(num == '1'){
                count++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution(78),83);
        Assertions.assertEquals(solution(15),23);
        //78 83 15 23
    }
}
