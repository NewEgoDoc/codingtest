package coding.test.programmers.Day23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 크기가작은부분문자열 {
    public int solution(String t, String p) {
        int answer = 0;
        long pNumber = Long.parseLong(p);
        int tLength = t.length();
        int pLength = p.length();

        long number;
        String partialString;
        for(int i = 0; i <= tLength - pLength; i++){
            partialString = t.substring(i, i+pLength);
            number = Long.parseLong(partialString);
            if(pNumber >= number) answer++;
        }

        return answer;
    }
    @Test
    void test(){
        Assertions.assertEquals(solution("3141592","271"),2);
        Assertions.assertEquals(solution("500220839878","7"),8);
        Assertions.assertEquals(solution("10203","15"),3);
        Assertions.assertEquals(solution("10","15"),1);
        Assertions.assertEquals(solution("1","1"),1);
        Assertions.assertEquals(solution("3","1"),0);
        Assertions.assertEquals(solution("31231","11231"),0);
        Assertions.assertEquals(solution("1231","11231"),0);
    }

}
