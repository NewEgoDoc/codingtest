package coding.test.programmers.Day30;

import java.util.Arrays;
import java.util.Collections;

public class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        char[] charArr = s.toCharArray();

        Arrays.sort(charArr);

        for(char c: charArr){
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
