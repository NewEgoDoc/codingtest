package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Lv2삼각달팽이 {
    int m;
    int[][] map;
    int num;

    int[] dx = {1,0,-1};
    int[] dy = {0,1,-1};
    int value;
    public int[] solution(int n) {
        map = new int[n][n];
        value = 1;
        int direction = 0;
        int x = 0;
        int y = 0;
        while(true){
            map[x][y] = value++;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != 0) {
                direction = (direction + 1) % 3;
                nx = x + dx[direction];
                ny = y + dy[direction];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != 0) {
                    break;
                }
            }
            x = nx;
            y = ny;

        }
        int[] answer = new int[value -1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = map[i][j];
            }
        }
        return answer;
    }

    public int[] solution2(int n) {
        m = n;
        map = new int[n][n];
        num = 1;

        for (int i = 0; i < n; i++) {
            map[i][0] = num;
            if(i == n - 1){
                for (int j = 0; j < n; j++) {
                    map[i][j] = num++;
                }
            } else {
                num++;
            }
        }

        //n-1, n-1 에서 대각선 -> 아래로 -> 대각선 -> 아래로
        goUpperLeft(n-1, n-1);

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        int[] answer = new int[num - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = map[i][j];
            }
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }


    private void goUpperLeft(int x, int y) {
        for (int i = 1; i < m; i++) {

            if(map[x-i][y-i] > 0) {
                int downX = x-i+2;
                int downY = y-i+1;

                if(map[downX][downY] > 0) return;
                else goDown(downX-1, downY);
                break;
            }

            map[x-i][y-i] = num++;
        }
    }

    private void goDown(int x, int y){
        for (int i = 1; i < m; i++) {
            if(map[x+i][y] > 0) {
                int rightX = x + i -1;
                int rightY = y+1;

                if(map[rightX][rightY] > 0) return;
                else goRight(rightX,(rightY -1));
                break;
            }

            map[x+i][y] = num++;
        }
    }

    private void goRight(int x, int y){

        for (int i = 1; i < m; i++) {
            if(map[x][y+i] > 0) {
                int upperLeftX = x - 1;
                int upperLeftY = y + i - 2;

                if(map[upperLeftX][upperLeftY] > 0) return;
                else goUpperLeft(upperLeftX+1, upperLeftY+1);
                break;
            }

            map[x][y+i] = num++;
        }
    }

    @Test
    void test(){
//        Assertions.assertArrayEquals(solution(1), new int[]{1});
        Assertions.assertArrayEquals(solution(2), new int[]{1,2,3});
        Assertions.assertArrayEquals(solution(3), new int[]{1,2,6,3,4,5});
        Assertions.assertArrayEquals(solution(4), new int[]{1,2,9,3,10,8,4,5,6,7});
        Assertions.assertArrayEquals(solution(5), new int[]{1,2,12,3,13,11,4,14,15,10,5,6,7,8,9});
        Assertions.assertArrayEquals(solution(6), new int[]{1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11});
    }

}
