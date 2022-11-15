package coding.test.programmers.Day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<Character, Integer> map = new HashMap<>();
        map.put('A',0);
        map.put('N',0);
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);

        for (int i = 0; i < survey.length; i++) {
            if(choices[i] > 0 && choices[i] < 4) {
                char ch = survey[i].charAt(0);
                map.put(ch, map.getOrDefault(ch, 0) + 4 - choices[i]);
            } else if(choices[i] > 4) {
                char ch = survey[i].charAt(1);
                map.put(ch, map.getOrDefault(ch, 0) + choices[i] - 4);
            }

        }

        System.out.println("map = " + map);

        StringBuilder sb  = new StringBuilder();
        if(map.get('R') >= map.get('T')) sb.append('R');
        else sb.append('T');

        if(map.get('C') >= map.get('F')) sb.append('C');
        else sb.append('F');

        if(map.get('J') >= map.get('M')) sb.append('J');
        else sb.append('M');

        if(map.get('A') >= map.get('N')) sb.append('A');
        else sb.append('N');

        return sb.toString();
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}),"TCMA");
        Assertions.assertEquals(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}),"RCJA");
    }

}
