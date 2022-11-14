package coding.test.programmers.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 옹알이2 {

    String[] possiblePronounces = {"aya", "ye", "woo", "ma"};
    String[] duplicatePronounces = {"ayaaya","yeye","woowoo","mama"};
    public int solution(String[] babbling) {

        int count = 0;

        for (int i = 0; i < babbling.length; i++) {
            String str = babbling[i];

            for (String dp: duplicatePronounces) {
                str = str.replaceAll(dp, "D");
            }

            for (String pp: possiblePronounces) {
                str = str.replaceAll(pp, "P");
            }
            str = str.replaceAll("P","");
            if(str.length() == 0){
                count++;
            }
        }
        return count;
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new String[]{"aya", "yee", "u", "maa"}),1);
        Assertions.assertEquals(solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}),2);
    }

}
