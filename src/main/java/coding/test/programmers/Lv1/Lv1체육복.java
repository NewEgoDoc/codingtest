package coding.test.programmers.Lv1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Lv1체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;
    }

    @Test
    public void test(){
        assertEquals(solution(5,new int[]{2, 4},new int[]{1, 3, 5}),5);
        System.out.println("=================");
        assertEquals(solution(5,new int[]{2, 4},new int[]{3}),4);
        System.out.println("=================");
        assertEquals(solution(3,new int[]{3},new int[]{1}),2);
        System.out.println("=================");
        assertEquals(solution(5,new int[]{4, 2, 3},new int[]{1,2,3}),4);
    }
}
