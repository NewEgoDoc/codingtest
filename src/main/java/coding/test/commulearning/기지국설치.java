package coding.test.commulearning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 0;//for stations array
        int position = 1;

        while(position <= n){
            if(index < stations.length && position >= stations[index] - w){
                position = stations[index] + w + 1;
                index++;
            } else {
                answer++;//일단 기지국 세움
                //전파 범위만큼 다음 position으로 넘어감
                position += w * 2 + 1;
            }
        }

        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(11, new int[]{4,11}, 1), 3);
        Assertions.assertEquals(solution(16, new int[]{9}, 2), 3);
    }
}
