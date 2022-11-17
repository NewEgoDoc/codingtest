package coding.test.programmers.Day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n제곱배열자르기 {
    public List<Long> solution(int n, long left, long right) {

        List<Long> list = new ArrayList<>();

        for(long i=left;i<right+1;i++){
            list.add(Math.max(i/n,i%n) + 1);
        }

        return list;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(3,2,5), Arrays.asList(3,2,2,3));
        Assertions.assertEquals(solution(4, 7, 14), Arrays.asList(4,3,3,3,4,4,4,4));
    }
}
