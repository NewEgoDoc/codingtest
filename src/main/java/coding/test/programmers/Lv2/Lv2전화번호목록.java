package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Lv2전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }


        return answer;
    }

    @Test
    public void test(){
        assertEquals(solution(new String[]{"119", "97674223", "1195524421"}),false);
        assertEquals(solution(new String[]{"123","456","789"}),true);
        assertEquals(solution(new String[]{"12","123","1235","567","88"}),false);
    }
}
