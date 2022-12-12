package coding.test.programmers.Day19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 유전법칙 {

    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for(int i = 0; i < queries.length; i++){
            answer[i] = findCharacter(queries[i]);
        }

        return answer;
    }

    private String findCharacter(int[] query){
        int generation = query[0];
        int nth = query[1];

        Stack<Integer> stack = new Stack<>();
        nth -= 1;
        while(generation != 1){
            stack.push(nth % 4);
            generation -= 1;
            nth /= 4;
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            if(index == 0) return "RR";
            if(index == 3) return "rr";
        }

        return "Rr";
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution(new int[][]{{3, 8}, {2, 2}}), new String[]{"rr","Rr"});
        Assertions.assertArrayEquals(solution(new int[][]{{3, 1}, {2, 3}, {3, 9}}), new String[]{"RR", "Rr", "RR"});
    }

}
