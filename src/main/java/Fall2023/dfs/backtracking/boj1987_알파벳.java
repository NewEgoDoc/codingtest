package Fall2023.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1987_알파벳 {
    static int R;
    static int C;

    static char[][] board;

    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};

    static boolean[][] visited;
    static int max;
    static List<Character> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);
        board = new char[R][C];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < R; i++) {
            char[] inputChar = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = inputChar[j];
                set.add(board[i][j]);
            }
        }
        visited = new boolean[R][C];
        max = 0;
        list = new ArrayList<>();
        list.add(board[0][0]);
        dfs(0, 0, 0);
        System.out.println(max);
    }

    static void dfs(int sum, int x, int y){
        max = Math.max(max, list.size());

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(visited[nx][ny]) continue;
            if(list.contains(board[nx][ny])) continue;

            visited[nx][ny] = true;
            list.add(board[nx][ny]);
            dfs(sum + 1, nx, ny);
            list.remove(list.size()-1);
            visited[nx][ny] = false;
        }
    }
}
