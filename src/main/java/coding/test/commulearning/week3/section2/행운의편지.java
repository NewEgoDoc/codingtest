package coding.test.commulearning.week3.section2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class 행운의편지 {
    int[] visited;

    public int solution(int n, int c, int k, int[][] contact) {
        int answer = 0;
        visited = new int[n+1];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] connect: contact){
            map.get(connect[0]).add(connect[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= c; i++){
            for(int a: map.get(i)){
                q.add(a);
            }
        }

        while(!q.isEmpty()){
            int member = q.poll();
            visited[member] += 1;
            if(visited[member] == k){
                for(int m: map.get(member)){
                    q.add(m);
                }
            }
        }

        for(int i = c + 1; i <= n; i++){
            if(visited[i] == 0) answer++;
        }

        return answer;
    }
}
