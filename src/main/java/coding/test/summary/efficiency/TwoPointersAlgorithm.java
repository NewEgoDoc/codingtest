package coding.test.summary.efficiency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class TwoPointersAlgorithm {



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] a= new int[n];
        int index1 =0;
        StringTokenizer stk1 = new StringTokenizer(br.readLine());
        while(stk1.hasMoreTokens()){
            a[index1++] = Integer.parseInt(stk1.nextToken());
        }
        for (int i = 0; i < n; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();

        int m = Integer.parseInt(br.readLine());
        int[] b= new int[m];
        int index2 = 0;
        StringTokenizer stk2 = new StringTokenizer(br.readLine());
        while(stk2.hasMoreTokens()){
            b[index2++] = Integer.parseInt(stk2.nextToken());
        }
        for (int i = 0; i < m; i++) {
            System.out.print(" " + b[i]);
        }
        System.out.println();

        List<Integer> answer = solution(n, a, m, b);

        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static List<Integer> solution(int n, int[] a, int m, int[] b) {
        List<Integer> answer = new ArrayList<>();
        int p1= 0, p2 = 0;
        while(p1 < n && p2 < m){
            if(a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }

        while (p1 < n){
            answer.add(a[p1++]);
        }
        System.out.println("answer = " + answer);
        while (p2 < m){
            answer.add(b[p2++]);
        }
        System.out.println("answer = " + answer);

        return answer;
    }
}
