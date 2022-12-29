package coding.test.programmers.Day28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

public class 마법의엘리베이터 {

//    int[] visited;
//    int[] dy;
//    int n;
//    public int solution(int storey) {
//        int[] xy = getRoundMax(storey);
//        System.out.println("Arrays.toString(xy) = " + Arrays.toString(xy));
//        n = xy[0]*(int)Math.pow(10,xy[1]);
//
//        dy = new int[(xy[1] + 1) * 2];
//        for (int i = 0; i < (xy[1] + 1)*2; i+=2) {
//            dy[i] = (int)Math.pow(10,i/2);
//            dy[i + 1] = dy[i] * -1;
//        }
//        System.out.println("Arrays.toString(dy) = " + Arrays.toString(dy));
//
//        visited = new int[n + 1];
//
//        for (int i = 0; i < n + 1; i++) {
//            visited[i] = Integer.MAX_VALUE;
//        }
//        bfs(storey);
//
//        System.out.println(Arrays.toString(visited));
//        return visited[0] ;
//    }
//
//    private int[] getRoundMax(int storey) {
//        int pow = 0;
//        while(storey > 10){
//            storey /= 10;
//            pow += 1;
//        }
//        storey += 1;
//        return new int[]{storey, pow};
//    }
//
//    void bfs(int start){
//        Queue<Integer> q = new LinkedList<>();
//        q.add(start);
//        visited[start] = 0;
//
//        while(!q.isEmpty()){
//            System.out.println("q = " + q);
//            int nowFloor = q.poll();
//            for (int i = 0; i < dy.length; i++) {
//                int next = nowFloor + dy[i];
//                if(next < 0 || next > n) continue;
//                if(visited[next] <= visited[nowFloor] + 1) continue;
//
//                q.add(next);
//                visited[next] = visited[nowFloor] + 1;
//            }
//        }
//
//    }

    int isUp;
    public int solution(int storey) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        isUp = 0;
        while(storey != 0){
            q.add(storey % 10);
            storey /= 10;
        }

        while (!q.isEmpty()){
            if(q.peek() == 0) {
                q.poll();
                continue;
            }

            int num = q.poll() + isUp;
            if(num <= 5) {
                answer += num;
                isUp = 0;
            } else {
                answer += (10 - num);
                isUp = 1;
            }

            System.out.println("answer = " + answer);
            if(q.size() == 1 && q.peek() == 9 && isUp == 1){
                q.poll();
                answer += 1;
            }

        }

        return answer;
    }

    int downToZero(int n)
    {

        // Base case
        if (n <= 3)
            return n;

        // Allocate memory for storing
        // intermediate results
        int []dp = new int[n + 1];
        for(int i = 0; i < n + 1; i++)
            dp[i] = -1;

        // Store base values
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        // Stores square root
        // of each number
        int sqr;
        for(int i = 4; i <= n; i++)
        {

            // Compute square root
            sqr = (int)Math.sqrt(i);

            int best = Integer.MAX_VALUE;

            // Use rule 1 to find optimized
            // answer
            while (sqr > 1)
            {

                // Check if it perfectly divides n
                if (i % sqr == 0)
                {
                    best = Math.min(best, 1 + dp[sqr]);
                }
                sqr--;
            }

            // Use of rule 2 to find
            // the optimized answer
            best = Math.min(best, 1 + dp[i - 1]);

            // Store computed value
            dp[i] = best;
        }

        // Return answer
        return dp[n];
    }

    @Test
    void test(){
        Assertions.assertEquals(downToZero(16),6);
        Assertions.assertEquals(solution(2554),16);
        Assertions.assertEquals(solution(2556),15);
        Assertions.assertEquals(solution(99),2);
        Assertions.assertEquals(solution(2918),8);
        Assertions.assertEquals(solution(9999),2);
        Assertions.assertEquals(solution(1),1);
        Assertions.assertEquals(solution(38),6);
        Assertions.assertEquals(solution(44),8);
        Assertions.assertEquals(solution(155),11);
        Assertions.assertEquals(solution(911),3);
    }
}
