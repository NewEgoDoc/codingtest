package coding.test.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Lv2영어끝말잇기 {
    List<Integer> list = null;
    int N = 0;
    String[] wordArray = null;

    public int[] solution(int n, String[] words) {
        list = new ArrayList<>();
        wordArray = words.clone();
        N = n;
        for (int i = 1; i < words.length; i++) {

            boolean isConnected = isChainedTwoWords(i);
            if(!isConnected) {
                addAnswer(i);
                return answerListToArray();
            }


            boolean isDuplicated = isDuplicatedWords(i);
            if(isDuplicated) {
                addAnswer(i);
                return answerListToArray();
            }
        }
        return new int[]{0,0};
    }

    private boolean isDuplicatedWords(int index) {
        for (int j = 0; j < index; j++) {
            if(wordArray[index].equals(wordArray[j])) {
                return true;
            }
        }
        return false;
    }

    private boolean isChainedTwoWords(int index) {
        //1.이전 글자의 마지막 글자
        char previousLastLetter = wordArray[index-1].charAt(wordArray[index-1].length()-1);
        //2.현재 글자의 첫번째 글자
        char presentFirstLetter = wordArray[index].charAt(0);
        if(previousLastLetter != presentFirstLetter){

            return false;
        }
        return true;
    }

    private void addAnswer(int i) {
        list.add(i%N + 1);
        list.add(i/N + 1);
    }

    private int[] answerListToArray() {
        int[] array = new int[2];
        for(int i = 0; i < 2; i++){
            array[i] = list.get(i);
        }
        return array;
    }

    @Test
    public void test(){
        Assertions.assertArrayEquals(solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}),new int[]{3,3});
        Assertions.assertArrayEquals(solution(5,new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}),new int[]{0,0});
        Assertions.assertArrayEquals(solution(2,new String[]{"hello", "one", "even", "never", "now", "world", "draw"}),new int[]{1,3});
    }
}
