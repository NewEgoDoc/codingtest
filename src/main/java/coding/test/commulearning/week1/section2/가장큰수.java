package coding.test.commulearning.week1.section2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            nums[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(nums, (o1, o2)-> {
            return (o2 + o1).compareTo(o1 + o2);
        });

        if(nums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(String string: nums){
            sb.append(string);
        }

        return sb.toString();
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new int[]{6, 10, 2}),"6210");
    }

}
