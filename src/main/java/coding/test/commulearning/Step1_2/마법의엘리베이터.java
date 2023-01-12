package coding.test.commulearning.Step1_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 마법의엘리베이터 {
    public int solution(int storey) {
        int answer = 0;
        while(storey >= 1){
            int now = storey % 10;
            if((now == 5) && ((storey / 10) % 10) >= 5 || now > 5){
                storey += 10 - now;
                answer += 10 - now;
                storey = storey / 10;
                continue;
            }
            answer += now;
            storey = storey / 10;
        }

        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(16),6);
        Assertions.assertEquals(solution(2554),16);
        Assertions.assertEquals(solution(197),5);
    }
}
