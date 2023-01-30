package coding.test.commulearning.week3.section3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 올바른괄호개수 {

    int count;
    public int solution(int n) {
        count = 0;

        dfs(0,0, n);

        return count;
    }

    void dfs(int left, int right, int n){
        System.out.println("left = " + left);
        System.out.println("right = " + right);

        if(left < right) return;
        if(left == n && right == n){
            count++;
            return;
        }

        if(left > n || right > n) return;

        dfs(left + 1, right, n);
        dfs(left, right + 1, n);
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(2),2);
        Assertions.assertEquals(solution(3),5);
        Assertions.assertEquals(solution(5),0);

    }
}
