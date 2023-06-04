package coding.test.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj14500테트로미노 {

    private static int N;
    private static int M;

    private static int[][] paper;

    private static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int[] p: paper){
            System.out.println(Arrays.toString(p));
        }
        max = 0;
        dfs();
    }

    static void dfs(){

    }
}
