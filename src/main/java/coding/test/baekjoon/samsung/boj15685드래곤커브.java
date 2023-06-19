package coding.test.baekjoon.samsung;

import java.io.*;
import java.util.*;

public class boj15685드래곤커브 {

    static boolean[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new boolean[101][101];
        answer = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            dragonCurve(
                    Integer.parseInt(input[0]),
                    Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]),
                    Integer.parseInt(input[3])
            );
        }

        checkSquare();

        System.out.println(answer);
        br.close();
    }

    private static void checkSquare() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }
    }

    public static void dragonCurve(int x, int y, int d, int g) {

    }
}
