package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Lv2기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            if((100 - progresses[i])%speeds[i] != 0){
                days[i] = (100 - progresses[i])/speeds[i] + 1;
            } else {
                days[i] = (100 - progresses[i])/speeds[i];
            }
        }
        List<Integer> list = new ArrayList<>();

        int standard = 0;
        int count = 0;
        for (int i = 0; i < days.length; i++) {

            if(i == 0) {
                standard = days[i];
                count = 1;
                continue;
            }

            if(days[i] > standard){
                list.add(count);
                standard = days[i];
                count = 1;
            } else {
                count++;
            }

            if(i == days.length-1){
                list.add(count);
                break;
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
            System.out.print(" "+ list.get(i) +" ");
        }
        System.out.println();
        return answer;
    }
    @Test
    public void test(){
        assertArrayEquals(solution(new int[]{93, 30, 55},new int[]{1, 30, 5}),new int[]{2, 1});
        assertArrayEquals(solution(new int[]{95, 90, 99, 99, 80, 99},new int[]{1, 1, 1, 1, 1, 1}),new int[]{1, 3, 2});
        assertArrayEquals(solution(new int[]{95, 90, 89, 99, 80, 99},new int[]{1, 1, 1, 1, 1, 1}),new int[]{1, 1, 2, 2});
        assertArrayEquals(solution(new int[]{95, 89, 99, 80, 99},new int[]{1, 2, 3, 4, 5}),new int[]{1, 4});
        assertArrayEquals(solution(new int[]{0, 0, 0, 0},new int[]{100, 50, 34, 25}),new int[]{1, 1, 1, 1});
        assertArrayEquals(solution(new int[]{1, 99},new int[]{99, 1}),new int[]{2});
        assertArrayEquals(solution(new int[]{99, 99, 99, 99, 99},new int[]{99, 99, 99, 99, 99}),new int[]{5});
        assertArrayEquals(solution(new int[]{20, 99, 93, 30, 55, 10},new int[]{5, 10, 1, 1, 30, 5}),new int[]{3,3});
    }
}
