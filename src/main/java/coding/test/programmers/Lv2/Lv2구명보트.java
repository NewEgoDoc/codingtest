package coding.test.programmers.Lv2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Lv2구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }

        return answer;
    }
    @Test
    public void test(){
        assertEquals(solution(new int[]{70, 50, 80, 50},100),3);
        //assertEquals(solution(new int[]{70, 80, 50},100),3);
    }
}
