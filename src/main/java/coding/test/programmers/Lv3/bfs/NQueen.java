package coding.test.programmers.Lv3.bfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class NQueen {

    int[] visit;
    int N;
    int count;

    public int solution(int n) {
        count = 0;
        N = n;
        for (int i = 0; i < n; i++) {
            visit = new int[n];
            visit[0] = i;
            recur(1);
        }
        return count;
    }

    void recur(int idx){
        if(idx == N){
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            visit[idx] = i;
            if(isPossibleNext(idx)) {
                recur(idx+1);
            } else {
                visit[idx] = 0;
            }
        }
        visit[idx] = 0;
    }

    private boolean isPossibleNext(int idx) {
        for(int i = 0 ; i < idx ; ++i){
            if(visit[i] == visit[idx]) return false;
            if(Math.abs(idx - i) == Math.abs(visit[idx] - visit[i])) return false;
        }
        return true;
    }
    @Test
    void test(){
        Assertions.assertEquals(solution(4), 2);
    }
}
