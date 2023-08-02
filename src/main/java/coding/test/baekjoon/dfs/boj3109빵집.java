package coding.test.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj3109빵집 {

    static int R;
    static int C;

    static String[][] map;

    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};

    static boolean[][] visited;

    static int count;

    static boolean isStop;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);

        map = new String[R][C];
        for (int i = 0; i < R; i++) {
            String[] positions = br.readLine().split("");
            for (int j = 0; j < positions.length; j++) {
                map[i][j] = positions[j];
            }
        }

        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        count = 0;
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            isStop = false;
<<<<<<< HEAD
            visited[i][0] = true;
=======
>>>>>>> origin/master
            dfs(i, 0);

            for (int j = 0; j < R; j++) {
                System.out.println(Arrays.toString(visited[j]));
            }

            System.out.println();
        }


<<<<<<< HEAD
        System.out.println(count);
    }

    private static void dfs(int x, int y){
=======


        System.out.println("count = " + count);
    }

    private static void dfs(int x, int y){
        if(isStop) return;

>>>>>>> origin/master
        if(y == C-1){
            count++;
            isStop = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= R || ny >= C || ny < 0 || nx < 0) continue;
            if(visited[nx][ny]) continue;
<<<<<<< HEAD
            if(map[nx][ny].equals(".")) {

                dfs(nx, ny);
                visited[nx][ny] = true;
                if(isStop){
                    return;
                }
            }
=======
            if(map[nx][ny].equals("x")) continue;

            visited[nx][ny] = true;
            dfs(nx, ny);
>>>>>>> origin/master
        }
    }
}
