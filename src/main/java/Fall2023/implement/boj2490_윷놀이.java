package Fall2023.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2490_윷놀이 {
    static String[] state = {"E","A","B","C","D"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            String answer = count(input);
            System.out.println(answer);
        }
    }

    private static String count(String[] input) {
        int num = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i].equals("0")){
                num++;
            }
        }
        return state[num];
    }
}
