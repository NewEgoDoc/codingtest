package coding.test.programmers.코테;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class 프로그래밍3 {
    public int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = new int[2];
        int sum[] = new int[n + 1];
        sum[1] = passenger[0];
        int now = 1;
        Arrays.sort(train, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        for (int i = 0; i < train.length; i++) {
            if(train[i][0] != now){
                now++;
            }
            sum[train[i][1]] = Math.max(sum[now] + passenger[train[i][1] - 1],sum[train[i][1]]);
        }

        int max = 0;
        for (int i = 0; i < sum.length; i++) {
            System.out.print(sum[i] + " ");
            if(max < sum[i]) max = sum[i];
        }
        System.out.println();

        for (int i = sum.length - 1; i > 0; i--) {
            if(max == sum[i]) {
                answer[0] = i;
                answer[1] = sum[i];
                break;
            }
        }
        return answer;
    }

    public void dfs(int i, int[][] train, boolean[] visited,int[] passenger,int[] sum) {
        System.out.println(" " + i);

        for (int j = 0; j < train.length; j++) {
            if(train[j][0] == i){
                sum[train[i][1]] = Math.max(sum[train[i][1]],sum[i] + passenger[train[i][1] -1]);
                dfs(train[i][1], train, visited,passenger,sum);
            }
        }
    }


    @Test
    public void test(){
        Assertions.assertArrayEquals(solution(
                6,
                new int[]{1,1,1,1,1,1},
                new int[][]{{1,2},{1,3},{1,4},{3,5},{3,6}}
        ),new int[]{6,3});

        Assertions.assertArrayEquals(solution(
                4,
                new int[]{2,1,2,2},
                new int[][]{{1,2},{1,3},{2,4}}
        ),new int[]{4,5});

        Assertions.assertArrayEquals(solution(
                5,
                new int[]{1,1,2,3,4},
                new int[][]{{1,2},{1,3},{1,4},{1,5}}
        ),new int[]{5,5});
    }
}
