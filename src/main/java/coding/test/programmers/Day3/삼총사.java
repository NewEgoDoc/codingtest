package coding.test.programmers.Day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 삼총사 {
    int n;
    int r = 3;
    int[] array;
    int index;
    int start;
    int[] result;
    int count;
    public int solution(int[] number) {
        count = 0;//이게 답이 될 것임

        index = 0;
        start = 0;
        n = number.length;
        array = number;
        result = new int[r];
        combination();


        return count;
    }

    //n C r
    private void combination() {
        if(index == r){
            int sum = 0;
            for (int n: result) {
                sum += n;
            }
            if(sum == 0) count++;
            return;
        }

        for (int i = start; i < n; i++) {
            result[index] = array[i];
            start = i + 1;
            index++;
            combination();
            index--;
        }
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{-2, 3, 0, 2, -5}),2);
        Assertions.assertEquals(solution(new int[]{-3, -2, -1, 0, 1, 2, 3}),5);
        Assertions.assertEquals(solution(new int[]{-1, 1, -1, 1}),0);
    }

}
