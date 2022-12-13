package coding.test.programmers.Day20;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class 이차원동전뒤집기 {
    int[] rc = new int[2];

    int n;
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;

        permutation(5,0);

        return answer;
    }

    void permutation(int n, int cnt) {
        if (cnt == 2) {
            int flipRowNumber = rc[0];
            int flipColNumber = rc[1];




            return;
        }
        for (int i = 1; i <= n; i++) {
            rc[cnt] = i;
            permutation(n,cnt + 1);
        }
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(
                new int[][]{{0, 1, 0, 0, 0} ,{1, 0, 1, 0, 1} ,{0, 1, 1, 1, 0} ,{1, 0, 1, 1, 0} ,{0, 1, 0, 1, 0}},
                new int[][]{{0, 0, 0, 1, 1} ,{0, 0, 0, 0, 1} ,{0, 0, 1, 0, 1} ,{0, 0, 0, 1, 0} ,{0, 0, 0, 0, 1}}
            ), 5);
        Assertions.assertEquals(solution(
                new int[][]{{0, 0, 0} ,{0, 0, 0} ,{0, 0, 0}},
                new int[][]{{1, 0, 1} ,{0, 0, 0} ,{0, 0, 0}}
            ), 5);
    }
}
