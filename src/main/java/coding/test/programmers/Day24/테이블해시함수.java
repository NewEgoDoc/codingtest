package coding.test.programmers.Day24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, ((o1, o2) -> {
            if(o1[col-1] == o2[col-1]){
                return o2[0] - o1[0];
            }
            return o1[col-1] - o2[col-1];
        }));

        List<Integer> results = new ArrayList<>();
        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[0].length; j++) {
                sum += data[i-1][j] % i; 
            }
            results.add(sum);
        }

        for (int result: results){
            answer ^= result;
        }
        

        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[][]{
                {2,2,6},
                {1,5,10},
                {4,2,9},
                {3,8,3}}, 2,2,3),
                4);
    }
}
