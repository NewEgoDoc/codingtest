package coding.test.programmers.Day21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {

        int life = n;
        int invincible = k;

        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < enemy.length; i++){
            System.out.println("pq = " + pq);
            pq.add(enemy[i]);

            //무적권을 가진 횟수보다 큐의 크기가 커지면
            if (pq.size() > invincible){
                //가장 작은수 빼주고
                life -= pq.poll();
            }
            if (life < 0){//가장 작은수를 뺐는데도 라이프가 다 달았으면
                return i;
            }
        }
        return enemy.length;
    }



    @Test
    void test(){
        Assertions.assertEquals(solution(7,3, new int[]{4, 2, 4, 5, 3, 3, 1}),5);
        System.out.println();
        Assertions.assertEquals(solution(2,4, new int[]{3,3,3,3}),4);
    }
}
