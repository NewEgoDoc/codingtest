package coding.test.summary.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 타일채우기 {

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n % 2 == 1){
            System.out.println(0);
            return;
        }
        n /= 2;
        dp = new int[16];

        dp[1] = 3;
        dp[2] = 11;

        for (int i = 3; i <= n; i++) {
            dp[i] += 3*dp[i-1];

            for (int j = 2; j <= i; j++) {
                dp[i] += 2*dp[i - j];
            }

            dp[i] += 2;

            //dp[i] = 3*dp[i-1] + 2*dp[i-2] + 2*dp[i-3] + 2;
        }

        System.out.println(dp[n]);
    }
}
