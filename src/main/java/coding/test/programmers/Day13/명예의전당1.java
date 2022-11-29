package coding.test.programmers.Day13;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 명예의전당1 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
            Collections.sort(list,Collections.reverseOrder());
            if (i < k-1){
                answer[i] = list.get(list.size()-1);
            } else {
                answer[i] = list.get(k-1);
            }
        }
        return answer;
    }

    @Test
    public void test(){
        Assertions.assertArrayEquals(solution(3 ,new int[]{10, 100, 20, 150, 1, 100, 200}),
                new int[]{10, 10, 10, 20, 20, 100, 100});
        Assertions.assertArrayEquals(solution(4 ,new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}),
                new int[]{0, 0, 0, 0, 20, 40, 70, 70, 150, 300});
    }
}
