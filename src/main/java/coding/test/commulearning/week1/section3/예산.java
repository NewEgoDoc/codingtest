package coding.test.commulearning.week1.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int min = 0;
        int max = 0;
        for(int budget: budgets){
            max = Math.max(max, budget);
        }

        int mid;
        while(min <= max){
            //중간값을 구하고
            mid = (min + max)/2;

            //총예산값을 구하는데 만약에 해당 예산이 mid보다 높다면 mid로 바꿔서 더해줌
            int sum = 0;
            for(int budget: budgets){
                if(budget > mid){
                    sum += mid;
                    continue;
                } 
                sum += budget;
            }

            //해당 예산의 총합값이 최대 예산값보다 작다면 최소값 조정 그리고 해당 mid 값을 answer로 갱신하면서 계산
            if(sum <= M) {
                min = mid + 1;
                answer = mid;
                continue;
            }
            max = mid - 1;
        }


        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{120, 110, 140, 150}, 485), 127);
    }
}
