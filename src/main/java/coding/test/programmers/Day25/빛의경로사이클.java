package coding.test.programmers.Day25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 빛의경로사이클 {
    int R,C;
    int[] dr = {-1,0,1,0};
    int[] dc = {0,-1,0,1};
    boolean[][][] check;

    public int[] solution(String[] grid){
        ArrayList<Integer> answer = new ArrayList<>();

        R = grid.length;
        C = grid[0].length();

        check = new boolean[R][C][4];
        for(int i = 0; i<R;i++){
            for(int j = 0;j<C;j++){
                for(int d = 0;d<4;d++){
                    if(!check[i][j][d]){
                        answer.add(light(grid,i,j,d));
                    }
                }
            }
        }

        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    public int light(String[] grid, int r, int c, int d){
        int cnt = 0;

        while(true){
            if(check[r][c][d]) break;

            cnt++;
            check[r][c][d] = true;

            if(grid[r].charAt(c) == 'L')
                d = d == 0 ? 3 : d-1;
            else if(grid[r].charAt(c) == 'R')
                d = d == 3 ? 0 : d+1;

            r = (r + dr[d] +R) %R;
            c = (c + dc[d] + C) % C;
        }

        //System.out.println(cnt);
        return cnt;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution(new String[]{"SL","LR"}),new int[]{16});
        Assertions.assertArrayEquals(solution(new String[]{"S"}),new int[]{1,1,1,1});
        Assertions.assertArrayEquals(solution(new String[]{"R","R"}),new int[]{4,4});
    }
}
