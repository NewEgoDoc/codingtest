package coding.test.programmers.Day29;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class 교점에별만들기 {

    int start = 0;
    int index = 0;

    int[] result;

    int[][] lines;
    List<long[]> list;
    long minX;
    long minY;
    long maxX;
    long maxY;
    public String[] solution(int[][] line) {
        String[] answer = {};
        lines = line;
        result = new int[2];

        list = new ArrayList<>();
        combination(5);

        for(long[] l: list){
            System.out.println(Arrays.toString(l));
        }

        return answer;
    }

    void combination(int n){
        if(index == 2){
            System.out.println(Arrays.toString(result));

            int[] e1 = lines[result[0]];
            int[] e2 = lines[result[1]];

            int xNumerator = e1[1] * e2[2] - e1[2] * e2[1];
            int xDenominator = e1[0] * e2[1] - e1[1] * e2[0];

            int yNumerator = e1[2] * e2[0] - e1[0] * e2[2];
            int yDenominator = xDenominator;

            if(isEqual(e1, e2)) {
                return;
            }

            if(xDenominator != 0){
                double x = xNumerator / (double) xDenominator;
                double y = yNumerator / (double) yDenominator;

                if(Math.floor(x) == x || Math.floor(y) == y){
                    list.add(new long[]{(long)x, (long)y});
                    minX = Math.min(minX, (long)x);
                    maxX = Math.max(maxX, (long)x);
                    minY = Math.min(minY, (long)y);
                    maxY = Math.max(maxY, (long)y);
                }
            }



            return;
        }
        for (int i = start; i < n; i++) {
            result[index] = i;
            index++;
            start += i + 1;
            combination(n);
            start -= i + 1;
            index--;
        }
    }

    private boolean isEqual(int[] line1, int[] line2) {
        return line1[0] == line2[0] && line1[1] == line2[1] && line1[2] == line2[2];
    }


    @Test
    void test(){
        Assertions.assertEquals(
            solution(new int[][]{
                    {2, -1, 4},
                    {-2, -1, 4},
                    {0, -1, 1},
                    {5, -8, -12},
                    {5, 8, 12}
        }), new String[]{
                "....*....",
                ".........",
                ".........",
                "*.......*",
                ".........",
                ".........",
                ".........",
                ".........",
                "*.......*"}
        );


    }
}
