package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv2모음사전 {
    int nth;
    StringBuilder sb;
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    Map<String, Integer> map;
    public int solution(String word) {
        nth = 0;
        sb = new StringBuilder();
        map = new HashMap<>();
        recursion(word);
        return map.get(word);
    }

    private void recursion(String word) {

        map.put(sb.toString(), nth);

        if(sb.length() == 5) return;

        for (int i = 0; i < 5; i++) {
            sb.append(vowels[i]);
            nth++;
            recursion(word);

            sb.delete(sb.toString().length()-1,sb.toString().length());

        }
    }

    @Test
    void test() {
        Assertions.assertEquals(solution("AAAAE"),6);
        Assertions.assertEquals(solution("AAAE"),10);
        Assertions.assertEquals(solution("I"),1563);
        Assertions.assertEquals(solution("EIO"),1189);
    }

}
