package Fall2023.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1062가르침 {
    static int N;
    static int K;

    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
    }
}
