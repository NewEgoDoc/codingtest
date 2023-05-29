package coding.test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj14501퇴사 {
    static int N;
    static int[] T;
    static int[] P;

    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int t = Integer.parseInt(input[0]);
            int p = Integer.parseInt(input[1]);

            T[i] = t;
            P[i] = p;
        }

        int[] dp = new int[N+1];

        for (int i=0; i<N; i++) {
            if (i + T[i] <= N) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N]);

    }
}
