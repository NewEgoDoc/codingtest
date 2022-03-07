package coding.test.summary.combination;

import org.junit.Test;

import java.util.Arrays;

public class Combination {
    public int solution(int n, int m, int[] arr) {
        boolean[] visited = new boolean[n];
        Arrays.sort(arr);
        dfs(0,arr,visited,0,n,m);
        return 0;
    }

    private int dfs(int start, int[] arr, boolean[] visited, int sum, int n, int m) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                if(visited[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
            return sum;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            dfs(i + 1, arr, visited, sum+arr[i], n, m-1);
            visited[i] = false;
        }

        return 0;
    }

    @Test
    public void test(){
        solution(4,2,new int[]{1,2,3,4});
        System.out.println();
        //solution(4,2,new int[]{1,2,3});
        System.out.println();
        //solution(4,4,new int[]{1,2,3});
    }
}
