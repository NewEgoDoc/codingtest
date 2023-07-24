package coding.test.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj2580스도쿠 {

    static List<int[]> emptyPoints;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] plate = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                plate[i][j] = Integer.parseInt(input[j]);
            }
        }

        emptyPoints = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(plate[i][j] == 0){
                    emptyPoints.add(new int[]{i, j});
                }
            }
        }

        dfs(0,0);

    }

    private static void dfs(int i, int count){
        if(count == emptyPoints.size()){

        }

        for (int i = 0; i < emptyPoints.size(); i++) {
            if(checkHorizontal())
        }
    }
}
