package coding.test.getAsDev.D2023_02_3rdWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class boj2501약수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        LocalDateTime start1 = LocalDateTime.now();
        System.out.println("findTheNumberOfDivisors1(n) = " + findTheNumberOfDivisors1(n));
        LocalDateTime end1 = LocalDateTime.now();
        Duration between1 = Duration.between(start1, end1);
        System.out.println("between1 = " + between1);

        LocalDateTime start2 = LocalDateTime.now();
        System.out.println("findTheNumberOfDivisors2(n) = " + findTheNumberOfDivisors2(n));
        LocalDateTime end2 = LocalDateTime.now();
        Duration between2 = Duration.between(start2, end2);
        System.out.println("between2 = " + between2);

        LocalDateTime start3 = LocalDateTime.now();
        System.out.println("findTheNumberOfDivisors3(n) = " + findTheNumberOfDivisors3(n));
        LocalDateTime end3 = LocalDateTime.now();
        Duration between3 = Duration.between(start3, end3);
        System.out.println("between3 = " + between3);


        int index = 0;

        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                index++;
            }

            if(index == k){
                System.out.println(i);
                return;
            }
        }


        System.out.println(0);
    }

    //TODO: 1) 약수 개수 구하기 - 일반적인 방법
    static int findTheNumberOfDivisors1(int n){
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(n % i == 0) {
                count++;
            }
        }
        return count;
    }
    //TODO: 2) 약수 개수 구하기 - 제곱근사용
    static int findTheNumberOfDivisors2(int n){
        int count = 0;
        for (int i = 1; i*i <= n; i++) {
            if(i * i == n){
                count++;
            }

            if(n % i == 0){
                count += 2;
            }
        }
        return count;
    }
    //TODO: 3) 약수 개수 구하기 - 제곱을 이용한 공식
    static int findTheNumberOfDivisors3(int n){
        Map<Integer, Integer> map = new HashMap<>();
        int num = 2;
        for (int i = 2; i <= n; i++) {
            int count = 0;
            if(n % i == 0){
                while (n % i == 0) {
                    n /= i;
                    count++;
                }
                map.put(i, count);
            }
        }
        int number = 1;
        for(int key: map.keySet()){
            number *= (map.get(key) + 1);
        }
        return number;
    }

}
