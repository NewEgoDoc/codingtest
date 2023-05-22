package coding.test.programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Lv3불량사용자 {
    HashSet<HashSet<String>> answer;
    public int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<>();

        dfs(new LinkedHashSet<>(), user_id, banned_id);

        return answer.size();
    }


    private void dfs(HashSet<String> hs, String[] user_id, String[] banned_id) {
        if (hs.size() == banned_id.length) {
//            System.out.println(hs);
            if (isSatisfied(hs, banned_id)) {
                answer.add(new HashSet<>(hs));
            }
            return;
        }

        for (String userId : user_id) {
            if (hs.add(userId)) {
                dfs(hs, user_id, banned_id);
                hs.remove(userId);
            }
        }
    }

    private boolean isSatisfied(HashSet<String> hs, String[] bannedId) {
        int i = 0;

        for (String user : hs) {
            if (!isSameString(user, bannedId[i++])) {
                return false;
            }
        }

        return true;
    }

    private boolean isSameString(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) == '*') continue;

            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        return true;
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
