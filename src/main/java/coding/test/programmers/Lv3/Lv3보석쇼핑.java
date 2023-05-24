package coding.test.programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lv3보석쇼핑 {
    public int[] solution(String[] gems) {
        int[] answer = {0,0};
        Set<String> set = new HashSet<>();
        for (String gem: gems){
            set.add(gem);
        }


        int start = 0;
        int end = gems.length - 1;

        int min = Integer.MAX_VALUE;

        int s = start;
        int e = s;


        boolean isMinimum = false;
        while(s <= end){

            Set<String> findSet = new HashSet<>();
            while(e < end + 1){
                if(findSet.contains(gems[e])){
                    e++;
                    continue;
                }

                findSet.add(gems[e]);

                if(findSet.size() == set.size()){

                    if(min > (e - s)){
                        min = (e-s);
                        answer = new int[]{s+1, e+1};
                    }

                    break;
                }
                e++;
            }

            s++;
            e = s;
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
