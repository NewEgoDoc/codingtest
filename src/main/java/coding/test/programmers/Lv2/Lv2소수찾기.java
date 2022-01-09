package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Lv2소수찾기 {
    StringBuilder sb = null;
    int n = 0;
    boolean[] visited = null;
    String numbersCopy;
    List<Integer> numberList = new ArrayList<>();
    public int solution(String numbers) {
        numbersCopy = new StringBuilder().append(numbers).toString();
        sb = new StringBuilder();
        n = numbers.length();
        visited = new boolean[n];

        int answer = 0;
        int[] numberArray = makePossibleNumbers();
        return answer;
    }

    private int[] makePossibleNumbers() {
        int[] array;

        for(int i = 0 ;i < n; i++){
            permutation(0,i);
        }

        System.out.println(numberList);

        return new int[0];
    }


    private void permutation(int index, int x) {
        if(index == x){
            numberList.add(Integer.parseInt(sb.toString()));
        }

        for (int i = 0; i < n; i++) {
            if(visited[i] == false){//방문 한적이 없다면
                visited[i] = true;//방문체크
                sb.append(numbersCopy.charAt(i));
                permutation(index+1,x);//인덱스만 하나로 앞으로 해주고 모두 방문해본다.
                visited[i] = false;//방문하고 나온후에는 해당 지점은 방문 취소 처리
            }
        }
    }

    @Test
    public void test(){
        assertEquals(solution("17"),3);
        assertEquals(solution("011"),2);
    }
}
