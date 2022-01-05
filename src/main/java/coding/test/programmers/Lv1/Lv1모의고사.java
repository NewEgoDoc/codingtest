package coding.test.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Lv1모의고사 {

    int[] person1 = {1,2,3,4,5};
    int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        return compareThreePeoplesAnswers(answers);
    }

    private int[] compareThreePeoplesAnswers(int[] answers) {
        int num1 = checkProblemsOfPerson1(answers);
        int num2 = checkProblemsOfPerson2(answers);
        int num3 = checkProblemsOfPerson3(answers);
        int max = getMaxNumber(num1, num2, num3);

        return getArrayofPeope(num1,num2,num3,max);
    }

    private int[] getArrayofPeope(int num1, int num2, int num3, int max) {
        List<Integer> list = new ArrayList<>();
        if(max == num1) list.add(1);
        if(max == num2) list.add(2);
        if(max == num3) list.add(3);

        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private int getMaxNumber(int num1, int num2, int num3) {
        int max = 0;
        if(num1 > max) max = num1;
        if(num2 > max) max = num2;
        if(num3 > max) max = num3;
        return max;
    }

    private int checkProblemsOfPerson1(int[] answers) {
        int answer = 0;
        for (int i = 0; i < answers.length; i++) {
            if(person1[i%person1.length] == answers[i]) answer++;
        }
        return answer;
    }
    private int checkProblemsOfPerson2(int[] answers) {
        int answer = 0;
        for (int i = 0; i < answers.length; i++) {
            if(person2[i%person2.length] == answers[i]) answer++;
        }
        return answer;
    }
    private int checkProblemsOfPerson3(int[] answers) {
        int answer = 0;
        for (int i = 0; i < answers.length; i++) {
            if(person3[i%person3.length] == answers[i]) answer++;
        }
        return answer;
    }

    @Test
    public void test(){
        Assertions.assertArrayEquals(solution(new int[]{1, 2, 3, 4, 5}),new int[]{1});
        Assertions.assertArrayEquals(solution(new int[]{1, 3, 2, 4, 2}),new int[]{1, 2, 3});
    }
}
