package coding.test.programmers.Lv3;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lv3정수삼각형 {
    int max = 0;
    public int solution(int[][] triangle) {
        max = 0;

        dfs(triangle,0,0,0);

        System.out.println("max = " + max);
        return max;
    }

    private void dfs(int[][] triangle, int depth, int index, int sum) {
        if(depth == triangle.length-1){
            if(max < sum) {
                max = sum;
            }
            return;
        }
        System.out.println("sum = " + sum);


        if(index - 1 >= 0)
            dfs(triangle,depth+1,index-1,sum+triangle[depth][index]);
        dfs(triangle,depth+1,index,sum+triangle[depth][index]);
        dfs(triangle,depth+1,index+1,sum+triangle[depth][index]);
    }

    @Test
    public void test(){
        assertEquals(solution(new int[][]{{7},
                                         {3,8},
                                        {8,1,0},
                                       {2,7,4,4},
                                      {4,5,2,6,5}}),30);
    }
}
