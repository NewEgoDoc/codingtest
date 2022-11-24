package coding.test.programmers.Day12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class 귤고르기 {
    int n;
    int r;
    int index;
    int start;
    int[] array;
    int[] result;
    int min;
    int numberOfSort;
    public int solution(int k, int[] tangerine) {
        boolean reverse = false;
        start = 0;
        array = tangerine;
        n = tangerine.length;
        r = k;
        if(n - k < n/2){
            r = n - k;
            reverse = true;
        }
        result = new int[r];
        Set<Integer> set = new HashSet<>();
        for(int t: tangerine){
            set.add(t);
        }
        numberOfSort = set.size();
        min = Integer.MAX_VALUE;
        combination(reverse);

        return min;
    }

    private void combination(boolean reverse) {
        if(index == r) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < r; i++) {
                set.add(result[i]);
            }
            if(reverse) {
                min = Math.min(min, numberOfSort - set.size());
            } else {
                min = Math.min(min, set.size());
            }

            return;
        }
        for (int i = start; i < n; i++) {
            result[index] = array[i];
            start = i + 1;
            index++;
            combination(reverse);
            index--;
        }
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}),3);
        Assertions.assertEquals(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}),2);
        Assertions.assertEquals(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}),1);
    }
}
