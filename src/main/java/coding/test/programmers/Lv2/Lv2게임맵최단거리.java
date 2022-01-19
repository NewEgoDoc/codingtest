package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2게임맵최단거리 {

    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    int[][] visited;
    public int solution(int[][] maps) {

        visited = new int[maps.length][maps[0].length];

        bfs(maps);
        int num = visited[maps.length - 1][maps[0].length -1];

        if(num == 0){
            num = -1;
        }
        return num;
    }

    private void bfs(int[][] maps) {
        int x = 0;
        int y = 0;

        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int nowX = current[0];
            int nowY = current[1];

            for(int i = 0; i < 4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1)
                    continue;

                if(visited[nx][ny] == 0 && maps[nx][ny] == 1){
                    visited[nx][ny] = visited[nowX][nowY] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

    }

    @Test
    public void test(){
        Assertions.assertEquals(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}), 11);
        Assertions.assertEquals(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}), -1);
    }
}
