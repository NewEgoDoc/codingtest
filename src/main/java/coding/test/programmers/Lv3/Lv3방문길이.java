package coding.test.programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lv3방문길이 {
    public int solution(String dirs){
        Set<String> set = new HashSet<>();

        int x = 5;
        int y = 5;
        int nextX, nextY;

        StringBuilder sb = null;

        for (int i = 0; i < dirs.length(); i++) {
            nextX = x;
            nextY = y;
            char direction = dirs.charAt(i);

            sb = new StringBuilder();

            if(direction == 'U'){
                nextY++;
                sb.append("(");
                sb.append(x);
                sb.append(",");
                sb.append(y);
                sb.append(")");
                sb.append("(");
                sb.append(nextX);
                sb.append(",");
                sb.append(nextY);
                sb.append(")");
            }

            if(direction == 'D'){
                nextY--;
                sb.append("(");
                sb.append(nextX);
                sb.append(",");
                sb.append(nextY);
                sb.append(")");
                sb.append("(");
                sb.append(x);
                sb.append(",");
                sb.append(y);
                sb.append(")");
            }

            if(direction == 'L'){
                nextX--;
                sb.append("(");
                sb.append(x);
                sb.append(",");
                sb.append(y);
                sb.append(")");
                sb.append("(");
                sb.append(nextX);
                sb.append(",");
                sb.append(nextY);
                sb.append(")");
            }

            if(direction == 'R'){
                nextX++;
                sb.append("(");
                sb.append(nextX);
                sb.append(",");
                sb.append(nextY);
                sb.append(")");
                sb.append("(");
                sb.append(x);
                sb.append(",");
                sb.append(y);
                sb.append(")");
            }

            if(nextX < 0 || nextY < 0 || nextY > 10 || nextX >10) continue;

            set.add(sb.toString());
            x = nextX;
            y = nextY;
            
        }
        System.out.println("set = " + set);
        return set.size();
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution("ULURRDLLU"),7);
        Assertions.assertEquals(solution("LULLLLLLU"),7);
        Assertions.assertEquals(solution("LLLLLLLUUUUUUUUUUURRRRRRRRRRRRRRRRRRRRRRRR"),20);
    }

    /*

    * */
}
