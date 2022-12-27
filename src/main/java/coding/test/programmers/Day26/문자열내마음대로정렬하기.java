package coding.test.programmers.Day26;

import java.util.*;
public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        for(int i = 0; i < strings.length; i++){
            answer[i] = strings[i];
        }
        Arrays.sort(answer);
        Arrays.sort(answer,((e1, e2)->{

            if(e1.charAt(n) == e2.charAt(n)){

            }

            return e1.charAt(n) - e2.charAt(n);
        }));

        return answer;
    }
}
