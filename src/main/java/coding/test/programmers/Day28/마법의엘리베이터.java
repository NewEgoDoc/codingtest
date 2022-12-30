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
        while(storey >= 1){
            int now = storey % 10;
            if((now == 5) && ((storey / 10) % 10) >= 5 || now > 5){
                storey += 10 - now;
                answer += 10 - now;
            } else {
                answer += now;
            }
            storey = storey / 10;
        }

        return answer;
    }


    @Test
    void test(){
        Assertions.assertEquals(solution(16),6);
        Assertions.assertEquals(solution(2554),16);
        Assertions.assertEquals(solution(2556),15);
        Assertions.assertEquals(solution(99),2);
        Assertions.assertEquals(solution(2918),8);
        Assertions.assertEquals(solution(9999),2);
        Assertions.assertEquals(solution(1),1);
        Assertions.assertEquals(solution(38),6);
        Assertions.assertEquals(solution(44),8);
        Assertions.assertEquals(solution(155),11);
        Assertions.assertEquals(solution(911),4);
    }
}
