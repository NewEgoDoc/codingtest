package coding.test.commulearning.week3.section1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth: clothes){
            map.put(cloth[1],map.getOrDefault(cloth[1], 1)+1);
        }

        for(String key: map.keySet()){
            answer *= map.get(key);
        }
        return answer - 1;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new String[][]{
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}
        }),5);
        Assertions.assertEquals(solution(new String[][]{
                {"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}
        }),3);
    }
}
