package coding.test._2023_05_06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution3 {
    int w;
    int h;

    String[] matrix;
    int[][] visited;

    int[] dx = {1,-1,0,0,1,1,-1,-1};
    int[] dy = {0,0,-1,1,1,-1,1,-1};
    public String[] solution(String[] board, int y, int x) {
        String[] answer = new String[board.length];
        w = board[0].length();
        h = board.length;
        matrix = board;
        initVisited();

        if(isMineSweeper(y,x)){
            for (int i = 0; i < h; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(board[i]);
                if(i == y){
                    sb.setCharAt(x,'X');
                }
                answer[i] = sb.toString();
            }
            return answer;
        }

        bfs(new int[]{y,x});

        for (int i = 0; i < h; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < w; j++) {
                if(visited[i][j] == 0) sb.append('B');
                if(visited[i][j] == -1) sb.append('E');
                if(visited[i][j] > 0) sb.append(visited[i][j]);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    private boolean isMineSweeper(int y, int x) {
        return matrix[y].charAt(x) == 'M';
    }

    private void initVisited(){
        visited = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                visited[i][j] = -1;
            }
        }
    }


    private void bfs(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = 0;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            int mark = 0;
            List<int[]> next = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isPossible(nx, ny)) continue;
                if(visited[nx][ny] > -1) continue;
                if(matrix[nx].charAt(ny) == 'M'){
                    mark++;
                } else {
                    next.add(new int[]{nx, ny});
                }
            }

            visited[x][y] = mark;
            if(mark == 0){
                for(int[] n: next){
                    q.add(n);
                }
            }

        }
    }

    private boolean isPossible(int nx, int ny) {
        return  nx < 0 || ny < 0 || nx >= h || ny >= w;
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(solution(new String[]{"EEEEE", "EEMEE", "EEEEE", "EEEEE"}, 2,0), new String[]{"B1E1B", "B1E1B", "B111B", "BBBBB"});
        Assertions.assertArrayEquals(solution(new String[]{"MME", "EEE", "EME"}, 0,0),new String[]{"XME", "EEE", "EME"});
    }
}
