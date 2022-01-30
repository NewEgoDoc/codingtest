package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class Lv2타겟넘버 {
    StringBuilder sb = new StringBuilder();
    Set<String> set;

    public int solution(int[] numbers, int target) {
        return dfs(numbers,0,0,target);
    }

    private int dfs(int[] numbers, int index, int sum, int target) {
        if(index == numbers.length){
            if (target == sum){
                return 1;
            }
            return 0;
        }

        return dfs(numbers,index+1, sum+numbers[index], target)
            // + dfs(numbers,index+1, sum*numbers[index], target)
            // + dfs(numbers,index+1, sum/numbers[index], target)
             + dfs(numbers, index+1,sum-numbers[index],target);

    }


    @Test
    public void test(){
        assertEquals(solution(new int[]{1, 1, 1, 1, 1},3), 5);
        assertEquals(solution(new int[]{4, 1, 2, 1},4), 2);
    }
}
