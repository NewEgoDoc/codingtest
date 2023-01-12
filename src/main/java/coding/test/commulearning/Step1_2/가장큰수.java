package coding.test.commulearning.Step1_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(stringNumbers, (o1, o2) -> {
            return (o2+o1).compareTo(o1+o2);
        });

        if(stringNumbers[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(String stringNumber: stringNumbers){
            sb.append(stringNumber);
        }
        return sb.toString();
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{6, 10, 2}),"6210");
    }
}
