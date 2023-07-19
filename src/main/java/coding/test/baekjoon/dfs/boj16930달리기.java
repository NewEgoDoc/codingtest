package coding.test.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj16930달리기 {
    
    static int[] target;
    static int N;
    static int M;
    static int K;

    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    static char[][] gym;
    static int[][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMK = br.readLine().split(" ");
        N = Integer.parseInt(NMK[0]);
        M = Integer.parseInt(NMK[1]);
        K = Integer.parseInt(NMK[2]);

        gym = new char[N][M];

        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                gym[i][j] = input[j];
            }
        }

        String[] a = br.readLine().split(" ");
        int[] start = new int[]{Integer.parseInt(a[0]) - 1, Integer.parseInt(a[1]) - 1};
        target = new int[]{Integer.parseInt(a[2]) - 1, Integer.parseInt(a[3]) - 1};
        bfs(start);
        System.out.println(visited[target[0]][target[1]]);
    }

    private static void bfs(int[] point){
        Queue<int[]> q = new LinkedList<>();
        q.add(point);
        visited[point[0]][point[1]] = 0;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            if(x == target[0] && y == target[1]) return;

            for (int j = 0; j < 4; j++) {
                for (int i = 1; i <= K; i++) {
                    int nx = x + (i*dx[j]);
                    int ny = y + (i*dy[j]);

                    if(isWall(nx,ny)) break;
                    //if(isBlockedInBetween(new int[]{x,y}, new int[]{nx,ny}, new int[]{dx[j], dy[j]})) continue;
                    if(visited[nx][ny] < 0){
                        visited[nx][ny] = visited[x][y] + 1;
                        q.add(new int[]{nx, ny});
                    } else if(visited[nx][ny] <= visited[x][y]){
                        break;
                    }


                }
            }
        }
    }

    private static boolean isBlockedInBetween(int[] from, int[] to, int[] direction) {
//        if(direction[0] == 1 && direction[1] == 0){
//            for (int i = from[0]; i < to[0]; i++) {
//                if(gym[i][from[1]] == '#') return true;
//            }
//        }
//
//        if(direction[0] == -1 && direction[1] == 0){
//            for (int i = to[0]; i < from[0]; i++) {
//                if(gym[i][from[1]] == '#') return true;
//            }
//        }
//
//        if(direction[0] == 0 && direction[1] == 1){
//            for (int i = from[1]; i < to[1]; i++) {
//                if(gym[from[0]][i] == '#') return true;
//            }
//        }
//
//        if(direction[0] == 0 && direction[1] == -1){
//            for (int i = to[1]; i < from[1]; i++) {
//                if(gym[from[0]][i] == '#') return true;
//            }
//        }
//        return false;
        int x = from[0];
        int y = from[1];

        while (x != to[0] || y != to[1]) {
            x += direction[0];
            y += direction[1];

            if (gym[x][y] == '#') {
                return true;
            }
        }

        return false;
    }

    private static boolean isWall(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M || gym[nx][ny] == '#';
    }
}
