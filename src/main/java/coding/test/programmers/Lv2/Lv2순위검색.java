package coding.test.programmers.Lv2;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class Lv2순위검색 {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoreMap = buildScoreMap(info);
        int[] answer = new int[query.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = count(query[i], scoreMap);
        }
        return answer;
    }

    private int count(String query, Map<String, List<Integer>> scoreMap) {
        String[] tokens = query.split(" (and )? ");
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        if(!scoreMap.containsKey(key)) return 0;
        List<Integer> scores = scoreMap.get(key);

        int score = Integer.parseInt(tokens[tokens.length - 1]);

        return scores.size() - binarySearch(score, scoreMap.get(key));
    }

    private int binarySearch(int score, List<Integer> scores){
        int start = 0;
        int end = scores.size() -1;

        while(end > start){
            int mid = (start + end) / 2;

            if(scores.get(mid) >= score){
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if(scores.get(start) < score){
            return scores.size();
        }

        return start;
    }

    private Map<String, List<Integer>> buildScoreMap(String[] info) {
        Map<String, List<Integer>> scoreMap = new HashMap<>();
        
        for(String s: info){
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            forEachKey(0, "", tokens, key -> {
                scoreMap.putIfAbsent(key, new ArrayList<>());
                scoreMap.get(key).add(score);
            });
        }
        
        for(List<Integer> list: scoreMap.values()){
            Collections.sort(list);
        }
        return scoreMap;
    }

    private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
        if(index == tokens.length - 1){
            action.accept(prefix);
            return;
        }
        
        forEachKey(index+1, prefix + tokens[index], tokens, action);
        forEachKey(index+1, prefix + "-", tokens, action);
    }


    @Test
    void test(){
        Assertions.assertArrayEquals(solution(
                new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"})
                ,
                new int[]{1,1,1,1,2,4});
    }
}
