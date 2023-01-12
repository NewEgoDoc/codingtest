package coding.test.commulearning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int count = 0;

        int index = 0;//for stations

        int position = 1;

        while(position <= n){
            if(index < stations.length && position >= stations[index] - w){
                position = stations[index] + w + 1;
                index++;
                continue;
            }
            count++;
            position += (2 * w) + 1;
        }

        return count;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(11, new int[]{4,11}, 1), 3);
        Assertions.assertEquals(solution(16, new int[]{9}, 2), 3);
    }
}
