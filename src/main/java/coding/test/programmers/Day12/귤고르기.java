package coding.test.programmers.Day12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 귤고르기 {
    //맵을 정렬해서 마지막 혹은 맨앞에 있는 개수의 종류를 세어주면 해당 문제는 클리어
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int tgr: tangerine){
            map.put(tgr, map.getOrDefault(tgr, 0) + 1);
        }

        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(((o1, o2) -> map.get(o2).compareTo(map.get(o1))));

        int sum = 0;
        int count = 0;
        for (int key: keySet){
            if(sum >= k) break;
            sum += map.get(key);
            count++;
        }
        
        return count;
    }


    @Test
    void test(){
        Assertions.assertEquals(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}),3);
        Assertions.assertEquals(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}),2);
        Assertions.assertEquals(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}),1);
    }
}
