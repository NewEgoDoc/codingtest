package coding.test.programmers.Day19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 체육대회 {

    int[] array;
    int[] result;
    int index;
    int n;
    int r;

    int start;
    public int solution(int[][] ability) {
        int answer = 0;
        n = ability.length;
        array = new int[ability.length];
        result = new int[ability[0].length];
        combination();

        return answer;
    }

    private void combination() {
        if(index == r) {
            System.out.print("[");
            for (int i = 0; i < r; i++) {
                if (i == (r - 1)) {
                    System.out.print(result[i]);
                    break;
                }
                System.out.print(result[i] + ", ");
            }
            System.out.println("]");
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
        Assertions.assertEquals(solution(new int[][]{
                {40, 10, 10},{20, 5, 0},{30, 30, 30},{70, 0, 70},{100, 100, 100}
        }),210);
        Assertions.assertEquals(solution(new int[][]{
                {20, 30}, {30, 20}, {20, 30}
        }),60);
    }
}
