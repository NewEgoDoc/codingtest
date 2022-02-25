package coding.test.summary.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class 문자찾기 {



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine().toLowerCase(Locale.ROOT);
        char letter = Character.toLowerCase(br.readLine().charAt(0));

        int num = solution(word, letter);
        sb.append(num);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int solution(String word, char letter) {
        int num = 0;

        for(char c: word.toCharArray()){
            if(c == letter){
                num++;
            }
        }
        return num;
    }
}
