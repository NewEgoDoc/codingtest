package coding.test.programmers.Day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        int wallet_size;

        for(int i=0; i<sizes.length; i++){
            int tmp;

            for(int j=0; j<2; j++){
                if(sizes[i][0] < sizes[i][1]){
                    tmp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = tmp;
                }
                if(maxWidth < sizes[i][0]){
                    maxWidth = sizes[i][0];
                }
                if(maxHeight < sizes[i][1]){
                    maxHeight = sizes[i][1];
                }
            }
        }
        wallet_size = maxWidth * maxHeight;

        return wallet_size;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[][]{
                {60, 50}, {30, 70}, {60, 30}, {80, 40}
        }), 4000);
        Assertions.assertEquals(solution(new int[][]{
                {10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}
        }), 120);
        Assertions.assertEquals(solution(new int[][]{
                {14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}
        }), 133);
    }
}
