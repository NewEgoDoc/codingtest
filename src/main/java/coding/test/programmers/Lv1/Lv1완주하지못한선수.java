package coding.test.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Lv1완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        List<String> participantList = ArrayToList(participant);

        for(int i = 0; i < completion.length; i++){
            compareCompletionToParticipant(completion,i,participantList);
        }

        return participantList.get(0);
    }

    private void compareCompletionToParticipant(String[] completion, int i, List<String> participantList) {
        for (int j = 0; j < participantList.size(); j++) {
            if(completion[i].equals(participantList.get(j))){
                participantList.remove(participantList.get(j));
                break;
            }
        }
    }

    private List<String> ArrayToList(String[] participant) {
        List<String> list = new ArrayList<>();
        for(String person: participant){list.add(person);}
        return list;
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
