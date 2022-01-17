package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv2방문길이 {

    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    int[][] coordinates;

    public int solution(String dirs) {
        coordinates = new int[12][12];


        return 0;
    }


    @Test
    public void test(){
        Assertions.assertEquals(solution("ULURRDLLU"),7);
        Assertions.assertEquals(solution("LULLLLLLU"),7);
        Assertions.assertEquals(solution("LLLLLLLUUUUUUUUUUURRRRRRRRRRRRRRRRRRRRRRRR"),18);
    }
}
