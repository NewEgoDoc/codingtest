package coding.test.commulearning.week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 판데믹 {

    int n;
    int m;
    int max;
    int[][] result;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        n = rows;
        m = columns;
        max = max_virus;
        result = new int[n][m];


        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            bfs(new int[]{query[0]-1,query[1]-1});
        }

        return result;
    }

    void bfs(int[] point){

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(point);
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            if(result[x][y] < max) {
                result[x][y] += 1;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isPossible(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

    }

    boolean isPossible(int x, int y){
        return x < 0 || y < 0 || x >= n || y >= m;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution(3,4,2, new int[][]{
                {3,2}, {3,2}, {2,2}, {3,2}, {1,4}, {3,2}, {2,3}, {3,1}}),
        new int[][]{{0,2,1,1}, {2,2,2,1}, {2,2,2,1}});
    }
}
