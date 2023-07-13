package coding.test.programmers.Lv3.bfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class NQueen {
    int[] col;
    int count;
    
    int N;
    
    public int solution(int n) {
        count = 0;
        N = n;
        for (int i = 0; i < n; i++) {
            col = new int[n];
            col[0] = i;
            dfs(1);
        }

        return count;
    }

    private void dfs(int index){
        if(index == N){
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            col[index] = i;
            if(isNotPossible(index)) continue;
            dfs(index + 1);
        }
        
    }

    private boolean isNotPossible(int index) {
        for (int i = 0; i < index; i++) {
            if(col[i] == col[index]) return true;
            if(Math.abs(index - i) == Math.abs(col[index] - col[i])) return true;
        }
        return false;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(4), 2);
    }
}
