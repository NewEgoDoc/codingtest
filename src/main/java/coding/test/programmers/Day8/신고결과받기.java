package coding.test.programmers.Day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> reportMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        int[] announce = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
            reportMap.put(id_list[i],new HashSet<>());
        }

        for (int i = 0; i < report.length; i++) {
            String[] names = report[i].split(" ");
            String reporting = names[0];
            String reported = names[1];

            reportMap.get(reported).add(reporting);
        }

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> reportingPeople = reportMap.get(id_list[i]);
            if(reportingPeople.size() >= k) {
                for (String name: reportingPeople){
                    int index = indexMap.get(name);
                    announce[index] += 1;
                }
            }
        }

        for (int i = 0; i < announce.length; i++) {
            System.out.print(" " + announce[i]);
        }
        System.out.println();

        return announce;
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
