package coding.test.programmers.Day22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.*;

public class 숫자타자대회 {
    public int[][] cost = {
        { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
        { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
        { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
        { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
        { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
        { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
        { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
        { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
        { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
        { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
    };

    public int[][][] dp; //dp[ind][left][right]
    public String arr;
    public int len;

    public int solve(int index, int left, int right) {

        if (index == len) {
            return 0;
        }

        //dp로 이미 거쳐왔던 연산이라면 빠져나가기
        if (dp[index][left][right] > 0) {
            return dp[index][left][right];
        }

        int target = arr.charAt(index) - '0';// 타겟 넘버
        int min = Integer.MAX_VALUE;

        //왼쪽손
        if (target != right) {
            min = Math.min(solve(index+1, target, right) + cost[left][target], min);
        }

        //오른손
        if (target != left) {
            min = Math.min(solve(index+1, left, target) + cost[right][target], min);
        }

        return dp[index][left][right] = min;
    }

    public int solution(String numbers) {
        arr = numbers;
        len = numbers.length();
        //초기화
        dp = new int[len][10][10];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(0, 4, 6);
    }

    @Test
    void test(){
        Assertions.assertEquals(solution("1756"),10);
        Assertions.assertEquals(solution("5123"),8);
    }
}
