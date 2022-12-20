package coding.test.programmers.Day22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 최소직사각형 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/86491
    //전략을 이렇게 했습니다 어짜피 한쪽은 제일 크고 한쪽은 제일 작게!
    //제일 큰쪽(width)에서 max값
    //제일 작은쪽(height)에서 max값
    //두개 곱해주면 정답!


    public int solution(int[][] sizes) {
        int maxWidth=0;
        int maxHeight=0;
        for(int i = 0; i < sizes.length; i++){
            int[] now = sizes[i];
            int width = Math.max(now[0], now[1]);
            System.out.println("width = " + width);
            int height = Math.min(now[0], now[1]);
            System.out.println("height = " + height);
            System.out.println();

            maxWidth = Math.max(maxWidth,width);
            maxHeight = Math.max(maxHeight,height);
        }
        return maxWidth*maxHeight;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}), 4000);
        System.out.println();
        Assertions.assertEquals(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}), 120);
        System.out.println();
        Assertions.assertEquals(solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}), 133);
    }
}
