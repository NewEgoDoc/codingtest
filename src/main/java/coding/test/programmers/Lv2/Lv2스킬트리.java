package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;

public class Lv2스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            //skill_tree
            if(isPossibleSkillTree(skill_tree,skill)){
                answer++;
            }
        }

        return answer;
    }

    private boolean isPossibleSkillTree(String skill_tree, String skill) {
        Stack<Character> stack = new Stack<>();
        for(char s: skill_tree.toCharArray()){
            stack.add(s);
        }



        return false;
    }


    @Test
    public void test(){
        assertEquals(solution("CBD",
                new String[]{"BACDE", "CBADF", "AECB", "BDA"}),2);
        assertEquals(solution("CBDK",
                new String[]{"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"}),4);
        assertEquals(solution("CBD",
                new String[]{"C", "D", "CB", "BDA"}),2);
        assertEquals(solution("CBD",
                new String[]{"AEF", "ZJW"}),2);
        assertEquals(solution("BDC",
                new String[]{"AAAABACA"}),0);
    }
}
