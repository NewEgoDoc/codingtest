package coding.test.summary.important;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DFS {

    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());

        visited = new boolean[input + 1];
        dfs(0,input);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int index, int last) {
        if(index >= last+1){
            for (int i = 1; i <= last; i++) {
                if(visited[i]) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        visited[index] = true;
        dfs(index+1,last);

        visited[index] = false;
        dfs(index+1,last);
    }
}
