package coding.test.getAsDev.D2023_01_3rdWeek;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 다트게임 {
    public int solution(String dartResult) {
        int index = -1;
        int[] round = new int[3];

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if(c >= '0' && c <= '9'){
                index++;
                if(c == '1' && dartResult.charAt(i + 1) == '0'){
                    round[index] = 10;
                    i++;
                    continue;
                }
                round[index] = c - 48;
                continue;
            }
            if(c == 'S'){
                continue;
            }
            if(c == 'D'){
                round[index] = (int)Math.pow(round[index], 2);
                continue;
            }
            if(c == 'T'){
                round[index] = (int)Math.pow(round[index], 3);
                continue;
            }


            if(c == '*'){
                if(index > 0) {
                    round[index-1] *= 2;
                }
                round[index] *= 2;
            }
            if(c == '#'){
                round[index] *= -1;
            }

        }
        return round[0] + round[1] + round[2];
    }
    @Test
    void test(){
        Assertions.assertEquals(solution("1S2D*3T"),37);
        Assertions.assertEquals(solution("1D2S#10S"),9);
        Assertions.assertEquals(solution("1D2S0T"),3);
        Assertions.assertEquals(solution("1S*2T*3S"),23);
        Assertions.assertEquals(solution("1D#2S*3S"),5);
        Assertions.assertEquals(solution("1T2D3D#"),-4);
        Assertions.assertEquals(solution("1D2S3T*"),59);
    }
}
