package coding.test.summary.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 문장속단어 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(solution(br.readLine()));
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk = new StringTokenizer(input);

        int length = 0;
        while(stk.hasMoreTokens()){
            String word = stk.nextToken();
            if(length < word.length()) {
                length = word.length();
                sb.delete(0,sb.length());
                sb.append(word);
            }
        }
        return sb.toString();
    }
}
