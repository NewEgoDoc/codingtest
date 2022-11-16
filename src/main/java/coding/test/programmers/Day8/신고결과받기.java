package coding.test.programmers.Day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            index.put(name, i);
        }

        for (String s : report) {
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            map.get(to).add(from);
        }

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
            if (send.size() >= k) {
                for (String name : send) {
                    answer[index.get(name)]++;
                }
            }
        }
        return answer;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(
                solution(
                    new String[]{"muzi", "frodo", "apeach", "neo"},
                    new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                    2
                ),new int[]{2,1,1,0});
        Assertions.assertArrayEquals(
                solution(
                        new String[]{"con", "ryan"},
                        new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                        3
                ),new int[]{0,0});
    }
}
