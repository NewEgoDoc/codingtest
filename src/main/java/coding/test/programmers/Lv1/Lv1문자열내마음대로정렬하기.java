package coding.test.programmers.Lv1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Lv1문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            System.out.println("n = " + n);
            if(o1.charAt(n) < o2.charAt(n)){
                return -1;
            } else if(o1.charAt(n) > o2.charAt(n)){
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        });

        return strings;
    }

    @Test
    public void test(){
        assertArrayEquals(solution(new String[]{"sun", "bed", "car"},1),new String[]{"car", "bed", "sun"});
        assertArrayEquals(solution(new String[]{"abce", "abcd", "cdx"},2),new String[]{"abcd", "abce", "cdx"});
    }
}
