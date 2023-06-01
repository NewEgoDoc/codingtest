package coding.test.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj16236아기상어 {

    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visited;
    static int babySharkLevel;
    static int numberOfFish;
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

        int[] babyShark = findBabyShark();
        babySharkLevel = 2;
        second = 0;
        numberOfFish = 0;
        while(true){
            List<int[]> levelFishes = bfs(new int[]{babyShark[0], babyShark[1]});

            for (int[] fish: levelFishes) {
                System.out.println(Arrays.toString(fish));
            }
            System.out.println();


            if(levelFishes.size() == 0){
                break;
            }

            levelFishes.sort((o1, o2) -> {
                if(o1[2] != o2[2]){
                    return o1[2] - o2[2];
                } else if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            });

            int[] fish = levelFishes.get(0);
            map[babyShark[0]][babyShark[1]] = 0;
            map[fish[0]][fish[1]] = 9;
            babyShark[0] = fish[0];
            babyShark[1] = fish[1];
            second += fish[2];
            numberOfFish += 1;

            System.out.println("second = " + second);

            if(numberOfFish == babySharkLevel){
                babySharkLevel += 1;
                numberOfFish = 0;
            }
        }

        System.out.println(second);
    }

    static int[] findBabyShark(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 9) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0,0};
    }

    static List<int[]> bfs(int[] babySharkPosition){
        System.out.println(Arrays.toString(babySharkPosition));
        visited = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{babySharkPosition[0], babySharkPosition[1], 0});
        visited[babySharkPosition[0]][babySharkPosition[1]] = 1;

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
                    visited[nx][ny] = 1;
                    q.add(new int[]{nx, ny, second + 1});
                } else if(map[nx][ny] < babySharkLevel){
                    visited[nx][ny] = 1;
                    list.add(new int[]{nx, ny, second + 1});
                }
            }
        }
        return list;

    }

    private static boolean isPossible(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= n || ny >= n;
    }
}
