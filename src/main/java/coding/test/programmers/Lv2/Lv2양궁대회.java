package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Lv2양궁대회 {

    int r;
    int index = 0;
    int start = 0;
    int[] result;
    int[] ryan;
    int[] apeach;

    int apeachScore;
    int ryanScore;
    int max;
    int[] answer;
    public int[] solution(int n, int[] info) {
        max = -1;
        answer = new int[11];
        apeach = info;
        result = new int[n];
        r = n;

        dfs();

        if(max < 0){
            return new int[]{-1};
        }

        System.out.println(Arrays.toString(ryan));
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    void dfs(){
        if(index == r){
            ryan = new int[11];
            apeachScore = 0;
            ryanScore = 0;

            System.out.println(Arrays.toString(result));
            for(int choice: result){
                ryan[10 - choice]++;
            }

            calculateScores();

            if(max < (ryanScore - apeachScore)){
                max = (ryanScore - apeachScore);
                answer = ryan;
            }

            return;
        }

        for (int i = start; i < 11; i++) {
            result[index] = i;
            index++;
            dfs();
            index--;
        }
    }

    private void calculateScores() {
        for (int i = 0; i < 11; i++) {
            if(apeach[i] == ryan[i]){
                if(apeach[i] != 0){
                    apeachScore += (10 - i);
                }
            } else if(apeach[i] > ryan[i]){
                apeachScore += (10 - i);
            } else {
                ryanScore += (10 - i);
            }
        }
    }

    @Test
    void test(){
//        Assertions.assertArrayEquals(solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0}), new int[]{0,2,2,0,1,0,0,0,0,0,0});
        Assertions.assertArrayEquals(solution(1, new int[]{1,0,0,0,0,0,0,0,0,0,0}), new int[]{-1});
//        Assertions.assertArrayEquals(solution(9, new int[]{0,0,1,2,0,1,1,1,1,1,1}), new int[]{1,1,2,0,1,2,2,0,0,0,0});
//        Assertions.assertArrayEquals(solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3}), new int[]{1,1,1,1,1,1,1,1,0,0,2});
    }
}
