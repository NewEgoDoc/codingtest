package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lv2다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int weigthOfCarsOnBridge = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            int truck_weight = truck_weights[i];

            while(true){
                if(queue.isEmpty()){
                    queue.add(truck_weight);
                    weigthOfCarsOnBridge += truck_weight;
                    time++;
                    break;
                } else if(queue.size() == bridge_length){
                    weigthOfCarsOnBridge -= queue.poll();
                } else {
                    if(weigthOfCarsOnBridge + truck_weight <= weight){
                        queue.add(truck_weight);
                        weigthOfCarsOnBridge += truck_weight;
                        time++;
                        break;
                    } else {
                        queue.add(0);
                        time++;
                    }
                }
            }

            System.out.println("queue = " + queue);

        }
        return time + bridge_length;
    }

    @Test
    public void test(){
        assertEquals(solution(2,10,new int[]{7,4,5,6}),8);
        assertEquals(solution(100,100,new int[]{10}),101);
        assertEquals(solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10}),110);
    }
}
