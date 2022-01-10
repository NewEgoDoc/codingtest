package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class Lv2올바른괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            if(letter == '('){
                stack.add(letter);
            }

            if(letter == ')'){
                if(stack.empty()) return false;
                else stack.pop();
            }
        }
        return stack.empty();
    }

    @Test
    public void test(){
        assertEquals(solution("()()"),true);
        assertEquals(solution("(())()"),true);
        assertEquals(solution(")()("),false);
        assertEquals(solution("(()("),false);
    }
}
