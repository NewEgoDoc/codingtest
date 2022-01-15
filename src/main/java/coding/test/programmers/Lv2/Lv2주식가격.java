package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Lv2주식가격 {
    public int[] solution(int[] prices) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < prices.length -1; i++) {
            int presentPoint = prices[i];
            int period = 0;
            for (int j = i+1; j < prices.length; j++) {
                period++;
                if(prices[j] < presentPoint){
                    break;
                }
            }
            list.add(period);
        }
        list.add(0);

        int[] answer = toIntArray(list);

        return answer;
    }

    private int[] toIntArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    @Test
    public void test(){
        Assertions.assertArrayEquals(solution(new int[]{1, 2, 3, 2, 3}),new int[]{4,3,1,1,0});
    }
}
