package coding.test.programmers.Day27;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        System.out.println("participant = " + Arrays.toString(participant));
        System.out.println("completion = " + Arrays.toString(completion));
        for (int i = 0; i < completion.length; i++) {
            if(!completion[i].equals(participant[i])) return participant[i];
        }

        return participant[participant.length - 1];
    }

    @Test
    void test(){
        Assertions.assertEquals(solution(new String[]{"leo", "kiki", "eden"},new String[]{"eden", "kiki"}),"leo");
        Assertions.assertEquals(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},new String[]{"josipa", "filipa", "marina", "nikola"}),"vinko");
        Assertions.assertEquals(solution(new String[]{"mislav", "stanko", "mislav", "ana"},new String[]{"stanko", "ana", "mislav"}),"mislav");
    }
}
