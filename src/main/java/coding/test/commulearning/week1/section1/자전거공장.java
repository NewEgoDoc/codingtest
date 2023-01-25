package coding.test.commulearning.week1.section1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 자전거공장 {
    public int solution(int[][] cost, int[][] order) {
        int answer = 0;

        int maxMonth = 0;
        for (int[] o : order) maxMonth = Math.max(maxMonth, o[0]);

        int[] monthlyOrder = new int[maxMonth];
        int need = 0;
        int made = 0;
        for (int[] o : order) {
            // order 배열이 정렬되어 있지 않음에 주의하세요.
            monthlyOrder[o[0] - 1] += o[1]; // 월을 index로 사용하기 위해 -1을 해줍니다
            need += o[1];
        }
        System.out.println("maxMonth = " + maxMonth);
        System.out.println(Arrays.toString(monthlyOrder));
        System.out.println("need = " + need);
        for (int i = 0; i < cost.length - 1; i++) {
            if (need == 0 || made >= need) break;

            int price = cost[i][1];// 해당 구간의 비용
            int limit = cost[i + 1][0] - cost[i][0]; //해당 구간의 최대 개수

            System.out.println(cost[i][0] + " ~ " + cost[i+1][0] + " : " + cost[i][1]);

            int rest = 0;
            System.out.println(" ============================================================= ");
            //need는 최대 필요한 개수
            for (int j = 0; j < maxMonth; j++) {
                if (need == 0 || made >= need) break;

                int making = Math.min(limit, need - made);
                System.out.println(making);
                answer += making * price;
                made += making;

                need -= monthlyOrder[j];

                if (monthlyOrder[j] == 0) continue; // 납품을 안해도 됩니다.

                int delivery = Math.min(made, monthlyOrder[j]);

                // 납품할때가 되면 만들어놓은 것에서 빼줍니다.
                made -= delivery;
                monthlyOrder[j] -= delivery;
                rest += monthlyOrder[j]; // 납품하고도 남은것은 다음구간에서 만들어야 합니다.
            }
            System.out.println(" ============================================================= ");

            need = rest;
            made = 0;
        }

        // 나머지 것들은 최종구간의 가격을 적용합니다.
        answer += need * cost[cost.length - 1][1];
        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[][]{{0, 10},{50, 20},{100, 30},{200, 40}},new int[][]{{3, 50},{7, 200},{8, 200}}),5000);
        Assertions.assertEquals(solution(new int[][]{{0, 10},{50, 20}},new int[][]{{3, 100},{4, 200}}),4000);
    }
}
