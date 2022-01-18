package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Lv2더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);
        
        for(int spicy: scoville) pq.offer(spicy);

        System.out.println("pq = " + pq);
        System.out.println("pq.peek() = " + pq.peek());
        
        int count = 0;
        while(pq.size() > 1 && pq.peek() < K){
            pq.offer(pq.poll() + (pq.poll()*2));
            count++;
        }

        if(pq.size() <= 1 && pq.peek() < K) return -1;

        return count;
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution(new int[]{1, 2, 3, 9, 10, 12}, 7),2);
    }
}
