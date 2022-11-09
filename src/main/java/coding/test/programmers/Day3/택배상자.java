package coding.test.programmers.Day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 택배상자 {
    public int solution(int[] order) {

        Queue<Integer> main = new LinkedList<>();
        for (int i = 1; i <= order.length; i++) {
            main.offer(i);
        }
        Stack<Integer> sub = new Stack<>();

        List<Integer> truck = new ArrayList<>();

        int index = 0;

        while(!main.isEmpty()){
            int now = main.poll();

            if(now == order[index]){
                truck.add(now);
                index++;
                continue;
            }

            if(now != order[index]){

                index = checkAuxiliaryConveyor(order, sub, truck, index);

                sub.push(now);
            }
        }

        index = checkAuxiliaryConveyor(order, sub, truck, index);
        
        System.out.println("main = " + main);
        System.out.println("sub = " + sub);

        return truck.size();
    }

    private int checkAuxiliaryConveyor(int[] order, Stack<Integer> sub, List<Integer> truck, int index) {
        while(!sub.isEmpty() && sub.peek() == order[index]){
            truck.add(sub.pop());
            index++;
        }
        return index;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{4, 3, 1, 2, 5}),2);
        Assertions.assertEquals(solution(new int[]{5, 4, 3, 2, 1}),5);
    }
}
