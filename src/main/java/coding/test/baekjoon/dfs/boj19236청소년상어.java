package coding.test.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj19236청소년상어 {

    static int[][][] space;

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        space = new int[4][4][2];
        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                space[i][j] = new int[]{Integer.parseInt(input[2*j]),Integer.parseInt(input[2*j+1])};
            }
        }

//        for(int[][] sp: space){
//            for (int[] s: sp){
//                System.out.print(Arrays.toString(s));
//            }
//            System.out.println();
//        }

        dfs();

    }

    static void dfs(){

    }
}
