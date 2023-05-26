package coding.test.programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Lv3경주로건설 {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    int[][][] visited;
    int[][] map;

    int n;
    int min;

    public int solution(int[][] board) {
        map = board;
        n = board.length;
        visited = new int[n][n][5];
        bfs();
        return min;
    }

    void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,-1,0});
        visited[0][0][0] = 1;
        visited[0][0][1] = 1;

        min = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int previousDirection = poll[2];
            int cost = poll[3];

            if(x == n -1 && y == n - 1){
                min = Math.min(min, cost);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isImpossible(nx, ny) || map[nx][ny] == 1) continue;

                int nextCost = cost;

                if(previousDirection == -1 || previousDirection == i) {
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }
                if(visited[nx][ny][i] == 0 || (visited[nx][ny][4] == 0 || visited[nx][ny][4] >= nextCost)){
                    q.add(new int[]{nx,ny,i,nextCost});
                    visited[nx][ny][i] = 1;
                    visited[nx][ny][4] = nextCost;
                }

            }
        }
    }

    boolean isImpossible(int nx, int ny){
        return nx < 0 || ny < 0 || nx >= n || ny >= n;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}), 900);
        Assertions.assertEquals(solution(new int[][]{{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,0}, {0,0,0,1,0,0,0,1}, {0,0,1,0,0,0,1,0}, {0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}}), 3800);
        Assertions.assertEquals(solution(new int[][]{{0,0,1,0}, {0,0,0,0}, {0,1,0,1}, {1,0,0,0}}), 2100);
        Assertions.assertEquals(solution(new int[][]{{0,0,0,0,0,0}, {0,1,1,1,1,0}, {0,0,1,0,0,0}, {1,0,0,1,0,1}, {0,1,0,0,0,1}, {0,0,0,0,0,0}}), 3200);
    }
}
