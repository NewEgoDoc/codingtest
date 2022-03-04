package coding.test.summary.important;

import java.io.*;
import java.util.ArrayList;

public class DFS {
    static int N,M,answer;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        answer = 0;
        graph = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

<<<<<<<<< Temporary merge branch 1
        visited = new boolean[input + 1];
        dfs(1,input);
=========
        initGraph();
        visited = new boolean[N +1];
        makeGraphThruInput(br, M);
        for (int i = 0; i <= N; i++) {
            System.out.println(graph.get(i));
        }

        dfs(1);

        sb.append(answer);
>>>>>>>>> Temporary merge branch 2
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int index) {
        if(index == N){
            answer++;
            System.out.println(answer);
        }

        for (int i: graph.get(index)) {
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
                visited[i] = false;
            }
        }
    }

    private static void initGraph() {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
    }

    private static void makeGraphThruInput(BufferedReader br, int M) throws IOException {
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            graph.get(x).add(y);
            //graph.get(y).add(x);
        }
    }

}
