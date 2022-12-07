package coding.test.programmers.Day18;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

public class 실습용로봇 {
    //https://school.programmers.co.kr/learn/courses/15009/lessons/121687

    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    public int[] solution(String command) {
        int[] now = {0, 0, 0};

        for (int i = 0; i < command.length(); i++) {
            char direction = command.charAt(i);
            if(direction == 'G'){
                now[0] += dx[now[2]];
                now[1] += dy[now[2]];
            }
            if(direction == 'B'){
                now[0] -= dx[now[2]];
                now[1] -= dy[now[2]];
            }
            if(direction == 'R'){
                now[2] += 1;
                now[2] %= 4;
            }
            if(direction == 'L'){
                now[2] -= 1;
                if(now[2] < 0) now[2] += 4;
            }

        }
        return new int[]{now[0], now[1]};
    }


    @Test
    public void test(){
        Assertions.assertArrayEquals(solution("GRGLGRG"),new int[]{2,2});
        Assertions.assertArrayEquals(solution("GRGRGRB"),new int[]{2,0});
    }
}
