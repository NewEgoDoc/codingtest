package coding.test.commulearning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 자전거공장 {
    /**
     *
     * 최소의 전기요금을 요구했으니 전기요금이 싼 구간에서 최대한 많이 만들어 놓을수록 유리하다는 것을 알 수 있습니다.
     * 일단 낮은 구간에서부터 매월 최대한 만들수 있는 만큼 만들어 둡니다.
     * 자전거를 납품할 때가 되면 미리 만들어 놓은 자전거로 납품을 합니다.
     * 낮은 구간에서 최대한 만들만큼 만들었는데도 주문량을 모두 소진하지 못했다면, 다음 가격 구간에서 최대한 만들 수 있는 만큼씩 계속 만들어 최종으로 주문량을 모두 소진할 때 까지 반복하면 됩니다.
     * 문제의 지문에서 order 배열이 정렬되어 있지 않음에 주의하세요 라고 알려줬습니다. 주문된 월이 순서도 없지만 중복될 수도 있다는 것에 주의해야 합니다.
     *
    * */
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

        for (int i = 0; i < cost.length - 1; i++) {
            if (need == 0 || made >= need) break;

            int price = cost[i][1];
            int limit = cost[i + 1][0] - cost[i][0];
            int rest = 0;

            for (int j = 0; j < maxMonth; j++) {
                if (need == 0 || made >= need) break;

                int making = Math.min(limit, need - made);

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
