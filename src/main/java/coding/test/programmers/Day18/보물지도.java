package coding.test.programmers.Day18;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

public class 보물지도 {
    int N;
    int M;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    int[] jx ={2,-2,0,0};
    int[] jy ={0,0,-2,2};
    int[][] map;
    boolean[][][] visited;

    int min;

    public int solution(int n, int m, int[][] hole) {
        min = Integer.MAX_VALUE;
        N = n;
        M = m;
        visited = new boolean[n][m][2];
        map = new int[n][m];
        for (int[] h : hole){
            map[h[0] - 1][h[1] - 1] = 1;
        }

        bfs();

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }

    private void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,1});//x, y, count, jumpCount
        visited[0][0][1] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int count = poll[2];
            int jump = poll[3];

            if (x == N - 1 && y == M - 1) {
                min = Math.min(count, min);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isImpossible(nx,ny)) continue;
                if(visited[nx][ny][jump]) continue;
                if(map[nx][ny] == 1) continue;

                visited[nx][ny][jump] = true;
                q.add(new int[]{nx, ny, count + 1, jump});//jump 안씀
            }

            if(jump > 0){
                for (int i = 0; i < 4; i++) {
                    int nx = x + jx[i];
                    int ny = y + jy[i];

                    if(isImpossible(nx,ny)) continue;
                    if(visited[nx][ny][jump]) continue;
                    if(map[nx][ny] == 1) continue;

                    visited[nx][ny][jump - 1] = true;
                    q.add(new int[]{nx, ny, count + 1, jump - 1});//jump 안씀
                }
            }
        }
    }

    private boolean isImpossible(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution(4,4,new int[][]{
                {2, 3}, {3, 3}
        }),5);
        Assertions.assertEquals(solution(5,4,new int[][]{
                {1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 3}, {4, 1}, {4, 3}, {5, 3}
        }),-1);
        Assertions.assertEquals(solution(5,5,new int[][]{
                {1, 2}, {2, 2}, {2, 1}, {3, 3}, {4, 4}, {4, 5}
        }),7);
    }
}
