package coding.test.programmers.Day14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 괄호변환 {
    public String solution(String p) {
        if(p.equals("")) return "";



        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(""),"");
        Assertions.assertEquals(solution("(()())()"),"(()())()");
        Assertions.assertEquals(solution(")("),"()");
        Assertions.assertEquals(solution("()))((()"),"()(())()");
    }
}
