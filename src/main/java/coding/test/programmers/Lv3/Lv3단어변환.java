package coding.test.programmers.Lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class Lv3단어변환 {
    int min;
    public int solution(String begin, String target, String[] words) {
        min = 51;
        boolean visited[] = new boolean[words.length];
        dfs(begin, target, words,0,visited);
        return min == 51? 0:min;
    }

    private void dfs(String word, String target, String[] words, int index, boolean[] visited) {
        if(word.equals(target)){
            System.out.println("word = " + word);
            System.out.println("target = " + target);
            System.out.println("index = " + index);
            if(index < min) min = index;
        }
        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && isOneDifferent(word, words[i])){
                visited[i] = true;
                dfs(words[i],target,words,index + 1, visited);
                visited[i] = false;
            }
        }
    }

    private boolean isOneDifferent(String word, String another) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != another.charAt(i)) count++;
        }
        return (count < 2);
    }

    /*int min;

    public int solution(String begin, String target, String[] words) {
        min = 51;
        boolean visited[] = new boolean[words.length];
        dfs(begin,target,0,words,visited);
        return min == 51? 0 : min;
    }

    private void dfs(String word, String target, int count, String[] words, boolean[] visited) {
        if(word.equals(target)){
            System.out.println("word = " + word);
            System.out.println("target = " + target);
        System.out.println("count = " + count);
            if(count < min) min = count;
        }

        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && check(word,words[i])){
                visited[i] = true;
                dfs(words[i],target,count + 1, words, visited);
                visited[i] = false;
            }
        }
    }

    private boolean check(String word, String nextWord) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != nextWord.charAt(i)) count++;
        }
        return (count <= 1);
    }
    */
    @Test
    public void test(){
        //(solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}),4);
        assertEquals(solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log"}),0);
    }

}
