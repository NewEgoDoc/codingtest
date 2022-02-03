package coding.test.programmers.Lv3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Lv32xn타일 {
    public int solution(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            int num = arr[i-1] + arr[i-2];
            arr[i] = (num)%1000000007;
        }

        System.out.println("arr[n] = " + arr[n]);

        return arr[n-1];
    }

    @Test
    public void test(){
        assertEquals(solution(4),5);
    }
}
