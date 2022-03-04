package coding.test.summary.permutation;

import org.junit.Test;

import java.util.Arrays;

public class Permutation {

    int[] bucket;

    public int solution(int n, int m, int[] arr) {
        bucket = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.sort(arr);
        int sum = 0;
        dfs(0, arr, visited, sum, n, m);
        return 0;
    }

    private void dfs(int index, int[] arr, boolean[] visited, int sum, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(bucket[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bucket[index] = arr[i];
                dfs(index + 1, arr, visited, sum, n, m);
                visited[i] = false;
            }
        }
    }
    @Test
    public void test(){
        solution(3,1,new int[]{4,4,2});
        System.out.println();
        //solution(4,2,new int[]{1,2,3});
        System.out.println();
        //solution(4,4,new int[]{1,2,3});
    }
}
