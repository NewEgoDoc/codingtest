package Fall2023.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj14578영훈이색칠공부 {

    static List<Integer> dp;
    static int mod = 1000000007;
    static int f = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new ArrayList<>();
        dp.add(0);
        dp.add(0);
        dp.add(1);

        if(N > 2){
            for (int i = 3; i < N+1; i++) {
                dp.add(((dp.get(i-1)+ dp.get(i-2))*(i-1)) % mod);
                f *= i;
                System.out.println((f*dp.get(N)) % mod);
            }
        } else {
            if(N == 1){
                System.out.println(0);
            } else {
                System.out.println(2);
            }
        }
    }
}
