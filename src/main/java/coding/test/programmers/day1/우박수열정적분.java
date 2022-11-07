package coding.test.programmers.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 우박수열정적분 {

    List<Double> list;
    List<Double> area;
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        list = new ArrayList<>();
        list.add((double)k);
        collatz(k);
        calculateRangeEachArea();

        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int x1 = range[0];
            int x2 = list.size() + range[1] - 1;
            System.out.println(x1 + " " + x2);
            double sum = 0.0;
            if(x1 > x2) {
                answer[i] = -1.0;
                continue;
            }
            if(x1 == x2) {
                answer[i] = 0.0;
                continue;
            }
            for (int j = x1; j < x2; j++) {
                sum += area.get(j);
            }
            answer[i] = sum;

        }

        for (double a: answer) {
            System.out.println("a = " + a);
        }

        System.out.println("list = " + list);
        System.out.println("area = " + area);
        return answer;
    }



    private void calculateRangeEachArea() {
        area = new ArrayList<>();
//        area.add(0.0);
        for (int i = 1; i < list.size(); i++) {
            Double y1 = list.get(i - 1);
            Double y2 = list.get(i);

            if(y2 - y1 > 0){
                area.add(y1 + ((y2 - y1)/2));
            }
            if(y2 - y1 < 0){
                area.add(y2 + ((y1 - y2)/2));
            }
        }
    }

    //    1-1. 입력된 수가 짝수라면 2로 나눕니다.
//    1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
//    2.결과로 나온 수가 1보다 크다면 1번 작업을 반복합니다.
    void collatz(int number){

        while(number > 1){
            if(number % 2 == 0){
                number /= 2;
            } else {
                number = number * 3 + 1;
            }

            list.add((double)number);
        }
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution(5, new int[][]{{0,0},{0,-1},{2,-3},{3,-3}}), new double[]{33.0,31.5,0.0,-1.0});
    }

}
