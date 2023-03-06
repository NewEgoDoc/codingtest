package coding.test.getAsDev.D2023_02_3rdWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj1977완전제곱수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        /** 제곱수 찾기 */
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(i*i >= m && i*i <= n){
                list.add(i*i);
            }
        }

        /** 제곱수가 하나도 없다면 -1 리턴 */
        if(list.size() == 0){
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for(int num: list){
            sum += num;
        }
        System.out.println(sum);
        System.out.println(list.get(0));

    }

}
