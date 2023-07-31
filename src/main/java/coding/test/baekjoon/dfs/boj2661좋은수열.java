package coding.test.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2661좋은수열 {
    static int N;
    static boolean isStop;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs("");


    }

    private static void dfs(String str){
        if(isStop){
            return;
        }
        if(str.length() == N){
            isStop = true;
            System.out.println(str);
            return;
        }

        for (int i = 1; i < 4; i++) {
            if(check(str+i)){
                dfs(str+i);
            }
        }
    }

    private static boolean check(String s) {
        int length = s.length();

        for (int i = 1; i <= length/2; i++) {
            String front = s.substring(s.length() - i - i, s.length() - i);
            String back = s.substring(s.length() - i, s.length());
            if(front.equals(back)) return false;
        }
        return true;
    }
}
