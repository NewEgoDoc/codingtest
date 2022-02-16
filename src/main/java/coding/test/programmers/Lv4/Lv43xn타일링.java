package coding.test.programmers.Lv4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lv43xn타일링 {
    public int solution(int n) {
        long[] dp = new long[5010];

        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i+=2) {
            dp[i] = dp[i-2]* 3;
            for (int j = i-4; j >= 0; j-=2) {
                dp[i] += dp[j]*2;
            }

            dp[i] = dp[i] % 1000000007;
        }
        
        return (int)dp[n];
    }

    @Test
    public void test(){
        assertEquals(solution(2),3);
        assertEquals(solution(4),11);

    }
}
