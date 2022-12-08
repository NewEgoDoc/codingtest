package coding.test.programmers.Day18;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class 외톨이알파벳 {
    // https://school.programmers.co.kr/learn/courses/15008/lessons/121683
    public String solution(String input_string) {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();

        char previousLetter = input_string.charAt(0);
        map.put(previousLetter, new ArrayList<>());
        int previousIndex = 0;
        char nowLetter;
        for (int i = 1; i < input_string.length(); i++) {

            nowLetter = input_string.charAt(i);

            if(previousLetter != nowLetter){
                map.get(previousLetter).add(previousIndex);
                if (map.get(nowLetter) == null) {
                    map.put(nowLetter, new ArrayList<>());
                }
                previousLetter = nowLetter;
             }

            previousIndex = i;
            if(i == input_string.length()-1){
                if (map.get(nowLetter) == null) {
                    map.put(nowLetter, new ArrayList<>());
                }
                map.get(nowLetter).add(i);
            }

        }

        System.out.println("map = " + map);

        Set<Character> keySet = map.keySet();
        List<Character> list = new ArrayList<>();
        for(char key: keySet){
            if(map.get(key).size() > 1) list.add(key);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (char c: list){
            sb.append(c);
        }


        return sb.toString().isEmpty()? "N":sb.toString();
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution("edeaaabbccd"),"de");
        Assertions.assertEquals(solution("eeddee"),"e");
        Assertions.assertEquals(solution("string"),"N");
        Assertions.assertEquals(solution("zbzbz"),"bz");
    }
}
