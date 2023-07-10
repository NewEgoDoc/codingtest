package coding.test.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Lv1개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {

        Map<String, Integer> map = new HashMap<>();
        for(String term: terms) {
            String[] array = term.split(" ");
            map.put(array[0], Integer.parseInt(array[1])*28);
        }

        int todayInt = calculateDays(today);

        List<Integer> delete = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] info = privacies[i].split(" ");
            int dayInt = calculateDays(info[0]);

            if(todayInt - dayInt >= map.get(info[1])){
                delete.add(i+1);
            }
        }

        int[] answer = new int[delete.size()];
        for (int i = 0; i < delete.size(); i++) {
            answer[i] = delete.get(i);
        }

        return answer;
    }

    private int calculateDays(String date) {
        String[] yyyymmdd = date.split("\\.");
        int year = Integer.parseInt(yyyymmdd[0]);
        int month = Integer.parseInt(yyyymmdd[1]);
        int day = Integer.parseInt(yyyymmdd[2]);

        return (year - 1) * 12 * 28 + (month - 1) * 28 + day;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}), new int[]{1, 3});
        Assertions.assertArrayEquals(solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}), new int[]{1, 4, 5});
    }
}
