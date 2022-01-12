package coding.test.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv1완주하지못한선수 {

    boolean[] visited = null;
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i = 0;
        for(i=0;i<completion.length;i++){
            if(!participant[i].equals(completion[i]))
                break;
        }
        return participant[i];
    }

    

    @Test
    public void test(){
        Assertions.assertEquals(solution(new String[]{"leo", "kiki", "eden"},
                                         new String[]{"eden", "kiki"}), "leo");
        Assertions.assertEquals(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                                         new String[]{"josipa", "filipa", "marina", "nikola"}),"vinko");
        Assertions.assertEquals(solution(new String[]{"mislav", "stanko", "mislav", "ana"},
                                         new String[]{"stanko", "ana", "mislav"}),"mislav");
    }
}
