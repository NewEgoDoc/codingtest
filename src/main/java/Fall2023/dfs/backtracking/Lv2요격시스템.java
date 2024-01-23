package Fall2023.dfs.backtracking;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Lv2요격시스템 {

    public int solution(int[][] targets) {
        int answer = 0;
        int end = 0;
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for(int[] target: targets){
            if(target[0] >= end){
                answer++;
                end = target[1];
            }
        }
        return answer;
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}),3);
    }
}
