package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv2방문길이 {

    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    int[][] coordinates;

    public int solution(String dirs) {
        coordinates = new int[10][10];
        markCoordinates(dirs);
        return countTraces();
    }

    private int countTraces() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + coordinates[i][j]);
                if(coordinates[i][j] == 1) count++;
            }
            System.out.println();
        }
        System.out.println();
        return count;
    }

    private void markCoordinates(String dirs) {
        int x = 5,y = 5;
        int direction = 0;
        for(int i = 0; i < dirs.length(); i++){
            if(dirs.charAt(i) == 'U') direction = 2;
            if(dirs.charAt(i) == 'D') direction = 0;
            if(dirs.charAt(i) == 'R') direction = 1;
            if(dirs.charAt(i) == 'L') direction = 3;

            boolean isPossiblePosition = isPossibleXY(x+dx[direction],y+dy[direction]);

            if(isPossiblePosition) {
                x += dx[direction];
                y += dy[direction];
            }
            go(x,y);
        }
    }

    private boolean isPossibleXY(int x, int y) {
        if(x < 0 || x >= 10) return false;
        if(y < 0 || y >= 10) return false;

        return true;
    }

    private void go(int x, int y) {
        coordinates[x][y] = 1;
    }


    @Test
    public void test(){
        Assertions.assertEquals(solution("ULURRDLLU"),7);
        Assertions.assertEquals(solution("LULLLLLLU"),7);
        Assertions.assertEquals(solution("LLLLLLLUUUUUUUUUUUDDDDDDDDDDDDDDDDDDDDDDD"),20);
    }
}
