package coding.test.summary.important;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 송아지찾기 {

    private static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int input1 = Integer.parseInt(input[0]);
        int input2 = Integer.parseInt(input[1]);

        visited = new boolean[10001];
        int answer = bfs(input1,input2);
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int input1, int input2) {
        int[] move = new int[]{1,-1,5};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(input1);
        visited[input1] = true;
        if(input1 == input2) return 1;
        int level = 1;
        while(!queue.isEmpty()){
            System.out.println("queue = " + queue);
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                int num = queue.poll();
                for (int j = 0; j < 3; j++){
                    int now = num+move[j];
                    if(now > 0 && now <= 10000 && !visited[now]){
                        if(input2 == now){
                            return level;
                        } else {
                            visited[now] = true;
                            queue.offer(now);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
