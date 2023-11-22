package Fall2023.dfs.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1062가르침 {
    static int N;
    static int K;

    static String[] words;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        if(K < 5) {
            System.out.println(0);
            return;
        }

        if(K == 26) {
            System.out.println(N);
            return;
        }

        words = new String[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }


    }
    private static void combination(int index, int start){
        if(index == K-5){

        }
        for(int i = start; i < 26; i++) {
            if(!visited[i]){
                visited[i]=true;
                combination(index+1,i+1);
                visited[i]=false;
            }
        }
    }
}
