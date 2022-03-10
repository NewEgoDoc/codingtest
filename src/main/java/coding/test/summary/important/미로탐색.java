package coding.test.summary.important;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색 {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int solution(int n, int m, int[][] miro){
        int answer = 0;

        boolean[][] visited = new boolean[miro.length][miro[0].length];

        visited[0][0] = true;
        bfs(0, 0,visited,miro,n,m);

        return miro[n-1][m-1];
    }

    private void bfs(int x, int y, boolean[][] visited, int[][] map, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;

                q.add(new int[] {nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution(4,6,
                new int[][]{{1,0,1,1,1,1},
                            {1,0,1,0,1,0},
                            {1,0,1,0,1,1},
                            {1,1,1,0,1,1}}),15);
        Assertions.assertEquals(solution(4,6,
                new int[][]{{1,1,0,1,1,0},
                            {1,1,0,1,1,0},
                            {1,1,1,1,1,1},
                            {1,1,1,1,0,1}}),9);
        Assertions.assertEquals(solution(2,25,
                new int[][]{{1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1},
                            {1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1}}),38);
        Assertions.assertEquals(solution(7,7,
                new int[][]{{1,0,1,1,1,1,1},
                            {1,1,1,0,0,0,1},
                            {1,0,0,0,0,0,1},
                            {1,0,0,0,0,0,1},
                            {1,0,0,0,0,0,1},
                            {1,0,0,0,0,0,1},
                            {1,1,1,1,1,1,1}}),13);

    }
}
