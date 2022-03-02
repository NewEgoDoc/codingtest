package coding.test.programmers.코테;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 프로그래밍1 {
    public int solution(int[] arr) {
        int[] differences = new int[256];
        //arr의 길이는 1 이상 1,000 이하입니다.
        //arr의 원소는 0 이상 255 이하인 정수입니다
        int down,up;
        for (int i = 0; i <= 255; i++) {
            down = 0;
            up = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] < i) down++;
                else up++;
            }
            differences[i] = Math.abs(up - down);
        }

        int min = 256;
        for (int i = 0; i < 256; i++) {
            if(min > differences[i]) {
                min = differences[i];
            }
        }
        for (int i = 0; i < 256; i++) {
            if(min == differences[i]) return i;
        }

        return -1;
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution(new int[]{1,52,125,10,25,201,244,192,128,23,203,98,154,255}),126);
        Assertions.assertEquals(solution(new int[]{0,0,255,255,0,0,255,255,255}),1);
        Assertions.assertEquals(solution(new int[]{100,50,100,200}),51);
    }

}
