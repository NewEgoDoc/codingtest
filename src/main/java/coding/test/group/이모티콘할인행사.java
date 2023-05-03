package coding.test.group;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 이모티콘할인행사 {

    int[][] people;
    int[] emti;
    int[] percents = {40, 30, 20, 10};
    int[] result;
    int emoticonPlus;
    int totalCost;
    int maxEmoticonPlus = 0;
    int maxCost;
    int n;
    int index = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        people = users;
        emti = emoticons;
        n = emoticons.length;
        result = new int[n];
        dfs();

        return new int[]{maxEmoticonPlus, maxCost};
    }

    private void dfs(){
        if(index == n){
            emoticonPlus = 0;
            totalCost = 0;

            for (int i = 0; i < people.length; i++) {
                int threshold = people[i][0];
                int price = people[i][1];

                int cost = calculateCostUnder(threshold);

                if(cost >= price){
                    emoticonPlus++;
                } else {
                    totalCost += cost;
                }
            }


            if(maxEmoticonPlus < emoticonPlus){
                maxEmoticonPlus = emoticonPlus;
                maxCost = totalCost;
            } else if(maxEmoticonPlus == emoticonPlus && maxCost < totalCost){
                maxCost = totalCost;
            }

            return;
        }
        for (int i = 0; i < percents.length; i++) {
            result[index] = percents[i];
            index++;
            dfs();
            index--;
        }
    }


    private int calculateCostUnder(int threshold) {
        int cost = 0;
        for (int j = 0; j < n; j++) {
            if(result[j] < threshold){
                continue;
            }
            int calCost = (100-result[j])*emti[j]/100;
            cost += calCost;
        }

        return cost;
    }

    @Test
    void test(){
        Assertions.assertArrayEquals(solution(new int[][]{{40, 10000},{25, 10000}},
                new int[]{7000, 9000}),
                new int[]{1, 5400});
        Assertions.assertArrayEquals(solution(new int[][]{{40, 2900},{23, 10000},{11, 5200},{5, 5900},{40, 3100},{27, 9200},{32, 6900}},
                new int[]{1300, 1500, 1600, 4900}),
                new int[]{4, 13860});
    }
}
