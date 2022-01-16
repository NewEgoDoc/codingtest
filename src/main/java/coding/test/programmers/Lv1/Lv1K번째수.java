package coding.test.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Lv1K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int count = 1;
            //List<Integer> list = new ArrayList<>();
            int[] arr = new int[(commands[i][1] - commands[i][0] +1)];
            for (int j = commands[i][0]-1; j <= commands[i][1]-1; j++) {
                //list.add(array[j]);
                arr[j-(commands[i][0]-1)] = array[j];
            }

            //Collections.sort(list);
            Arrays.sort(arr);

            //answer[i] = list.get(commands[i][2]-1);
            answer[i] = arr[commands[i][2]-1];
        }

        
        return answer;
    }

    @Test
    public void test(){
        assertArrayEquals(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})
                ,new int[]{5, 6, 3});
    }
}
