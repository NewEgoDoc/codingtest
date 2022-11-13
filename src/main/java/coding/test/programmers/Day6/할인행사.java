package coding.test.programmers.Day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;

        List<String> wantList = new ArrayList<>();
        for (int i = 0; i < want.length; i++) {
            wantList.add(want[i]);
        }

        int[] checkNumber;

        for (int i = 0; i < discount.length; i++) {
            checkNumber = new int[want.length];

            for (int j = i; j < Math.min(i+10, discount.length); j++) {
                int index = wantList.indexOf(discount[j]);
                if(index == -1) continue;
                checkNumber[index] += 1;
            }

            boolean isCover = true;
            for (int j = 0; j < want.length; j++) {
                if(checkNumber[j] < number[j]){
                    isCover = false;
                    break;
                }
            }

            if(isCover) count++;
        }

        return count;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}),3);
        Assertions.assertEquals(solution(
                new String[]{"apple"},
                new int[]{10},
                new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}),0);
    }
}
