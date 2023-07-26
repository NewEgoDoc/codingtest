package coding.test.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj19942다이어트 {
    static int N;
    static int[] minimumNutrition;
    static List<int[]> goods;
    static boolean[] visited;
    static List<Integer> list;

    static int min;

    static boolean isStop;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        min = N;
        isStop = false;
        minimumNutrition = new int[4];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            minimumNutrition[i] = Integer.parseInt(split[i]);
        }

        visited = new boolean[N];
        goods = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            goods.add(new int[]{
                    Integer.parseInt(input[0]),
                    Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]),
                    Integer.parseInt(input[3])
            });
        }

        list = new ArrayList<>();

        dfs();

//        System.out.println("list = " + list);

    }

    private static void dfs(){

        if(isMoreThanMinimum() && min < list.size()){
            min = Math.min(min, list.size());
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
