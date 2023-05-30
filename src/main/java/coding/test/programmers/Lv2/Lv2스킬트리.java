package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;

public class Lv2스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skill_tree: skill_trees){
            String skillTreeNeeded = makeNecessarySkillTree(skill,skill_tree);
            if(skill.indexOf(skillTreeNeeded) == 0){
                answer++;
            }
        }

        return answer;
    }

    public int solution2(String skill, String[] skill_trees){
        return  (int) Arrays.stream(skill_trees)
                .map((s)-> s.replaceAll("[^" + skill +"]",""))
                .filter(skill::startsWith)
                .count();
    }

    private String makeNecessarySkillTree(String skill, String skill_tree) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < skill_tree.length(); i++) {
            if(isNecessarySkill(skill, skill_tree.charAt(i))) {
                sb.append(skill_tree.charAt(i));
            }
        }
        return sb.toString();
    }

    private boolean isNecessarySkill(String skill, char c) {
        for (int i = 0; i < skill.length(); i++) {
            if(skill.charAt(i) == c) return true;
        }
        return false;
    }


    @Test
    public void test(){
        assertEquals(solution2("CBD",
                new String[]{"BACDE", "CBADF", "AECB", "BDA"}),2);

        assertEquals(solution2("CBDK",
                new String[]{"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"}),4);
        assertEquals(solution2("CBD",
                new String[]{"C", "D", "CB", "BDA"}),2);
        assertEquals(solution2("CBD",
                new String[]{"AEF", "ZJW"}),2);
        assertEquals(solution2("BDC",
                new String[]{"AAAABACA"}),0);


    }
}
