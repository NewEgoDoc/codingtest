package coding.test.summary.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class 대소문자변환 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        for(char c: input.toCharArray()){
            if(Character.isLowerCase(c)){ sb.append(Character.toUpperCase(c));
                continue;
            }
            if(Character.isUpperCase(c)){ sb.append(Character.toLowerCase(c));
                continue;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
