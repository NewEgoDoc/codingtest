package coding.test.programmers.Day29;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class 교점에별만들기 {

    int start;
    int index;
    int[][] lines;
    int[] result;
    List<long[]> list;
    long minX;
    long minY;
    long maxX;
    long maxY;
    public String[] solution(int[][] line) {
        start = 0;
        index = 0;
        lines = line;
        result = new int[2];
        list = new ArrayList<>();
        minX = 0;
        minY = 0;
        maxX = 0;
        maxY = 0;
        combination(lines.length);
        System.out.println("minX = " + minX);
        System.out.println("maxX = " + maxX);
        System.out.println("minY = " + minY);
        System.out.println("maxY = " + maxY);
        boolean[][] answerTemp = new boolean[(int) (maxY- minY +1)][(int) (maxX - minX + 1)];
        for(boolean[] at: answerTemp){
            System.out.println(Arrays.toString(at));
        }
        for (long[] ints : list) {
            int x = (int) (ints[0] - minX);
            int y = (int) (ints[1] - maxY);
            System.out.println(Arrays.toString(ints));
            System.out.println("comcom:"+x + "," + y);
            answerTemp[Math.abs(y)][Math.abs(x)] = true;
        }

        String[] answer = new String[answerTemp.length];

        int i = 0;
        for (boolean[] bs : answerTemp) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : bs) {
                if(b){
                    sb.append("*");
                }else{
                    sb.append(".");
                }
            }
            answer[i] = sb.toString();
            i++;
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

                if(Math.floor(x) == x && Math.floor(y) == y){
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
//        Assertions.assertArrayEquals(
//            solution(new int[][]{
//                    {2, -1, 4},
//                    {-2, -1, 4},
//                    {0, -1, 1},
//                    {5, -8, -12},
//                    {5, 8, 12}
//        }), new String[]{
//                "....*....",
//                ".........",
//                ".........",
//                "*.......*",
//                ".........",
//                ".........",
//                ".........",
//                ".........",
//                "*.......*"}
//        );
        Assertions.assertArrayEquals(
                solution(new int[][]{
                        {0, 1, -1}, {1, 0, -1}, {1, 0, 1}
                }), new String[]{
                        "*.*"}
        );
        Assertions.assertArrayEquals(
                solution(new int[][]{
                        {1, -1, 0}, {2, -1, 0}
                }), new String[]{
                        "*"}
        );
        Assertions.assertArrayEquals(
                solution(new int[][]{
                        {1, -1, 0}, {2, -1, 0}, {4, -1, 0}
                }), new String[]{
                        "*"}
        );

    }
}
