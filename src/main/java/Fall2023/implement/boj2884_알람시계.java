package Fall2023.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2884_알람시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(" ");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        StringBuilder sb = new StringBuilder();

        if(minute >= 45){
            sb.append(hour);
            sb.append(" ");
            sb.append(minute - 45);
        } else {
            if(hour == 0) {
                sb.append(23);
                sb.append(" ");
                sb.append(60 + minute - 45);
            } else {
                sb.append(hour - 1);
                sb.append(" ");
                sb.append(60 + minute - 45);
            }
        }
        System.out.println(sb.toString());
    }
}
