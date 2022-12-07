package coding.test.programmers.Day18;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.DoubleToIntFunction;

public class 보물지도 {
    int N;
    int M;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    int[] jx ={2,-2,0,0};
    int[] jy ={0,0,-2,2};
    int[][] map;
    int[][] visited;

    int chance;

    int min;
    public int solution(int n, int m, int[][] hole) {
        N = n;
        M = m;

        chance = 1;

        map = new int[M][N];
        visited = new int[M][N];

        min = Integer.MAX_VALUE;

        for (int i = 0; i < hole.length; i++) {
            int x = hole[i][0];
            int y = hole[i][1];
            map[M-y][x-1] = -1;
        }

        bfs();
        return min;
    }

    private void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{M-1,0});
        visited[M-1][0] = 1;

        while(!q.isEmpty()){
            int[] poll = q.poll();

            int x = poll[0];
            int y = poll[1];
            if(x == 0 && y == N -1){
                min = Math.min(min, visited[0][N-1] - 1);
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isImpossible(nx, ny)) continue;
                if(visited[nx][ny] > 0 || map[nx][ny] == -1) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny] = visited[x][y] + 1;
            }

            if(chance <= 0){
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + jx[i];
                int ny = y + jy[i];

                if(isImpossible(nx, ny)) continue;
                if(visited[nx][ny] > 0 || map[nx][ny] == 1) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny] = visited[x][y] + 1;
                chance--;
            }
        }

        min = Math.min(min, visited[0][N-1] - 1);
    }

    private boolean isImpossible(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= M || ny >= N;
    }

    private void printMap() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("\t" + map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printVisited() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("\t" + visited[i][j]);
            }
            System.out.println();
        }
        System.out.println();
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
