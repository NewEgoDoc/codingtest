package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lv2위장 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {

            String category = clothes[i][1];

            if(map.containsKey(category)){
                map.put(category,map.get(category) + 1);
            } else {
                map.put(category,1);
            }
        }

        int possibleNumber = 1;
        for(Integer number: map.values()){
            possibleNumber *= (number+1);
        }

        return possibleNumber-1;
    }

    @Test
    public void test(){
        assertEquals(solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}),5);
        assertEquals(solution(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}),3);
    }

}
