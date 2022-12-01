package coding.test.programmers.Day15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class 삼진법뒤집기 {
    public int solution(int n){
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        //3진법
        while(n != 0) {
            list.add(n % 3);
            n /= 3;
        }
        System.out.println("list = " + list);

        //10진법
        int tmp = 1;
        for(int i = list.size() - 1; i >= 0; i--) {
            answer += list.get(i) * tmp;
            tmp *= 3;
            System.out.println("tmp = " + tmp);
        }
        return answer;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(45),7);
        Assertions.assertEquals(solution(125),229);
    }
}
