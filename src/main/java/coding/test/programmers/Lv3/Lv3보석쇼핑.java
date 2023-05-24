package coding.test.programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Lv3보석쇼핑 {
    public int[] solution(String[] gems) {
        int[] answer = {0,0};
        Set<String> set = new HashSet<>();
        for(String gem: gems){
            set.add(gem);
        }

        int min = Integer.MAX_VALUE;

        int s = 0;
        int e = s;
        Map<String, Integer> map = new HashMap<>();
        map.put(gems[s], 1);
        while(s < gems.length){
            if(map.keySet().size() == set.size()){
                if(min > e -s){
                    min = e - s;
                    answer = new int[]{s+1, e+1};
                }
                map.put(gems[s], map.get(gems[s]) - 1);
                if(map.get(gems[s]) == 0){
                    map.remove(gems[s]);
                }
                s++;
            } else if (e < gems.length - 1){
                e++;
                map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);
            } else {
                break;
            }
        }

        return answer;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}),
                new int[]{3, 7});
        Assertions.assertArrayEquals(solution(new String[]{"AA", "AB", "AC", "AA", "AC"}),
                new int[]{1, 3});
        Assertions.assertArrayEquals(solution(new String[]{"XYZ", "XYZ", "XYZ"}),
                new int[]{1, 1});
        Assertions.assertArrayEquals(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}),
                new int[]{1, 5});
    }
}
