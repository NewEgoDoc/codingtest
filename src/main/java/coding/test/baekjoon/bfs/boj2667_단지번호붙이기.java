package coding.test.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class boj2667_단지번호붙이기 {
    static int[][] map;
    static int n;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int count;
    static int num;
    static PriorityQueue<Integer> pq;
    static void solution(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1) {
                    count++;
                    num = 1;
                    dfs(i,j);
                    pq.add(num);
                }
            }
        }
    }

    static void dfs(int x, int y){
        map[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isImpossibleRange(nx, ny)) continue;
            if(map[nx][ny] == 0) continue;

            num+=1;
            dfs(nx, ny);
        }
    }


    private static boolean isImpossibleRange(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= n || ny >= n;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        pq = new PriorityQueue<>();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        count = 0;
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        //문제풀이 적용
        solution();

        System.out.println(pq.size());
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
}
