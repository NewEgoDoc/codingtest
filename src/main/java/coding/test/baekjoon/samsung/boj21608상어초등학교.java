package coding.test.baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj21608상어초등학교 {

    static int n;
    static int[][] likeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        likeList = new int[n+1][4];

        for (int i = 0; i < n*n; i++) {
            String[] input = br.readLine().split(" ");
            System.out.println(Arrays.toString(input));
            for (int j = 0; j < 4; j++) {
                likeList[Integer.parseInt(input[0])][j]
                        = Integer.parseInt(input[j+1]);
            }
            System.out.println();
        }

        for(int[] l: likeList){
            System.out.println(Arrays.toString(l));
        }

    }
}
