package coding.test.programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lv3네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]) answer += dfs(i, computers,visited);
        }

        return answer;
    }
    public int dfs(int i, int[][] computers, boolean[] visited) {
        if (visited[i]) {
            return 0;
        }
        visited[i] = true;
        for (int j = 0; j < computers[i].length; j++) {
            if (computers[i][j] == 1) {
                dfs(j, computers, visited);
            }
        }

        return 1;
    }

    @Test
    public void test(){
        assertEquals(solution(3,new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}),2);
        assertEquals(solution(3,new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 0, 1}}),1);
    }
}
