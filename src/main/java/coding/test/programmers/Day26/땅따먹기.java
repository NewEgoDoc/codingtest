package coding.test.programmers.Day26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class 땅따먹기 {

    int[][] map;

    int max;

    int solution(int[][] land) {
        int answer = 0;

        for(int i = 1; i < land.length; i++){
            land[i][0] += Math.max(
                    Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);

            land[i][1] += Math.max(
                    Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);

            land[i][2] += Math.max(
                    Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][3]);

            land[i][3] += Math.max(
                    Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);

        }

        for(int num: land[land.length -1]){
            answer = Math.max(num, answer);
        }

        return answer;
    }
    int wrongSolution(int[][] land) {
        map = land;
        max = 0;
        bfs();
        return max;
    }

    void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{-1,0,-1});//row number, sum, previous col num

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int nowRowNum = poll[0] + 1;
            int sum = poll[1];
            int index = poll[2];
            System.out.println(Arrays.toString(poll));
            if(nowRowNum == map.length){
                if(max < sum) max = sum;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                if(index == i){
                    continue;
                }
                q.add(new int[]{nowRowNum, sum + map[nowRowNum][i],i});
            }
        }
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}),16);
    }
}
