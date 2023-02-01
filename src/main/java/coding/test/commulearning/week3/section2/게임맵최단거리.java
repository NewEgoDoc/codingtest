package coding.test.commulearning.week3.section2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    private int[][] visited;

    private int n;
    private int m;

    private int[] dx = {1,-1,0,0};
    private int[] dy = {0,0,-1,1};

    int[][] maze;

    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        maze = maps;
        bfs();

        return visited[n-1][m-1] - 1;
    }

    void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = 2;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            if(x == (n-1) && y == (m-1)){
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isImpossible(nx,ny)) continue;
                if(visited[nx][ny] > 0 || maze[nx][ny] == 0) continue;

                visited[nx][ny] = visited[x][y] + 1;
                q.add(new int[]{nx,ny});
            }
        }

    }

    boolean isImpossible(int x, int y){
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}
