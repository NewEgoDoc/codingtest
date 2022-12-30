package coding.test.programmers.Day28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 피로도 {
    int n;
    boolean[] visited;
    int index;
    int answer;
    int[] result;
    int[][] map;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        answer = 0;
        Arrays.sort(dungeons, (o1, o2)->{
            return o1[0] - o2[0];
        });

        map = dungeons;

        for(int i = n; i > 0; i--){
            if(answer > 0) break;
            visited = new boolean[n];
            index = 0;
            result = new int[i];
            permutation(i,k);
        }

        return answer;
    }

    private void permutation(int r, int k){
        if(index == r){
            System.out.println(r + ":" + Arrays.toString(result));
            for (int i = 0; i < r; i++) {
                if(map[result[i]][0] > k) return;
                k -= map[result[i]][1];
            }
            answer = r;
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                result[index] = i;
                index++;
                permutation(r, k);
                index--;
                visited[i] = false;
            }
        }
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(80, new int[][]{{80,20},{50,40},{30,10}}),3);
    }
}
