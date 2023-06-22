package coding.test.baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj15683감시 {

    static int n, m;
    static int[][] office;

    static int numberOfCamera;

    static int[][] cameraPositions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        n = Integer.parseInt(NM[0]);
        m = Integer.parseInt(NM[1]);

        office = new int[8][8];
        numberOfCamera = 0;
        cameraPositions = new int[8][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(input[j]);
                if(office[i][j] > 0 && office[i][j] < 6){
                    cameraPositions[0] = new int[]{i,j};
                    numberOfCamera++;
                }
            }
        }

//        for(int[] o: office){
//            System.out.println(Arrays.toString(o));
//        }
        // 한개의 cctv는 고정(dfs)
        // 같은 맵들을 복사해주고
        // cctv의 종류마다 벽이나 사무실의 끝에 도달까지 cctv 감시(단, 종류들은 뱡향마다 바라보는곳이 바뀜) - bfs로 표시
        


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
