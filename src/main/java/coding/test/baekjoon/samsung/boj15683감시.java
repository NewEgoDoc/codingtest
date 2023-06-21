package coding.test.baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj15683감시 {

    static int n;
    static int m;
    static int[][] office;

    static int[] dx = {}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        n = Integer.parseInt(NM[0]);
        m = Integer.parseInt(NM[1]);

        office = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(input[j]);
            }
        }

//        for(int[] o: office){
//            System.out.println(Arrays.toString(o));
//        }
        for (int i = 0; i < 4; i++) {

        }
        int[][] copyOffice = copy(office);
        


    }

    public static int[][] copy(int[][] src) {
        if (src == null) {
            return null;
        }

        int[][] copy = new int[src.length][];
        for (int i = 0; i < src.length; i++) {
            copy[i] = src[i].clone();
        }

        return copy;
    }
}
