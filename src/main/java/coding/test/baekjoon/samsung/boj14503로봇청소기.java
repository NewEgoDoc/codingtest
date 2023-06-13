package coding.test.baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14503로봇청소기 {
    static int n;
    static int m;
    static int[][] map;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        String[] robotPositionDirection = br.readLine().split(" ");
        int[] robotState =  {
                Integer.parseInt(robotPositionDirection[0]) - 1,
                Integer.parseInt(robotPositionDirection[1]) - 1,
                Integer.parseInt(robotPositionDirection[2])
        };

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        answer = 0;
        dfs(robotState[0], robotState[1], robotState[2]);

    }

    static void dfs(int x, int y, int direction){
        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(map[nx][ny] != 0) continue;

            answer++;
            dfs(nx,ny,direction);
            return;
        }

        int back = (direction + 2) % 4;
        int nx = x + dx[back];
        int ny = y + dy[back];

        if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 1){
            dfs(nx,ny,direction);
        }

    }

}
