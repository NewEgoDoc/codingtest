package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Lv2방문길이 {
    public int solution(String dirs) {
        HashSet<String> hs = new HashSet<>();
        int nowX = 0;
        int nowY = 0;

        StringBuilder sb = null;

        for (int i = 0; i < dirs.length(); i++) {
            int nextX = nowX;
            int nextY = nowY;
            sb = new StringBuilder();

            if(dirs.charAt(i) == 'U'){
                nextY++;
                sb.append(nowX);
                sb.append(nowY);
                sb.append(nextX);
                sb.append(nextY);
            }

            if(dirs.charAt(i) == 'D'){
                nextY--;
                sb.append(nextX);
                sb.append(nextY);
                sb.append(nowX);
                sb.append(nowY);
            }

            if(dirs.charAt(i) == 'R'){
                nextX++;
                sb.append(nowX);
                sb.append(nowY);
                sb.append(nextX);
                sb.append(nextY);
            }

            if(dirs.charAt(i) == 'L'){
                nextX--;
                sb.append(nextX);
                sb.append(nextY);
                sb.append(nowX);
                sb.append(nowY);
            }

            if(nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5){
                continue;
            }

            hs.add(sb.toString());
            nowX = nextX;
            nowY = nextY;
        }

        return hs.size();
    }



    @Test
    public void test(){
        Assertions.assertEquals(solution("ULURRDLLU"),7);
        Assertions.assertEquals(solution("LULLLLLLU"),7);
    }
}
