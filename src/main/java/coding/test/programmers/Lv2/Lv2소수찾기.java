package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class Lv2소수찾기 {
    StringBuilder sb = new StringBuilder();
    public int solution(String numbers) {

        boolean[] visited = new boolean[numbers.length()];
        Set<Integer> possibleNums = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, visited, 0, i+1, possibleNums);
        }

        System.out.println("possibleNums = " + possibleNums);

        return possibleNums.size();
    }

    private void dfs(String numbers, boolean[] visited, int index, int size, Set<Integer> possibleNums) {
        if(index == size){
            if(isPrime(Integer.parseInt(sb.toString()))) {
                possibleNums.add(Integer.parseInt(sb.toString()));
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]){
                visited[i] = true;
                sb.append(numbers.charAt(i));
                dfs(numbers,visited,index+1,size,possibleNums);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
        }

    }

    private boolean isPrime(int num){
        if(num == 0 || num == 1) return false;

        for (int i = 2; i < num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    @Test
    public void test(){
        assertEquals(solution("17"),3);
        assertEquals(solution("011"),2);
    }
}
