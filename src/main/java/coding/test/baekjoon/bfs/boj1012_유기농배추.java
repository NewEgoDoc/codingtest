package coding.test.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class boj1012_유기농배추 {
    static int[][] map;
    static int n;
    static int m;
    static int k;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int count;
    static int solution(){
        count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    count++;
                    dfs(i,j);
                }
            }
        }

        return count;
    }

    static void dfs(int x, int y){
        map[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isImpossibleRange(nx, ny)) continue;
            if(map[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }

    private static boolean isImpossibleRange(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= n || ny >= m;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] mnk = br.readLine().split(" ");
            m = Integer.parseInt(mnk[0]);
            n = Integer.parseInt(mnk[1]);
            k = Integer.parseInt(mnk[2]);

            map = new int[n][m];
//            for (int[] m: map){
//                System.out.println(Arrays.toString(m));
//            }
//            System.out.println();
            visited = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);

                map[y][x] = 1;
            }
            System.out.println();
            for (int[] m: map){
                System.out.println(Arrays.toString(m));
            }
            System.out.println();

            System.out.println(solution());
        }

    }
}
