package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Lv2주식가격 {
    public int[] solution(int[] prices) {
        List<Integer> list = new ArrayList<>();
        int second;
        for (int i = 0; i < prices.length-1; i++) {
            second = 0;
            for (int j = i+1; j < prices.length; j++) {
                if(prices[i] <= prices[j]){
                    second++;
                }
            }
            list.add(second);
        }

        list.add(0);

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    @Test
    public void test(){
        Assertions.assertArrayEquals(solution(new int[]{1, 2, 3, 2, 3}),new int[]{4,3,1,1,0});
    }
}
