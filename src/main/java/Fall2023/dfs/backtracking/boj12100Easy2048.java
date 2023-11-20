package Fall2023.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj12100Easy2048 {

    static int N;
    static int[][] map;
    static int[][] temp;
    static int[] directions;
    static int[][] tmp;
    static boolean[][] visit;
    static int max;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = 0;
        map = new int[N][N];
        directions = new int[5];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0);

        System.out.println();
    }

    private static void dfs(int index){
        if (index == 5) {
            temp = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                temp[i] = map[i].clone();
            }

            for (int d = 0; d < directions.length; d++) {
                visit = new boolean[N + 1][N + 1];

                if (directions[d] == 0) {
                    for (int i = 1; i <= N; i++) {
                        for (int j = 1; j <= N; j++) {
                            move(i, j, directions[d]);
                        }
                    }
                } else if (directions[d] == 2) {
                    for (int i = N; i >= 1; i--) {
                        for (int j = 1; j <= N; j++) {
                            move(i, j, directions[d]);
                        }
                    }
                } else if (directions[d] == 1) {//우
                    for (int i = N; i >= 1; i--) {
                        for (int j = 1; j <= N; j++) {
                            move(j, i, directions[d]);
                        }
                    }
                } else {//좌
                    for (int i = 1; i <= N; i++) {
                        for (int j = 1; j <= N; j++) {
                            move(j, i, directions[d]);
                        }
                    }
                }
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(index);
            directions[index] = i;
            dfs(index + 1);
        }
    }

    private static void move(int x, int y, int dir) {

        if (temp[x][y] == 0) {
            return;
        }

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 1 || ny < 1 || nx > N || ny > N) {
                return;
            }
            if (visit[nx][ny]) {
                return;
            }
            if (temp[nx][ny] == temp[x][y]) {
                //같을때 합치기
                visit[nx][ny] = true;
                temp[nx][ny] *= 2;
                temp[x][y] = 0;
                return;
            } else if (temp[nx][ny] != 0) {
                //같지 않고 다른 수가 있을 때 못합침
                return;
            }

            temp[nx][ny] = temp[x][y];
            temp[x][y] = 0;
            x = nx;
            y = ny;

        }

    }//move
}
