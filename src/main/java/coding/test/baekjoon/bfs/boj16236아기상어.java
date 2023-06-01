package coding.test.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj16236아기상어 {

    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visited = new int[n][n];

    static int babySharkLevel;

    static int fishEaten;
    static int second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] values = br.readLine().split(" ");
            for (int j = 0; j < values.length; j++) {
                map[i][j] = Integer.parseInt(values[j]);
            }
        }
        babySharkLevel = 2;
        int[] babyShark = findBabyShark();



        while (true) {
            List<int[]> fishes = bfs(babyShark);
            if (fishes.isEmpty()) {
                break;
            }

            fishes.sort((o1, o2) -> {
                if (o1[2] != o2[2]) {
                    return Integer.compare(o1[2], o2[2]);
                } else if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            });

        }



    }

    static int[] findBabyShark(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 9) return new int[]{i, j};
            }
        }
        return null;
    }

    static List<int[]> bfs(int[] babyShark){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{babyShark[0], babyShark[1], 2, 0});
        visited[babyShark[0]][babyShark[1]] = 1;

        List<int[]> list = new ArrayList<>();
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int second = poll[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isPossible(nx, ny) || visited[nx][ny] == 1) continue;

                if(map[nx][ny] == 0 || map[nx][ny] == babySharkLevel){
                    q.add(new int[]{nx, ny, second + 1});
                    continue;
                }
                if(map[nx][ny] < babySharkLevel){
                    list.add(new int[]{nx,ny, second+ 1});
                }

            }

        }
        return list;

    }

    private static boolean isPossible(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= n || ny >= n;
    }
}
