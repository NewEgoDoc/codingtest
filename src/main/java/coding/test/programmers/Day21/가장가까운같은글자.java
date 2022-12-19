package coding.test.programmers.Day21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 가장가까운같은글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for(int i = 0; i < s.length(); i++){
            if(i == 0){
                answer[i] = -1;
                continue;
            }

            String shortString = s.substring(0, i);
            char nowChar = s.charAt(i);
            int lastIndex = shortString.lastIndexOf(nowChar);
            if(lastIndex > -1){
                answer[i] = i - lastIndex;
                continue;
            }
            answer[i] = lastIndex;
        }
        return answer;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution("banana"), new int[]{-1, -1, -1, 2, 2, 2});
        Assertions.assertArrayEquals(solution("foobar"), new int[]{-1, -1, 1, -1, -1, -1});
    }
}
