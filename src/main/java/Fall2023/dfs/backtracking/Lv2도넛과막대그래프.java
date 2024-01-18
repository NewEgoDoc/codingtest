package Fall2023.dfs.backtracking;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv2도넛과막대그래프 {

    int[] in;
    int[] out;
    public int[] solution(int[][] edges) {
        in = new int[1000001];
        out = new int[1000001];

        int max = 0;
        for(int[] edge: edges){
            in[edge[1]]++;
            out[edge[0]]++;

            max = Math.max(max, Math.max(edge[0], edge[1]));
        }
        int[] answer = new int[4];
        for (int i = 1; i <= max; i++) {
            if(isCreatorNode(i)){
               answer[0] = i;
               continue;
            }

            if(isBarShapedGraph(i)){
                answer[2]++;
                continue;
            }

            if(is8ShapedGraph(i)){
                answer[3]++;
            }
        }
        answer[1] = out[answer[0]] - (answer[2] + answer[3]);
        return answer;
    }

    private boolean isCreatorNode(int node) {
        return in[node] == 0 && out[node] >= 2;
    }

    private boolean isBarShapedGraph(int node) {
        return out[node] == 0;
    }
    private  boolean is8ShapedGraph(int node) {
        return in[node] >= 2 && out[node] == 2;
    }


    @Test
    public void test(){
//        Assertions.assertArrayEquals(solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}}), new int[]{2, 1, 1, 0});
        Assertions.assertArrayEquals(solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}}), new int[]{4, 0, 1, 2});
    }
}
