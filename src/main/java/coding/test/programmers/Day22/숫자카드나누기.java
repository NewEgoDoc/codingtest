package coding.test.programmers.Day22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 숫자카드나누기 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/135807
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        int divisor = 0;
        if(isArrayDividedBy(arrayB, gcdA)){
            if(divisor < gcdA) divisor = gcdA;
        }
        if(isArrayDividedBy(arrayA, gcdB)){
            if(divisor < gcdB) divisor = gcdB;
        }
        return divisor;
    }

    private boolean isArrayDividedBy(int[] array, int gcd) {
        for(int n: array){
            if(n % gcd == 0) return false;
        }
        return true;
    }

    private int gcd(int x, int y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{10, 17},new int[]{5, 20}),0);
        System.out.println();
        Assertions.assertEquals(solution(new int[]{10, 20},new int[]{5, 17}),10);
        System.out.println();
        Assertions.assertEquals(solution(new int[]{14, 35, 119},new int[]{18, 30, 102}),7);
        System.out.println();
    }
}
