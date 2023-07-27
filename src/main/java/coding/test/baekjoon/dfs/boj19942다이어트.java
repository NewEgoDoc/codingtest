package coding.test.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class boj19942다이어트 {
    static int N;
    static int[] minimumNutrition;
    static List<int[]> goods;
    static boolean[] visited;
    static List<Integer> list;

    static List<Integer> answer;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        minimumNutrition = new int[4];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            minimumNutrition[i] = Integer.parseInt(split[i]);
        }

        goods = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            goods.add(new int[]{
                    Integer.parseInt(input[0]),
                    Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]),
                    Integer.parseInt(input[3]),
                    Integer.parseInt(input[4])
            });
        }

        list = new ArrayList<>();
        visited = new boolean[N];
        min = Integer.MAX_VALUE;

        dfs();

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append("\n");

        for(int index: answer){
            sb.append(index+1);
            sb.append(" ");
        }

        System.out.println(sb);
    }

    private static void dfs(){
        if(isMoreThanMinimum()){
            if(min > sum()){
                min = sum();
                answer = list.stream().toList();
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                list.add(i);
                dfs();
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }


    }

    private static int sum() {
        int cost = 0;
        for(int l: list){
            cost += goods.get(l)[4];
        }
        return cost;
    }

    private static boolean isMoreThanMinimum() {
        int[] sum = new int[4];
        for (int i = 0; i < list.size(); i++) {
            sum[0] += goods.get(list.get(i))[0];
            sum[1] += goods.get(list.get(i))[1];
            sum[2] += goods.get(list.get(i))[2];
            sum[3] += goods.get(list.get(i))[3];
        }


        return sum[0] >= minimumNutrition[0] &&
                sum[1] >= minimumNutrition[1] &&
                sum[2] >= minimumNutrition[2] &&
                sum[3] >= minimumNutrition[3];
    }
}
