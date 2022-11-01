package coding.test.baekjoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class boj1016 {

    int solution(String min, String max){
        long minimum = Long.parseLong(min);
        long maximum = Long.parseLong(max);

        int length = (int)(maximum - minimum + 1);

        //1) max - min + 1 만큼의 길이를 가진 boolean 배열을 생성
        boolean[] checked = new boolean[length];
        // 제곱 ㄴㄴ수가 아님을 체크.
        // false : 제곱ㄴㄴ수,
        // true : 제곱ㄴㄴ수가 아님.

        //2) max의 제곱근을 구한다.
        int maxSqrt = ((int) Math.sqrt(maximum));

        long[] num = new long[length];

        for(long i = 2; i <= maxSqrt; i++) {
            long squared = i * i;
            long start = minimum % squared == 0 ? minimum / squared : (minimum / squared) + 1;
            for(long j = start; j * squared <= maximum; j ++) {	// 몫을 1씩 증가시킴( j가 몫 )
                checked[(int) ( (j * squared) - minimum)] = true;
            }
        }

        // 제곱ㄴㄴ수 개수 counting
        int count = 0;
        for(int i = 0; i < length; i++) {
            if(!checked[i])
                count++;
        }

        return count;

    }

    @Test
    void test(){
        Assertions.assertEquals(solution("1","10"),7);
        Assertions.assertEquals(solution("15","15"),1);
        Assertions.assertEquals(solution("1","1000"),608);
    }
}
