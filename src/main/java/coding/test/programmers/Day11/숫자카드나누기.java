package coding.test.programmers.Day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int a = lcm(arrayA[0],arrayA[1]);
        int b = lcm(arrayB[0],arrayB[1]);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        List<Integer> list = new ArrayList<>();

        boolean isIncluded = true;
        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] % b == 0) isIncluded = false;
        }
        if(isIncluded) list.add(b);

        isIncluded = true;
        for (int i = 0; i < arrayB.length; i++) {
            if(arrayB[i] % a == 0) {
                System.out.println("arrayB = " + arrayB[i]);
                isIncluded = false;
            }
        }
        if(isIncluded) list.add(b);

        if(list.isEmpty()) return 0;
        Collections.sort(list);
        System.out.println("list = " + list);
        return list.get(1);
    }

    private int lcm(int n1, int n2) {
        int remainder = n2 % n1;
        while(remainder != 0){
            n1 = remainder;
            n2 -= remainder;
            
            remainder = n2 % n1;
        }
        
        return n1;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{10, 17},	new int[]{5, 20}),0);
        Assertions.assertEquals(solution(new int[]{10, 20},	new int[]{5, 17}),10);
        Assertions.assertEquals(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}),7);
    }
}
