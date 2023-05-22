package coding.test.programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Lv3불량사용자 {
    boolean[] visited;
    int index;
    int start;
    String[] result;

    int count;

    Set<String[]> list;
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[banned_id.length];
        index = 0;
        start = 0;
        result = new String[banned_id.length];
        list = new HashSet<>();
        dfs(user_id, banned_id);
        for (String[] s: list){
            System.out.println(Arrays.toString(s));
        }
        return 0;
    }

    void dfs(String[] user_id, String[] banned_id){
        if(index == banned_id.length){
            return;
        }
        for (int i = start; i < banned_id.length; i++) {
            start = i + 1;
            result[index] = banned_id[i];
            index++;
            dfs(user_id, banned_id);
            index--;
        }
    }
    @Test
    void test(){
        Assertions.assertEquals(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "abc1**"}), 2);
        Assertions.assertEquals(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"*rodo", "*rodo", "******"}), 2);
        Assertions.assertEquals(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "*rodo", "******", "******"}), 3);
    }
}
