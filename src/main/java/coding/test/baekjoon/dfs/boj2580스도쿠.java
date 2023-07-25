package coding.test.baekjoon.dfs;

import java.io.*;
import java.util.*;

public class boj2580스도쿠 {

    static List<int[]> emptyPoints;
    static int[][] plate;

    static boolean isStop;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        plate = new int[9][9];
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

        dfs(0);
    }

    private static void printPlate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(plate[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int index){
        if(isStop) return;

        if(index == emptyPoints.size()){
            isStop = true;
            printPlate();

            return;
        }

        int[] now = emptyPoints.get(index);
        for (int i = 1; i <= 9; i++) {
            if(isImpossible(now, i)) continue;
            plate[now[0]][now[1]] = i;
            dfs(index + 1);
            plate[now[0]][now[1]] = 0;
        }

    }

    private static boolean isImpossible(int[] point, int i) {
        if(isInHorizontal(point[0], i)) return true;
        if(isInVertical(point[1], i)) return true;
        return isInSquare(point, i);
    }

    private static boolean isInSquare(int[] point, int value) {
        int r = 3*(point[0] / 3);
        int c = 3*(point[1] / 3);

        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                if(plate[i][j] == value) return true;
            }
        }
        return false;
    }

    private static boolean isInVertical(int column, int value) {
        for (int i = 0; i < 9; i++) {
            if(plate[i][column] == value) return true;
        }
        return false;
    }

    private static boolean isInHorizontal(int row, int value) {
        for (int i = 0; i < 9; i++) {
            if(plate[row][i] == value) return true;
        }
        return false;
    }
}
