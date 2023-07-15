package coding.test.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class lv1신규아이디추천 {
    public String solution(String new_id) {
        //1
        String level1 = new_id.toLowerCase();

        //2
        String level2 = getStringLevel2(level1);

        //3
        String level3 = level2.replaceAll("\\.{2,}",".");

        //4
        String level4 = getStringLevel4(level3);

        //5
        String level5 = level4.isEmpty()? "a":level4;

        //6 then 4
        String level6 = level5.length() >= 16? getStringLevel4(level5.substring(0, 15)): level5;

        //7
        String level7 = getStringLevel7(level6);

        return level7;

    }

    private String getStringLevel7(String level6) {
        char lastLetter = level6.charAt(level6.length() - 1);

        StringBuilder sb = new StringBuilder();
        sb.append(level6);
        while (sb.length() <= 2){
            sb.append(lastLetter);
        }

        return sb.toString();
    }

    private String getStringLevel4(String level3) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level3.length(); i++) {
            char letter = level3.charAt(i);
            if(i == 0 && letter == '.'){
                continue;
            }
            if(i == level3.length()-1 && letter == '.'){
                continue;
            }
            sb.append(letter);
        }
        return sb.toString();
    }

    private String getStringLevel2(String level1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level1.length(); i++) {
            char letter = level1.charAt(i);
            if(letter >= 'a' && letter <= 'z'){
                sb.append(letter);
                continue;
            }

            if(letter >= '0' && letter <= '9'){
                sb.append(letter);
                continue;
            }

            if(letter == '-' || letter == '_' || letter == '.'){
                sb.append(letter);
                continue;
            }
        }
        return sb.toString();
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(".......!@BaT#*..y.abcdefghijklm"), "bat.y.abcdefghi");
        Assertions.assertEquals(solution("z-+.^."), "z--");
        Assertions.assertEquals(solution("=.="), "aaa");
        Assertions.assertEquals(solution("123_.def"), "123_.def");
    }
}
