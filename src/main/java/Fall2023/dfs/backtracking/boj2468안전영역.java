package Fall2023.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2468안전영역 {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(new int[]{i, j});
            }
        }

        System.out.println(count);
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
    }

    private static int dfs(int[] start){
        visited[start[0]][start[1]] = true;
        for (int i = 0; i < 4; i++) {
            int nx = start[0] + dx[i];
            int ny = start[1] + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
            if(map[nx][ny] <= N) continue;

            visited[nx][ny] = true;
            dfs(new int[]{nx, ny});
        }

        return 1;
    }
}
