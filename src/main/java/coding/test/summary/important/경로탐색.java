package coding.test.summary.important;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 경로탐색 {
    public static void main(String[] args) throws Exception{

        int[][] adjacencyMatrix;
        boolean[] visited;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        adjacencyMatrix = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            int num1 = Integer.parseInt(input2[0]);
            int num2 = Integer.parseInt(input2[1]);
            adjacencyMatrix[num1][num2] = 1;
            adjacencyMatrix[num2][num1] = 1;
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(adjacencyMatrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        dfs(adjacencyMatrix,visited,1, 5);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

    private static void dfs(int[][] adjacencyMatrix, boolean[] visited, int index, int goal) {
        if(index == goal){
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) System.out.print(i + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= 5; i++) {
            if(adjacencyMatrix[index][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(adjacencyMatrix, visited, i, goal);
                visited[i] = false;
            }
        }

    }
}
