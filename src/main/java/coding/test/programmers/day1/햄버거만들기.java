package coding.test.programmers.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 햄버거만들기 {

    List<Integer> order;

    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        recipe();

        for (int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
            if(list.size() >= 4){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(list.get(list.size() - 4));
                tmp.add(list.get(list.size() - 3));
                tmp.add(list.get(list.size() - 2));
                tmp.add(list.get(list.size() - 1));

                if(tmp.equals(order)){
                    answer++;
                    list.remove(list.size() -1);
                    list.remove(list.size() -1);
                    list.remove(list.size() -1);
                    list.remove(list.size() -1);
                }
            }
        }
        
        return answer;
    }

    private void recipe() {
        order = new ArrayList<>();
        order.add(1);
        order.add(2);
        order.add(3);
        order.add(1);
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}),2);
        Assertions.assertEquals(solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}),0);
    }
}
