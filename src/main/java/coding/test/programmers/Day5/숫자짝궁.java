package coding.test.programmers.Day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 숫자짝궁 {

    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();

        int[] xCount = new int[10];
        int[] yCount = new int[10];

        for (int i = 0; i < X.length(); i++) {
            xCount[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            yCount[Y.charAt(i) - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            int min = Math.min(xCount[i], yCount[i]);
            for (int j = 0; j < min; j++) {
                sb.append(i);
            }
        }

        if (sb.toString().equals("")) {
            return "-1";
        } else if (sb.toString().startsWith("0")) {
            return "0";
        } else {
            return sb.toString();
        }
    }

    @Test
    void test(){
        Assertions.assertEquals(solution("100", "2345"),"-1");
        Assertions.assertEquals(solution("100", "203045"),"0");
        Assertions.assertEquals(solution("100", "123450"),"10");
        Assertions.assertEquals(solution("12321", "42531"),"321");
        Assertions.assertEquals(solution("5525",	"1255"),"552");
    }
}
