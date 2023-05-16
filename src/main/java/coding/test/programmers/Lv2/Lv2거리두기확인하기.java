package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lv2거리두기확인하기 {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    
    boolean[][] visited;

    String[] waitingRoom;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int k = 0; k < places.length; k++) {

            answer[k] = 1;
            waitingRoom = places[k];

            for (int i = 0; i < waitingRoom.length; i++) {
                for (int j = 0; j < waitingRoom[i].length(); j++) {
                    if(waitingRoom[i].charAt(j) == 'P'){
                        if(bfs(i,j) == 0){
                            answer[k] = 0;
                            break;
                        }
                    }
                }
                if(answer[k] == 0){
                    break;
                }
            }
        }
        return answer;
    }

    int bfs(int i, int j){
        visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int distance = Math.abs(nx - i) + Math.abs(ny - j);

                if(isPossiblePosition(nx,ny)) continue;
                if(visited[nx][ny]) continue;
                if(distance > 2) continue;

                visited[nx][ny] = true;

                if(waitingRoom[nx].charAt(ny) == 'P') return 0;
                if(waitingRoom[nx].charAt(ny) == 'O') q.add(new int[]{nx, ny});

            }
        }
        return 1;
    }

    private boolean isPossiblePosition(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= 5 || ny >= 5;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}), new int[]{1, 0, 1, 1, 1});
    }
}
