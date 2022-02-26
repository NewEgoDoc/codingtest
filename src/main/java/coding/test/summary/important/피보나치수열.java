package coding.test.summary.important;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 피보나치수열 {
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[46];

        StringBuilder sb = new StringBuilder();
        dfs(45);

        for (int i = 1; i < 46; i++) {
            sb.append(dp[i] + " ");
        }
        System.out.println();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int n) {
        if(dp[n] > 0) return dp[n];
        if(n == 1) return dp[n] = 1;
        if(n == 2) return dp[n] = 1;

        return dp[n] = dfs(n-1) + dfs(n-2);
    }
}
