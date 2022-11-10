package coding.test.programmers.Day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

public class 연속부분수열합의개수 {

    public int solution(int[] elements) {
        Set<Integer> set = new TreeSet<>();

        int n = elements.length;

        int[] doubleElements = new int[2*n];

        for (int i = 0; i < n; i++) {
            doubleElements[i] = elements[i];
        }
        for (int i = n; i < 2*n; i++) {
            doubleElements[i] = elements[i-n];
        }
        int[] array;
        int sum;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                sum = 0;
                for (int k = j; k < j+i; k++) {
                    sum += doubleElements[k];
                }
                set.add(sum);
            }
        }

        System.out.println("set = " + set);

        return set.size();
    }



    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{7,9,1,1,4}),18);
    }
}
