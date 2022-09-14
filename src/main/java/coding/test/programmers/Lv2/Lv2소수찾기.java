package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class Lv2소수찾기 {

    StringBuilder sb = new StringBuilder();

    private char[] array;
    private boolean[] visited;
    private char[] result;
    private int n;
    private int index;
    Set<Integer> numSet;

    public int solution(String numbers) {
        numSet = new HashSet<>();

        index = 0;
        array = numbers.toCharArray();
        n = array.length;
        result = new char[n];
        visited = new boolean[n];

        for (int i = 1; i <= n; i++) {
            permutation(i);
        }

        System.out.println("numSet = " + numSet);
        return numSet.size();
    }

    private void permutation(int r) {
        if(index == r){
            for (int i = 0; i < r; i++) {
                sb.append(result[i]);
            }
            int number = Integer.parseInt(sb.toString());
            if(isPrimeNumber(number)) numSet.add(number);
            sb.delete(0,n);
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[index] = array[i];
                index++;
                permutation(r);
                index--;
                visited[i] =false;
            }
        }
    }

    private boolean isPrimeNumber(int number) {
        if(number == 0 || number == 1) return false;
        for (int i = 2; i < number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }

    @Test
    void test(){
        // solution("123");
        solution("011");
        // solution("001");
        // solution("1311");
    }
}
