package coding.test.programmers.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 롤케이크자르기 {
    public int solution(int[] topping) {
        int length = topping.length;

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        set.add(topping[0]);//첫번째 토핑 넣고
        for (int i = 1; i < length; i++) {
            int number = topping[i];
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int answer = 0;
        for (int i = 1; i < length; i++) {
            int number = topping[i];

            set.add(number);

            int numberSize = map.get(number);
            if (numberSize == 1) {
                map.remove(number);
            } else {
                map.put(number, numberSize - 1);
            }

            if (set.size() == map.size()) {
                answer++;
            }
        }

        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}),2);
        Assertions.assertEquals(solution(new int[]{1, 2, 3, 1, 4}),0);
    }
}
