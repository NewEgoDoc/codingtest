package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv2방문길이 {

    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};

    int[][] coordinates;

    public int solution(String dirs) {
        coordinates = new int[12][12];

        settingCoordinates();

        printCoordinates();

        moveDirectionsOnCoordinates(dirs);

        printCoordinates();

        return countTraces();
    }

    private void settingCoordinates() {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                if(i == 0 || j == 0 || i == 11 || j == 11){
                    coordinates[i][j] = -1;
                }
            }
        }
    }

    private void printCoordinates(){
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                System.out.print(coordinates[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int countTraces() {
        int count = 0;
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length -1; j++) {
                int point1 = coordinates[i][j];
                int point2 = coordinates[i][j+1];
                if(point1 == 1 && point2 == 1 &&point2 - point1 == 0){
                    count++;
                }
            }
        }

        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length -1; j++) {
                int point1 = coordinates[j][i];
                int point2 = coordinates[j+1][i];
                if(point1 == 1 && point2 == 1 && point2 - point1 == 0){
                    count++;
                }
            }
        }

        System.out.println("count = " + count);
        return 0;
    }

    private void moveDirectionsOnCoordinates(String dirs) {
        int positionX = 5, positionY = 5;

        coordinates[positionX][positionY] = 1;

        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'L') {
                if(coordinates[(positionX + dx[2])][(positionY+dy[2])] != -1){
                    coordinates[positionX + dx[2]][positionY+dy[2]] = 1;
                    positionX += dx[2];
                    positionY += dy[2];
                }
            }
            if (dirs.charAt(i) == 'R') {
                if(coordinates[positionX + dx[0]][positionY+dy[0]] != -1){
                    coordinates[positionX + dx[0]][positionY+dy[0]] = 1;
                    positionX += dx[0];
                    positionY += dy[0];
                }
            }
            if (dirs.charAt(i) == 'D') {
                if(coordinates[positionX + dx[1]][positionY+dy[1]] != -1){
                    coordinates[positionX + dx[1]][positionY+dy[1]] = 1;
                    positionX += dx[1];
                    positionY += dy[1];
                }
            }
            if (dirs.charAt(i) == 'U') {
                if(coordinates[positionX + dx[3]][positionY+dy[3]] != -1){
                    coordinates[positionX + dx[3]][positionY+dy[3]] = 1;
                    positionX += dx[3];
                    positionY += dy[3];
                }
            }
            //System.out.println(dirs.charAt(i) +":" + positionX + " " + positionY);
        }

    }


    @Test
    public void test(){
        Assertions.assertEquals(solution("ULURRDLLU"),7);
        Assertions.assertEquals(solution("LULLLLLLU"),7);
        Assertions.assertEquals(solution("LLLLLLLUUUUUUUUUUURRRRRRRRRRRRRRRRRRRRRRRR"),18);
    }
}
