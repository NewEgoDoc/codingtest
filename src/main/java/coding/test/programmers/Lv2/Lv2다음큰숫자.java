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

    public int solution2(int n){
        int bits = bitCount(n);
        while(bitCount(++n) != bits);
        return n;
    }

    private int bitCount(int n) {
        return Integer.bitCount(n);
    }

    private int bitCount2(int n) { // <-시간초과
        return (int)Integer.toBinaryString(n)
                .chars()
                .filter(ch -> ch == '1')
                .count();
    }
    
    private int bitCount3(int n) {
        int count = 0;
        while(n > 0){
            if(n%2 ==0) count++;
            n /= 2;
        }
        return count;
    }

    private int bitCount4(int n) {
        int count = 0;
        while(n > 0){
            count+= n & 1;
            n >>= 1;
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
