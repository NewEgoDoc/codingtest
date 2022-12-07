package coding.test.programmers.Day17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 카페확장 {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        q.add(menu[order[0]]);
        int lastMenuOutTime = menu[order[0]];
        for (int i = 1; i < (order.length * k); i++) {
            if(!q.isEmpty() && (i == q.peek())) {
                q.poll();
            }

            if(i % k == 0) {
                if(q.isEmpty()){
                    q.add(i + menu[order[i / k]]);
                    lastMenuOutTime = i + menu[order[i / k]];
                } else {
                    q.add(lastMenuOutTime + menu[order[i / k]]);
                    lastMenuOutTime += menu[order[i / k]];
                }
            }
            answer = Math.max(answer, q.size());
            
        }

        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{5,12,30},new int[]{1,2,0,1},10),3);
        Assertions.assertEquals(solution(new int[]{5,12,30},new int[]{2,1,0,0,0,1,0},10),4);
        Assertions.assertEquals(solution(new int[]{5},new int[]{0,0,0,0},5),1);
    }
}
