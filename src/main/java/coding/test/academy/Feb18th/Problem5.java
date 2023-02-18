package coding.test.academy.Feb18th;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem5 {
    int[][] map;//m,n
    int M;
    int N;

    int[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    int min;
    int solution(int[][] maze, int m, int n){
        min = Integer.MAX_VALUE;
        M = m;
        N = n;
        map = maze;
        for (int i = 0; i < m; i++) {
            visited = new int[m][n];
            bfs(new int[]{i,0});
        }

        if(min == Integer.MAX_VALUE) return -1;

        return min - 1;
    }

    void bfs(int[] start){
        if(map[start[0]][start[1]] == 0) return;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = 1;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            
            if(y == N-1) {
                min = Math.min(min, visited[x][y]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isImpossiblePoint(nx, ny)) continue;
                if(visited[nx][ny] > 1 || map[nx][ny] == 0) continue;

                q.add(new int[]{nx, ny});
                visited[nx][ny] = visited[x][y] + 1;
            }
        }
    }

    private boolean isImpossiblePoint(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= M || ny >= N;
    }


    @Test
    void test(){
        Assertions.assertEquals(solution(new int[][]{
                {0,1,0,1,1},
                {1,0,1,1,1},
                {1,1,0,0,1},
                {1,1,1,1,0},
                {1,0,1,1,1}
        }, 5, 5),5);
        Assertions.assertEquals(solution(new int[][]{
                {0,1,0,1,1},
                {0,0,1,1,1},
                {0,1,0,0,1},
                {0,1,1,1,0},
        }, 4, 5),-1);
    }
}
