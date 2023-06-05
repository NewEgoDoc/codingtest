package coding.test.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj14500테트로미노 {

    private static int N;
    private static int M;

    private static int[][] paper;

    private static boolean[][] visited;

    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

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
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i,j,0,paper[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int index, int sum){
        if(index == 3){
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isPossiblePosition(nx, ny) || visited[nx][ny]){
                continue;
            }

            // |_|_|_|
            //   |_|
            //이런 모양이 문제가 되니 두번째에서 탐색을 한번더!
            if(index == 1){
                visited[nx][ny] = true;
                dfs(x, y, index + 1, sum + paper[nx][ny]);
                visited[nx][ny] = false;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, index + 1, sum + paper[nx][ny]);
            visited[nx][ny] = false;


        }
    }

    private static boolean isPossiblePosition(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }
}
