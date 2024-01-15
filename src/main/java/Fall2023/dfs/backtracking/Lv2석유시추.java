package Fall2023.dfs.backtracking;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class Lv2석유시추 {

    private int[][] map;
    private int r;
    private int c;

    final private int[] dx = {1,-1,0,0};
    final private int[] dy = {0,0,1,-1};
    private int max;

    private boolean[][] visited;
    private int sum;

    private Set<Integer> sumset;

    public int solution(int[][] land) {
        int answer = 0;
        map = land;
        r = land.length;
        c = land[0].length;
        sumset = new HashSet<>();

        for (int i = 0; i < c; i++) {
            sum = 0;
            visited = new boolean[r][c];
            for (int j = 0; j < r; j++) {
                if(map[j][i] == 1 && !visited[j][i]) {
                    bfs(new int[]{j, i});
                    sum += max;
                }
            }
            sumset.add(sum);
        }

        return Collections.max(sumset);
    }


    private void bfs(int[] start){

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        max = 1;

        while(!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == 1 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    max++;
                }

            }
        }
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution(new int[][]{
        {0, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0},
        {1, 1, 0, 0, 0, 1, 1, 0},
        {1, 1, 1, 0, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 1, 1}}),9);
    }
}
