package coding.test.programmers.Lv1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Lv1체육복 {
    public int solution(int n, int[] lost, int[] reserve) {

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int answer = 0;
        boolean[] isLost = new boolean[n+1];

        for(int index: lost){
            isLost[index] = true;
        }


        for (int i = 0; i < ; i++) {
            
        }
        
        for (int i = 0; i < reserve.length; i++) {
            int index = reserve[i];

            if(index-1 != 0 && isLost[index-1]) {
                isLost[index-1] = false;
                continue;
            }
            if(index+1 != n+1 && isLost[index+1]) {
                isLost[index+1] = false;
                continue;
            }
        }


        for (int i = 1; i <= n; i++) {
            System.out.println("isLost["+i+"] = " + isLost[i]);
            if(!isLost[i]) answer++;
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
        assertEquals(solution(9,new int[]{2, 5},new int[]{3,4}),9);
        System.out.println("=================");
        assertEquals(solution(5,new int[]{4, 2, 3},new int[]{1,2,3}),4);
    }
}
