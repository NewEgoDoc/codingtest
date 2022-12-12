package coding.test.programmers.Day19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
public class 운영체제 {
    public long[] solution(int[][] program) {
        long[] answer = new long[11];
        //시작시간으로 정렬
        Arrays.sort(program,(o1,o2)->(o1[1] - o2[1]));

        //우선순위 큐 점수순으로 같다면 시작시간순으로
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int nowTime = 0;
        int numberOfPrograms = program.length;
        int index = 0;
        int endTime = 0;

        //지금은 0초
        while(numberOfPrograms > 0){

            while(index < program.length){
                int startTime = program[index][1];

                //지금시간이 시작시간보다 크거나 같다면 큐에 추가
                if(startTime <= nowTime){
                    pq.add(program[index]);
                    index++;

                    //다음시간으로 넘어가자
                } else {
                    break;
                }
            }

            //큐 순환
            if(!pq.isEmpty() && endTime <= nowTime) {
                int[] poll = pq.poll();

                //프로그램 종료시간
                endTime = nowTime + poll[2];

                //원래 시작했어야하는 시간보다 얼마다 뒤에 시작했는지 추가
                //문제 참고.
                answer[poll[0]] += nowTime - poll[1];

                //해당프로그램 종료
                numberOfPrograms--;
            }

            //현재 시간 증가
            nowTime++;
        }

        answer[0] = endTime;

        return answer;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution(new int[][]{{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}}),
        new long[]{20, 5, 0, 16, 0, 0, 0, 0, 0, 0, 0});
        Assertions.assertArrayEquals(solution(new int[][]{{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}}),
        new long[]{19, 0, 0, 4, 3, 14, 0, 0, 0, 0, 0});
    }
}
