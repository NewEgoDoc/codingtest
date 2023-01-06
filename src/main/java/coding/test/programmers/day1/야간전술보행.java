package coding.test.programmers.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class 야간전술보행 {
    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = 0;

        // key : 정렬된 scope      value : times
        HashMap<int[], int[]> schedule = new HashMap<>();
        // 2차원 배열 정렬
        for(int i=0; i<scope.length; i++) {
            Arrays.sort(scope[i]);
            System.out.print(Arrays.toString(scope[i]) + " : ");
            schedule.put(scope[i], times[i]);
            System.out.println(Arrays.toString(schedule.get(scope[i])));
        }
        Arrays.sort(scope, Comparator.comparingInt(o1 -> o1[0]));

        for(int i=0; i<scope.length; i++) {
            int[] time = schedule.get(scope[i]);
            int fullTime = time[0] + time[1];

            //딱 범위 전까지 가자고오~
            answer = scope[i][0] - 1;

            //쉬는 동안만 움직이고
            for(int j = 0; j <= scope[i][1] - scope[i][0]; j++) {

                // 현재 위치 % fulltime < 쉬는시간 => 쉬는시간끝났으니 걸림
                if(answer % fullTime < time[0]) {
                    return answer+1;
                }
                answer = answer + 1;
            }
        }

        //for문을 빠져 나왔다면 모든 가능한 distance 넘어옴
        answer = distance;
        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(10,
                new int[][]{{3, 4}, {5, 8}},
                new int[][]{{2, 5}, {4, 3}}),
                8);
        System.out.println();
        Assertions.assertEquals(solution(12,
                new int[][]{{7, 8}, {4, 6}, {11, 10}},
                new int[][]{{2, 2}, {2, 4}, {3, 3}}),
                12);
    }
}
