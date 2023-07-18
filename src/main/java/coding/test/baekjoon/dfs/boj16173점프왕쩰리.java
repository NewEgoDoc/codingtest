package coding.test.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj16173점프왕쩰리 {

    static int N;
    static int[][] map;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static boolean isEnd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isEnd = false;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0,0);

        System.out.println(isEnd? "HaruHaru": "Hing");
    }

    private static void dfs(int x, int y){
        if(map[x][y] == -1){
            isEnd = true;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + map[x][y]*dx[i];
            int ny = y + map[x][y]*dy[i];

            if(nx >= N || ny >= N) continue;
            if(nx == x && ny == y) continue;
            dfs(nx, ny);
        }
    }
}
