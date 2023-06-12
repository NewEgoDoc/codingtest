package coding.test.baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14888연산자끼워넣기 {
    
    static int n;
    static int[] a;
    static int[] operator;
    static int min;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(array[i]);
        }
        String[] array2 = br.readLine().split(" ");
        operator = new int[4];
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(array2[i]);
        }

        min = Integer.MAX_VALUE;
        max = -Integer.MAX_VALUE;

        dfs(1, a[0]);

        System.out.println(max);
        System.out.println(min);

    }
    
    static void dfs(int index, int sum){
        if(index == n){
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operator[i] > 0){

                operator[i]--;

                if(i == 0) dfs(index + 1, sum + a[index]);
                if(i == 1) dfs(index + 1, sum - a[index]);
                if(i == 2) dfs(index + 1, sum * a[index]);
                if(i == 3) dfs(index + 1, sum / a[index]);

                operator[i]++;
            }
        }
    }
}
