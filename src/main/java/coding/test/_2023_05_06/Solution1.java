package coding.test._2023_05_06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    public int solution (int[] boxes, int m, int k) {
        int answer = 0;
        /* 리스트에 넣고 내림차순으로 정렬 */
        List<Integer> list = boxDescendingList(boxes);

        answer += m;
        /* for문은 일반적으로 list의 크기보다 작게 그리고 주어진 변수(k) 만큼만 돌게  */
        for (int i = 0; i < list.size() && i < k ; i++) {
            /* 상자에 들어가서 번 돈의 크기(earning) */
            int earning = list.get(i) * (answer / 10000);

            /* 만약 번돈의 크기가 100,000 보다 크다면 번돈의 양으로 치지 않기 때문에 continue */
            if(earning > 100000){
                continue;
            }

            /* 조건에 걸리지 않는다면 해당 값을 누적*/
            answer += earning;
        }
        return answer;
    }

    private static List<Integer> boxDescendingList(int[] boxes) {
        List<Integer> list = new ArrayList<>();
        for(int box: boxes){
            list.add(box);
        }
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{1000,800,900},1000000,3),1294200);
        Assertions.assertEquals(solution(new int[]{9000,10000,8520,9500},110000,4),209000);

    }
}
