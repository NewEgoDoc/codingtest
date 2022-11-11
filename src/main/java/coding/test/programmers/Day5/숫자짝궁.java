package coding.test.programmers.Day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 숫자짝궁 {
    public String solution(String X, String Y) {
        String answer = "";
        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution("100","2345"),"-1");
        Assertions.assertEquals(solution("100",	"203045"),"0");
        Assertions.assertEquals(solution("100",	"123450"),"10");
        Assertions.assertEquals(solution("12321",	"42531"),"321");
        Assertions.assertEquals(solution("5525",	"1255"),"552");
    }
}
