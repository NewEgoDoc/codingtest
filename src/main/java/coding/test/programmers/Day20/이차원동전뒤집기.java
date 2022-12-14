package coding.test.programmers.Day20;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 이차원동전뒤집기 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/131703
    int[] rc = new int[2];

    int[] rowChange;
    int[] colChange;

    int numberOfRows;
    int numberOfColumns;

    int index;
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        numberOfRows = beginning.length;
        numberOfColumns = beginning[0].length;
        for (int row = 0; row <= numberOfRows; row++) {
            for (int col = 0; col <= numberOfColumns; col++) {
                System.out.println(row + " , " + col);
                rowChange = new int[row];
                index = 0;
                List<int[]> rowCases = new ArrayList<>();
                combination(rowChange, 1, numberOfRows, row, rowCases);

                colChange = new int[col];
                index = 0;
                List<int[]> colCases = new ArrayList<>();
                combination(colChange, 1, numberOfColumns, col, colCases);


                for(int[] rowCase: rowCases){
                    for (int[] colCase: colCases) {
                        int[][] copyArray = new int[numberOfRows][numberOfColumns];
                        for(int rowNum: rowCase){
                            changRowNum(beginning, copyArray, rowNum);
                        }
                        for(int colNum: colCase){
                            changeColNum(beginning, copyArray, colNum);
                        }

                        if(checkSame(copyArray, target)) {
                            System.out.println("ASDFASDFASDF");
                            return (row+col);
                        }
                    }
                }

            }
        }

        return -1;
    }

    private void changeColNum(int[][] beginning, int[][] copyArray, int colNum) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if(j == (colNum -1)) {
                    copyArray[i][j] = (beginning[i][j] == 0)? 1:0;
                } else {
                    copyArray[i][j] = beginning[i][j];
                }
            }
        }
    }

    private void changRowNum(int[][] beginning, int[][] copyArray, int rowNum) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if(i == (rowNum -1)) {
                    copyArray[i][j] = (beginning[i][j] == 0)? 1:0;
                } else {
                    copyArray[i][j] = beginning[i][j];
                }
            }
        }
    }

    private boolean checkSame(int[][] a, int[][] b){
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if(a[i][j] != b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static void changeBeginningRow(int[][] beginning, int[][] copyBeginning, int rowNum) {
        for (int i = 0; i < beginning.length; i++){
            for (int j = 0; j < beginning[0].length; j++) {
                if(rowNum - 1 == i){
                    copyBeginning[i][j] = (beginning[i][j] == 0)? 1:0;
                }
                copyBeginning[i][j] = beginning[i][j];
            }
        }
    }

    void combination(int[] arr, int start, int n, int r, List<int[]> list) {
        if(r == 0) {
            int[] array = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                array[i] = arr[i];
            }
            list.add(array);
            return;
        }

        for(int i=start; i <= n; i++) {
            arr[index++] = i;
            combination(arr, i + 1, n, r - 1, list);
            index--;
        }
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(
                new int[][]{{0, 1, 0, 0, 0} ,{1, 0, 1, 0, 1} ,{0, 1, 1, 1, 0} ,{1, 0, 1, 1, 0} ,{0, 1, 0, 1, 0}},
                new int[][]{{0, 0, 0, 1, 1} ,{0, 0, 0, 0, 1} ,{0, 0, 1, 0, 1} ,{0, 0, 0, 1, 0} ,{0, 0, 0, 0, 1}}
            ), 5);
        Assertions.assertEquals(solution(
                new int[][]{{0, 0, 0} ,{0, 0, 0} ,{0, 0, 0}},
                new int[][]{{1, 0, 1} ,{0, 0, 0} ,{0, 0, 0}}
            ), 5);
    }
}
